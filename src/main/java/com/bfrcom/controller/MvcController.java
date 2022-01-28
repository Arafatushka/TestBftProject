package com.bfrcom.controller;

import com.bfrcom.DAO.BookDAO;
import com.bfrcom.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MvcController {

    @Autowired
    BookDAO bookDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        List<Book> books = bookDAO.findAll();
        uiModel.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, Model uiModel) {
        if (bookDAO.findById(id) != null)
            bookDAO.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("book", bookDAO.findById(id));
        return "edit";
    }

    @RequestMapping(value = "update/0", method = RequestMethod.GET)
    public String newForm(Model uiModel) {
        return "edit";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(Book book, BindingResult bindingResult,
                         Model uiModel, HttpServletRequest httpServletRequest,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("book", book);
            return "update";
        }
        bookDAO.update(book);
        return "redirect:/";
    }

}
