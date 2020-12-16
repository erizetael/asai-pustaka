package com.ercomp.asailib.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("listBook")
    public String viewBook(Model model) {
        model.addAttribute("listBookDatas", bookService.getAllBooks());
        return "book";
    }

    @GetMapping("/showBookForms")
    public String showBookForm(Model model) {
        // create model attribute to bind form data
        BookModel bookModel = new BookModel();
        model.addAttribute("bookModel", bookModel);
        return "bookInputForm";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("bookModel") BookModel bookModel) {
        // save book data to database
        bookService.saveBook(bookModel);
        return "redirect:/listBook";
    }
}
