package br.ufes.sead.sgcbackend.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "identities")
public class Identity {
    @Id
    @Column(name = "employee_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private DocumentType documentType;
    @NotBlank
    private String number;
    @NotBlank
    @Column(name = "issue_date")
    private Instant issueDate;
    @NotBlank
    private String issuer;
    @NotBlank
    @Column(name = "issuer_state")
    private String issuerState;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    public Identity() {
        // Required by Hibernate
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Instant getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Instant issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getIssuerState() {
        return issuerState;
    }

    public void setIssuerState(String issuerState) {
        this.issuerState = issuerState;
    }

}
