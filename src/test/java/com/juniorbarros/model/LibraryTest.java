package com.juniorbarros.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LibraryTest {

    @Test
    public void constructorAndMethods() {
        Library library = new Library(30);
        assertEquals(30, library.getBooksCapacity());
        assertTrue(library.getBooks().isEmpty());

        Book guiaDosMochileiros = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", Genre.SCIENCE_FICTION, library);
        Book harryPotter = new Book("Harry Potter e a Pedra Filosofal", "J. K. Rowling", Genre.SCIENCE_FICTION, library);

        library.addBook(guiaDosMochileiros);
        library.addBook(harryPotter);

        assertEquals(2, library.getBooks().size());
    }
}