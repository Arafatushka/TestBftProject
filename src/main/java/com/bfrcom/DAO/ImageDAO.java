package com.bfrcom.DAO;

import com.bfrcom.model.Image;

import java.util.List;

public interface ImageDAO {

    Image findById(Integer id);

    List<Image> findAll();

    void insert(Image book);

    Image update(Image book);

    void delete(int id);
}
