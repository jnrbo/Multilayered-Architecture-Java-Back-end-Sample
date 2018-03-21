package com.juniorbarros.controller;

import javax.annotation.Resource;

import com.juniorbarros.service.BookService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @Resource
    private BookService service;
}