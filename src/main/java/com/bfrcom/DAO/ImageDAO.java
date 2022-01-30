package com.bfrcom.DAO;

import com.bfrcom.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageDAO extends CrudRepository<Image, Long> {
}
