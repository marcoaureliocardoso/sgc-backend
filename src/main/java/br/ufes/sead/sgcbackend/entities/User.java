package br.ufes.sead.sgcbackend.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    @JsonIgnore
    private String password;
    private Boolean active;
    @Column(name = "email_verified_at")
    private Instant emailVerifiedAt;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @JsonIgnore
    @Column(name = "remember_token")
    private String rememberToken;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    @OneToMany
    private List<Responsibility> responsibilities = new ArrayList<>();

    private static final Set<String> sortKeysSet = Set.of("id", "login", "active");

    public User() {
        // Required by Hibernate
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }

}
