package br.ufes.sead.sgcbackend.entities;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "applicants")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    @Column(name = "area_code")
    private String areaCode;
    private String landline;
    @NotBlank
    private String mobile;
    @NotBlank
    @Column(name = "hiring_process")
    private String hiringProcess;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "pole_id")
    private Pole pole;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(name = "call_state")
    private String callState;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    private static final Set<String> sortKeysSet = Set.of("id", "name", "email", "hiringProcess", "callState");

    public Applicant() {
        // Required by Hibernate
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getLandline() {
        return this.landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHiringProcess() {
        return this.hiringProcess;
    }

    public void setHiringProcess(String hiringProcess) {
        this.hiringProcess = hiringProcess;
    }

    public String getCallState() {
        return this.callState;
    }

    public void setCallState(String callState) {
        this.callState = callState;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Pole getPole() {
        return pole;
    }

    public void setPole(Pole pole) {
        this.pole = pole;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }
}
