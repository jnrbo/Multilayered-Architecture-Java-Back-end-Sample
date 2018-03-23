package com.juniorbarros.model;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

public class Loan extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(cascade = CascadeType.ALL)
    private Library library;

    private boolean returned;

    public Loan(Person person, Book book, Library library) {
        this.person = person;
        this.book = book;
        this.library = library;
    }

    public Person getPerson() {
        return person;
    }

    public Book getBook() {
        return book;
    }

    public Library getLibrary() {
        return library;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned() {
        this.returned = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Loan) {
            Loan loan = (Loan)obj;
            EqualsBuilder builder = baseIdEqualsBuilder(this);
            builder.append(getPerson(), loan.getPerson());
            builder.append(getLibrary(), loan.getLibrary());
            builder.append(getBook(), loan.getBook());
            return builder.build();
        }
        return false;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = baseIdHashCodeBuilder();
        builder.append(getPerson());
        builder.append(getLibrary());
        builder.append(getBook());
        return builder.build();
    }
}