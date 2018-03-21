package com.juniorbarros.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.juniorbarros.model.AttrsVals;
import com.juniorbarros.model.Book;

public class BookRepository extends AbstractRepository<Book> {

	@Transactional(readOnly = true)
    public List<Book> listBooksByAuthor(Long libraryId, String author) {
        return find(
                new AttrsVals()
                        .add("library.id", libraryId)
                        .add("author", author)
        );
    }
	
	@Transactional(readOnly = true)
    public List<Book> listBooksByTitle(Long libraryId, String author) {
        return find(
                new AttrsVals()
                        .add("library.id", libraryId)
                        .add("title", author)
        );
    }
}