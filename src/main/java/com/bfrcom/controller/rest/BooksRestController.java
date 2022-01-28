package com.bfrcom.controller.rest;

import com.bfrcom.DAO.BookDAO;
import com.bfrcom.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController()
@RequestMapping("api/book")
public class BooksRestController {

    @Autowired
    BookDAO bookDAO;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> list() {
        return bookDAO.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book findById(@PathVariable Long id) {
        return bookDAO.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Book create(@RequestBody Book book) {
        return bookDAO.update(book);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Book update(@RequestBody Book book, @PathVariable int id) {
        return bookDAO.update(book);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        bookDAO.delete(id);
    }
}