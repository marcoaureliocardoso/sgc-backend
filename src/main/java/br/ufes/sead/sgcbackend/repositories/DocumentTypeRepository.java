package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.DocumentType;

public interface DocumentTypeRepository extends CrudRepository<DocumentType, Integer>{
    
}
