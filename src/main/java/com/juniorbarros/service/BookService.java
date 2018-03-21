package com.juniorbarros.service;

import java.util.List;

import javax.annotation.Resource;

import com.juniorbarros.model.Book;
import com.juniorbarros.repository.BookRepository;

import org.springframework.transaction.annotation.Transactional;

public class BookService {

    @Transactional(readOnly = true)
    public List<Book> listAll() {
        return repository.listAll();
    }

    @Resource
    private BookRepository repository;
}
