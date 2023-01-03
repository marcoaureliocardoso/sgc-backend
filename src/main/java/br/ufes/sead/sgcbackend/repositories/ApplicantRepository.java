package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.Applicant;

public interface ApplicantRepository
                extends CrudRepository<Applicant, Long>, PagingAndSortingRepository<Applicant, Long> {

}
