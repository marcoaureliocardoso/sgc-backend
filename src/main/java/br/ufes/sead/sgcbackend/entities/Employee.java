package br.ufes.sead.sgcbackend.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String cpf;
    @NotBlank
    private String name;
    private Character gender;
    @NotBlank
    private String email;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Address address;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Identity identity;
    @OneToOne
    @PrimaryKeyJoinColumn
    private PersonalDetail personalDetail;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Spouse spouse;
    @OneToOne
    @PrimaryKeyJoinColumn
    private BankAccount bankAccount;
    @OneToOne
    @PrimaryKeyJoinColumn
    private InstitutionalDetail institutionalDetail;
    @OneToMany
    private List<User> users = new ArrayList<>();
    @OneToMany
    private List<Bond> bonds = new ArrayList<>();
    @OneToMany
    private List<Phone> phones = new ArrayList<>();
    
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
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        this.updatedAt = Instant.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = Instant.now();
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
        this.updatedAt = Instant.now();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.updatedAt = Instant.now();
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }

}
