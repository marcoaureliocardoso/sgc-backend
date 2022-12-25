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
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "related_type")
    private String relatedType;
    @ManyToOne
    @JoinColumn(name = "related_id")
    private Bond related;
    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "file_data")
    private String fileData;

    private static final Set<String> sortKeysSet = Set.of("id", "fileName", "relatedType");

    public Document() {
        // Required by Hibernate
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }

    public Bond getRelated() {
        return related;
    }

    public void setRelated(Bond related) {
        this.related = related;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public static Set<String> getSortKeysSet() {
        return sortKeysSet;
    }

}
