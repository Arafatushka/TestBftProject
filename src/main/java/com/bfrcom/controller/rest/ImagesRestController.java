package com.bfrcom.controller.rest;

import com.bfrcom.DAO.ImageDAO;
import com.bfrcom.DAO.ImageDAO;
import com.bfrcom.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/image")
public class ImagesRestController {

    @Autowired
    ImageDAO imageDAO;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Image> list() {
        return imageDAO.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Image findById(@PathVariable int id) {
        return imageDAO.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Image create(@RequestBody Image image) {
        return imageDAO.update(image);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Image update(@RequestBody Image image, @PathVariable int id) {
        return imageDAO.update(image);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        imageDAO.delete(id);
    }
}