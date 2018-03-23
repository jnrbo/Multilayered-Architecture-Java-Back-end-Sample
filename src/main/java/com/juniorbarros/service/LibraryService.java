package com.juniorbarros.service;

import java.util.List;

import javax.annotation.Resource;

import com.juniorbarros.model.Assert;
import com.juniorbarros.model.Book;
import com.juniorbarros.model.Genre;
import com.juniorbarros.model.Library;
import com.juniorbarros.model.Loan;
import com.juniorbarros.model.Person;
import com.juniorbarros.repository.BookRepository;
import com.juniorbarros.repository.LibraryRepository;
import com.juniorbarros.repository.LoanRepository;
import com.juniorbarros.repository.PersonRepository;

import org.springframework.transaction.annotation.Transactional;

public class LibraryService {

    @Transactional
    public Library create(int booksCapacity) {
        Library library = new Library(booksCapacity);
        return repository.save(library);
    }

    @Transactional
    public Book addBook(Long libraryId, String title, String author, String genre) {
        Library library = repository.findById(libraryId);
        Book book = new Book(author, title, Genre.valueOf(genre), library);
        library.addBook(book);

        bookRepository.save(book);
        repository.save(library);

        return book;
    }

    @Transactional(readOnly = true)
    public List<Book> listLibraryBooks(Long libraryId) {
        return bookRepository.listBooksByLibrary(libraryId);
    }

    @Transactional(readOnly = true)
    public List<Book> listBooksByAuthor(Long libraryId, String authorName) {
        return bookRepository.listBooksByAuthor(libraryId, authorName);
    }

    @Transactional(readOnly = true)
    public List<Book> listBooksByTitle(Long libraryId, String title) {
        return bookRepository.listBooksByTitle(libraryId, title);
    }

    @Transactional
    public Book loanBook(Long personId, Long libraryId, Long bookId) {
        Book book = bookRepository.findById(bookId);
        Assert.isFalse(book.isBorrowed(), "Livro já emprestado!");

        Person person = personRepository.findById(personId);
        Library library = repository.findById(libraryId);

        library.borrowBook(book);

        Loan loan = new Loan(person, book, library);

        loanRepository.save(loan);
        bookRepository.save(book);

        return book;
    }

    @Transactional
    public Book returnBook(Long personId, Long libraryId, Long bookId) {
        Book book = bookRepository.findById(bookId);
        Assert.isTrue(book.isBorrowed(), "Livro não estava emprestado!");

        Person person = personRepository.findById(personId);
        Library library = repository.findById(libraryId);

        library.returnBook(book);

        Loan loan = loanRepository.find(person, library, book);
        loan.setReturned();

        loanRepository.save(loan);
        bookRepository.save(book);

        return book;
    }

    @Resource
    private LibraryRepository repository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private PersonRepository personRepository;

    @Resource
    private LoanRepository loanRepository;
}
