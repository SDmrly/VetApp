package com.App.Vet.core.entities;

import com.App.Vet.entities.concretes.Information;
import com.App.Vet.entities.concretes.Pet;
import com.App.Vet.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotEmpty
    private String userName;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "firstname")
    @NotEmpty()
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id"))
    private Collection<Role> roles;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_informations", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "informationid", referencedColumnName = "id"))
    private Information information;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Pet> pets;
}
