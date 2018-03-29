package com.juniorbarros.repository;

import com.juniorbarros.model.AttrsVals;
import com.juniorbarros.model.Book;
import com.juniorbarros.model.Library;
import com.juniorbarros.model.Loan;
import com.juniorbarros.model.Person;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoanRepository extends AbstractRepository<Loan> {

    @Transactional(readOnly = true)
    public Loan find(Person person, Library library, Book book) {
        return findUnique(new AttrsVals().add("person", person).add("library", library).add("book", book));
    }
}
