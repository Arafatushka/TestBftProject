package com.bfrcom.controller;

import com.bfrcom.DAO.BookDAO;
import com.bfrcom.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController("api")
public class RestController {

    @Autowired
    BookDAO bookDAO;

    @GetMapping("book")
    public Book[] hi(){

        return  bookDAO.findAll().toArray(new Book[0]);
    }
}
