package com.bfrcom.DAO;

import com.bfrcom.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<Book, Long> {
}
