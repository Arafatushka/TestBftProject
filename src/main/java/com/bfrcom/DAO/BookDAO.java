package com.bfrcom.DAO;

import com.bfrcom.model.Book;

import java.util.List;

public interface BookDAO {

    Book findById(Long id);
   /* List<Book> findAll();

    void insert(Book book);
    void update(Book book);
    void delete(int id);*/
}
