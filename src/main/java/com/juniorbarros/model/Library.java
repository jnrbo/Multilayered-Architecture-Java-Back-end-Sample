package com.juniorbarros.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Library extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_BOOKS_CAPACITY = 500;

    private int booksCapacity;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ArrayList<Book> books;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ArrayList<Loan> loans;

    public Library() {
        this(DEFAULT_BOOKS_CAPACITY);
    }

    public Library(int booksCapacity) {
        this.books = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.booksCapacity = booksCapacity;
    }

    public void addBook(Book book) {
        if (books.size() <= getBooksCapacity()) {
            books.add(book);
        } else {
            throw new OverflowException("Biblioteca já está no seu limite máximo de livros!");
        }
    }

    public void borrowBook(Book theBook) {
        setBookBorrowed(theBook, true);
    }

    public void returnBook(Book theBook) {
        setBookBorrowed(theBook, false);
    }

    private void setBookBorrowed(Book theBook, boolean borrowed) {
        for (Book book : books) {
            if (book.equals(theBook)) {
                book.setBorrowed(borrowed);
            }
        }
    }

    public int getBooksCapacity() {
        return booksCapacity;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Library) {
            Library library = (Library)obj;
            EqualsBuilder builder = baseIdEqualsBuilder(this);
            builder.append(booksCapacity, library.getBooksCapacity());
            return builder.build();
        }
        return false;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = baseIdHashCodeBuilder();
        builder.append(booksCapacity);
        return builder.build();
    }
}