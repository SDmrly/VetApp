package com.App.Vet.entities.concretes;

import com.App.Vet.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "informations")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @NotEmpty
    private String email;

    @Column(name = "telephone")
    @NotEmpty
    private String telephone;

    @Column(name = "address")
    @NotEmpty
    private String address;

    @OneToOne(mappedBy = "information")
    private User user;
}
