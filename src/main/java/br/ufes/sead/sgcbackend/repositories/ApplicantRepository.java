package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;

import br.ufes.sead.sgcbackend.models.Applicant;

public interface ApplicantRepository extends CrudRepository<Applicant, Integer> {
    
}
