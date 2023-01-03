package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.DocumentType;

public interface DocumentTypeRepository
                extends CrudRepository<DocumentType, Long>, PagingAndSortingRepository<DocumentType, Long> {

}
