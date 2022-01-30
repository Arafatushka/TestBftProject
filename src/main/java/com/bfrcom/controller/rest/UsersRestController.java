package com.bfrcom.controller.rest;

import com.bfrcom.DAO.UserDAO;
import com.bfrcom.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;
import static org.springframework.data.domain.ExampleMatcher.matching;

@org.springframework.web.bind.annotation.RestController()
@RequestMapping("api/user")
public class UsersRestController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> list() {
        return newArrayList(userDAO.findAll());
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<User> findById(@PathVariable String name) {

        var u = new User();
        u.name = name;

        var example = Example.of(u, matching(). //
                withMatcher("name", ignoreCase()));

        return userDAO.findOne(example);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public User create(@RequestBody User book) {
        return userDAO.save(book);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    @ResponseBody
    public User update(@RequestBody User book, @PathVariable String name) {
        return userDAO.save(book);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String name) {

        var u = new User();
        u.name = name;

        var example = Example.of(u, matching(). //
                withMatcher("name", ignoreCase()));

        userDAO.delete( userDAO.findOne(example).get());
    }
}
