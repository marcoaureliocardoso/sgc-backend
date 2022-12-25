package br.ufes.sead.sgcbackend.models;

import java.util.Date;
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
@Table(name = "bonds")
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    private Date begin;
    @Column(name = "terminated_at")
    private Date terminatedAt;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getTerminatedAt() {
        return terminatedAt;
    }

    public void setTerminatedAt(Date terminatedAt) {
        this.terminatedAt = terminatedAt;
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }

}
