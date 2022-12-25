package br.ufes.sead.sgcbackend.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String cpf;
    @NotBlank
    private String name;
    private Character gender;
    @NotBlank
    private String email;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Address address;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Identity identity;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    private static final Set<String> sortKeysSet = Set.of("id", "cpf", "name", "gender", "email");

    public Employee() {
        // Required by Hibernate
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(String cpf, String name, Character gender, String email) {
        this.cpf = cpf;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        this.updatedAt = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = new Date();
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
        this.updatedAt = new Date();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.updatedAt = new Date();
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }

}
