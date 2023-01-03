package br.ufes.sead.sgcbackend.entities;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private Character degree;
    @NotBlank
    @Column(name = "lms_url")
    private String lmsUrl;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    private static final Set<String> sortKeysSet = Set.of("id", "name", "degree");

    public Course() {
        // Required by Hibernate
    }

    public String getName() {
        return name;
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

    public Character getDegree() {
        return degree;
    }

    public void setDegree(Character degree) {
        this.degree = degree;
    }

    public String getLmsUrl() {
        return lmsUrl;
    }

    public void setLmsUrl(String lmsUrl) {
        this.lmsUrl = lmsUrl;
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }

}
