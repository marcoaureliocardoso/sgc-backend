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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "bonds")
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private Boolean volunteer;
    @NotBlank
    @Column(name = "hiring_process")
    private String hiringProcess;
    @NotBlank
    private Instant begin;
    @Column(name = "terminated_at")
    private Instant terminatedAt;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    @OneToOne
    @JoinTable(name = "bond_course", joinColumns = @JoinColumn(name = "bond_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Course course;
    @OneToOne
    @JoinTable(name = "bond_course_class", joinColumns = @JoinColumn(name = "bond_id"), inverseJoinColumns = @JoinColumn(name = "course_class_id"))
    private CourseClass courseClass;
    @OneToMany    
    private List<Impediment> impediments = new ArrayList<>();
    @OneToOne
    @JoinTable(name = "bond_pole", joinColumns = @JoinColumn(name = "bond_id"), inverseJoinColumns = @JoinColumn(name = "pole_id"))
    private Pole pole;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Qualification qualification;

    private static final Set<String> sortKeysSet = Set.of("id", "volunteer", "hiringProcess", "begin");

    public Bond() {
        // Required by Hibernate
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Boolean volunteer) {
        this.volunteer = volunteer;
    }

    public String getHiringProcess() {
        return hiringProcess;
    }

    public void setHiringProcess(String hiringProcess) {
        this.hiringProcess = hiringProcess;
    }

    public Instant getBegin() {
        return begin;
    }

    public void setBegin(Instant begin) {
        this.begin = begin;
    }

    public Instant getTerminatedAt() {
        return terminatedAt;
    }

    public void setTerminatedAt(Instant terminatedAt) {
        this.terminatedAt = terminatedAt;
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }

}
