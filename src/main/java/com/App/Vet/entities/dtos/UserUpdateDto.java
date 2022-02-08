package com.App.Vet.entities.dtos;

import com.App.Vet.entities.concretes.Information;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private String firstName;
    private String lastName;
    private Information information;
}
