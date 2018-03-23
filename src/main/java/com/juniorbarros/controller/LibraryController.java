package com.juniorbarros.controller;

import java.util.List;

import javax.annotation.Resource;

import com.juniorbarros.model.Book;
import com.juniorbarros.model.Library;
import com.juniorbarros.service.LibraryService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @RequestMapping(method = RequestMethod.POST)
    public Library create(int booksCapacity) {
        return service.create(booksCapacity);
    }

    @RequestMapping(value = "{libraryId}/books", method = RequestMethod.GET)
    public List<Book> listLibraryBooks(@PathVariable Long libraryId) {
        return service.listLibraryBooks(libraryId);
    }

    @RequestMapping(value = "{libraryId}/book", method = RequestMethod.POST)
    public Book addBook(@PathVariable Long libraryId, @RequestParam String title, @RequestParam String author, @RequestParam String genre) {
        return service.addBook(libraryId, title, author, genre);
    }

    @RequestMapping(value = "/{book}/title/{title}", method = RequestMethod.GET)
    public List<Book> listBooksByTitle(@PathVariable Long libraryId, @PathVariable String title) {
        return service.listBooksByTitle(libraryId, title);
    }

    @RequestMapping(value = "/{book}/author/{authorName}", method = RequestMethod.GET)
    public List<Book> listBooksByAuthor(@PathVariable Long libraryId, @PathVariable String authorName) {
        return service.listBooksByAuthor(libraryId, authorName);
    }

    @RequestMapping(value = "/{libraryId}/loan/{personId}/{bookId}", method = RequestMethod.POST)
    public Book loanBook(@PathVariable Long personId, @PathVariable Long libraryId, @PathVariable Long bookId) {
        return service.loanBook(personId, libraryId, bookId);
    }

    @RequestMapping(value = "/{libraryId}/return/{personId}/{bookId}", method = RequestMethod.POST)
    public Book returnBook(@PathVariable Long personId, @PathVariable Long libraryId, @PathVariable Long bookId) {
        return service.returnBook(personId, libraryId, bookId);
    }

    @Resource
    private LibraryService service;
}