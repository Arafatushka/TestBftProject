package com.bfrcom.DAO;

import com.bfrcom.model.Book;

import java.util.List;

public interface BookDAO {

    Book findById(Long id);
    List<Book> findAll();

}
