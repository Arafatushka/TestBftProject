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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Book> list() {
        return bookDAO.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Book findById(@PathVariable int id) {
        return bookDAO.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Book create(@RequestBody Book book) {
        return bookDAO.update(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Book update(@RequestBody Book book, @PathVariable int id) {
        return bookDAO.update(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable int id) {
        bookDAO.delete(id);
    }
}