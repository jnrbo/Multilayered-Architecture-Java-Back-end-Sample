package com.juniorbarros.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Book extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String author;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private boolean borrowed;

    @Fetch(FetchMode.JOIN)
    @ManyToOne(cascade = CascadeType.ALL)
    private Library library;

    public Book(String author, String title, Genre genre, Library library) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.library = library;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public Library getLibrary() {
        return library;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book)obj;
            EqualsBuilder builder = new EqualsBuilder();
            builder.append(author, book.getAuthor());
            builder.append(title, book.getTitle());
            return builder.build();
        }
        return false;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = baseIdHashCodeBuilder();
        builder.append(author);
        builder.append(title);
        return builder.build();
    }
}