package br.ufes.sead.sgcbackend.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @Min(0)
    @Column(name = "grant_value")
    private Integer grantValue;
    @Column(name = "grant_type")
    private Character grantType;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    private static final Set<String> sortKeysSet = Set.of("id", "name", "grant_type");

    public Role() {
        // Required by Hibernate
    }

    public String getName() {
        return name;
    }

    public Character getGrantType() {
        return grantType;
    }

    public void setGrantType(Character grantType) {
        this.grantType = grantType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGrantValue() {
        return grantValue;
    }

    public void setGrantValue(Integer grantValue) {
        this.grantValue = grantValue;
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }

}
