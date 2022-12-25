package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.models.Document;

public interface DocumentRepository
        extends CrudRepository<Document, Integer>, PagingAndSortingRepository<Document, Integer> {

}
