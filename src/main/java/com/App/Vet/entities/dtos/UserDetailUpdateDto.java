package com.App.Vet.entities.dtos;

import com.App.Vet.entities.concretes.Information;
import com.App.Vet.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailUpdateDto {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private Information information;
    private Collection<Role> roles;
}
