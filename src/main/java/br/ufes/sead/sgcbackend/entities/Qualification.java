package br.ufes.sead.sgcbackend.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "qualifications")
public class Qualification {
    @Id
    @Column(name = "bond_id")
    private Long id;
    @Column(name = "knowledge_area")
    private String knowledgeArea;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "institution_name")
    private String institutionName;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    public Qualification() {
        // Required by Hibernate
    }

    public String getKnowledgeArea() {
        return knowledgeArea;
    }

    public void setKnowledgeArea(String knowledgeArea) {
        this.knowledgeArea = knowledgeArea;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
    
    
}
