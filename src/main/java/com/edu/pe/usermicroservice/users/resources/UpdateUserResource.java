package com.edu.pe.usermicroservice.users.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResource {
    @Size(max = 30)
    private String username;

    @Size(max = 30)
    private String password;

    @Size(max = 30)
    private String name;

    @Size(max = 30)
    private String lastname;

    @Email
    @Size(max = 50)
    private String email;

    @Size(max = 9)
    private String phone;
}
