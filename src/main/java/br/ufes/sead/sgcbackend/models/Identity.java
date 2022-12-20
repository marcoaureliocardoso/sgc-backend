package br.ufes.sead.sgcbackend.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "identities")
public class Identity {
    @Id
    @Column(name = "employee_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private DocumentType documentType;
    private String number;
    @Column(name = "issue_date")
    private Date issueDate;
    private String issuer;
    @Column(name = "issuer_state")
    private String issuerState;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
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
