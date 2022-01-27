package com.bfrcom.controller;

import com.bfrcom.DAO.BookDAO;
import com.bfrcom.model.Book;
import com.bfrcom.testModel.Person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MvcController {

    @Autowired
    BookDAO bookDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        List<Book> books = bookDAO.findAll();
        uiModel.addAttribute ("books", books);
        return "index";
    }

    /*@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }*/
}
