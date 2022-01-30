package com.bfrcom.controller.rest;

import com.bfrcom.DAO.ImageDAO;
import com.bfrcom.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@RestController()
@RequestMapping("api/image")
public class ImagesRestController {

    @Autowired
    ImageDAO imageDAO;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Image> list() {
        return newArrayList(imageDAO.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Image findById(@PathVariable Long id) {
        return imageDAO.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Image create(@RequestBody Image image) {
        return imageDAO.save(image);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Image update(@RequestBody Image image, @PathVariable Long id) {
        return imageDAO.save(image);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        imageDAO.delete(id);
    }
}