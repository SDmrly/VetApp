package com.App.Vet.entities.concretes;

import com.App.Vet.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "petname")
    @NotEmpty
    private String petName;

    @Column(name = "petage")
    @NotEmpty
    private String petAge;

    @Column(name = "petdescription")
    @NotEmpty
    private String petDescription;

    @Column(name = "petbreed")
    @NotEmpty
    private String petBreed;

    @OneToOne
    @JoinColumn(name = "typeid", referencedColumnName = "id")
    private AnimalType animalType;

    @ManyToOne
    @JoinTable(name = "user_pets", joinColumns = @JoinColumn(name = "petid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"))
    private User user;

}
