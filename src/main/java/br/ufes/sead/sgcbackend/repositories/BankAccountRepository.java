package br.ufes.sead.sgcbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufes.sead.sgcbackend.entities.BankAccount;

public interface BankAccountRepository
        extends CrudRepository<BankAccount, Long>, PagingAndSortingRepository<BankAccount, Long> {

}
