package com.bfrcom.controller.rest;

import com.bfrcom.DAO.UserDAO;
import com.bfrcom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController()
@RequestMapping("api/user")
public class UsersRestController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> list() {
        return userDAO.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable String name) {
        return userDAO.findByName(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public User create(@RequestBody User book) {
        return userDAO.update(book);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    @ResponseBody
    public User update(@RequestBody User book, @PathVariable String name) {
        return userDAO.update(book);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String name) {
        userDAO.delete(name);
    }
}
