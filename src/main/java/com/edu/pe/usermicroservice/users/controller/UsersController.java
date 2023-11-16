package com.edu.pe.usermicroservice.users.controller;

import com.crudjpa.controller.CrudController;
import com.crudjpa.enums.MapFrom;
import com.crudjpa.util.HttpStatusCheckCode;
import com.edu.pe.usermicroservice.orders.client.IOrderClient;
import com.edu.pe.usermicroservice.trips.client.ITripClient;
import com.edu.pe.usermicroservice.users.domain.model.User;
import com.edu.pe.usermicroservice.users.domain.service.IUserService;
import com.edu.pe.usermicroservice.users.exception.InvalidCreateResourceException;
import com.edu.pe.usermicroservice.users.exception.InvalidRequestException;
import com.edu.pe.usermicroservice.users.mapping.UserMapper;
import com.edu.pe.usermicroservice.users.resources.CreateUserResource;
import com.edu.pe.usermicroservice.users.resources.UpdateUserResource;
import com.edu.pe.usermicroservice.users.resources.UserResource;
import com.edu.pe.usermicroservice.users.resources.request.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${tripstore.users-service.path}")
public class UsersController extends CrudController<User, Long, UserResource, CreateUserResource, UpdateUserResource> {
    private final IUserService userService;
    private final ITripClient tripClient;
    private final IOrderClient orderClient;

    public UsersController(IUserService userService, UserMapper mapper, ITripClient tripClient, IOrderClient orderClient) {
        super(userService, mapper);
        this.userService = userService;
        this.tripClient = tripClient;
        this.orderClient = orderClient;
    }

    private void validateUserExists(String username) {
        Optional<User> user = userService.findUserByUsername(username);
        if(user.isPresent())
            throw new InvalidCreateResourceException("A user with username %s already exists".formatted(username));

    }

    @Override
    protected boolean isValidCreateResource(CreateUserResource createUserResource) {
        validateUserExists(createUserResource.getUsername());
        return true;
    }

    @Override
    protected boolean isValidUpdateResource(UpdateUserResource updateUserResource) {
        if(updateUserResource.getUsername() != null)
            validateUserExists(updateUserResource.getUsername());
        return true;
    }

    @RequestMapping(value = "healthcheck", method = RequestMethod.HEAD)
    ResponseEntity<Void> isOk() {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        return getById(id);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResource>> getAllUsers() {
        return getAll();
    }

    private void validateBindingResult(BindingResult result) {
        if(result.hasErrors())
            throw new InvalidCreateResourceException(getErrorsFromResult(result));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> createUser(@Valid @RequestBody CreateUserResource resource, BindingResult result) {
        validateBindingResult(result);
        return insert(resource);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> updateUserById(@PathVariable Long id, @RequestBody UpdateUserResource resource, BindingResult result) {
        validateBindingResult(result);
        return update(id, resource);
    }


    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> deleteUserById(@PathVariable Long id) {

        validateHealthClient(tripClient, "trips");
        validateHealthClient(orderClient, "orders");

        ResponseEntity<UserResource> response = delete(id);
        if(HttpStatusCheckCode.from(response).isOk()) {
            tripClient.deleteTripByUserId(id);
            orderClient.deleteOrdersByUserId(id);
        }
        return response;
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResource> login(@Valid @RequestBody LoginRequest request, BindingResult result) {
        validateBindingResult(result);
        Optional<User> user = userService.findUserByUsernameAndPassword(request.getUsername(), request.getPassword());
        if(user.isEmpty())
            throw new InvalidRequestException("Invalid credentials");

        return ResponseEntity.ok(this.fromModelToResource(user.get(), MapFrom.GET));
    }




}
