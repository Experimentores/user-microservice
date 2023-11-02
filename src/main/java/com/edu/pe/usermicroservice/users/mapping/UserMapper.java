package com.edu.pe.usermicroservice.users.mapping;

import com.crudjpa.mapping.IEntityMapper;
import com.edu.pe.usermicroservice.shared.mapping.EnhancedModelMapper;
import com.edu.pe.usermicroservice.users.domain.model.User;
import com.edu.pe.usermicroservice.users.resources.CreateUserResource;
import com.edu.pe.usermicroservice.users.resources.UpdateUserResource;
import com.edu.pe.usermicroservice.users.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper implements IEntityMapper<User, UserResource, CreateUserResource, UpdateUserResource> {
    @Autowired
    EnhancedModelMapper mapper;
    @Override
    public User fromCreateResourceToModel(CreateUserResource scoreResource) {
        return mapper.map(scoreResource, User.class);
    }

    @Override
    public void fromCreateResourceToModel(CreateUserResource resource, User user) {
        mapper.map(resource, user);
    }

    @Override
    public UserResource fromModelToResource(User score) {
        return mapper.map(score, UserResource.class);
    }

    @Override
    public User fromUpdateResourceToModel(UpdateUserResource user) {
        return mapper.map(user, User.class);
    }

    @Override
    public void fromUpdateResourceToModel(UpdateUserResource updateUserResource, User user) {
        mapper.map(updateUserResource, user);
    }
}
