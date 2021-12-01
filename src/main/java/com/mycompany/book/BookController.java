package com.mycompany.book;

import com.mycompany.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Service
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/books")
    public String showUserList(Model model) {
        List<Book> listBooks = service.listAll();
        model.addAttribute("listBooks", listBooks);
        return "books";
    }

    @GetMapping("/books/new")
    public String showNewFrom(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("pageTitle", "Add New Book");
        return "book_from";
    }

    @PostMapping("/books/save")
    public String saveUser(Book book, RedirectAttributes ra) {
        service.save(book);
        ra.addFlashAttribute("message", "The book has been saved successfully.");
        return "redirect:/books";
    }

    /**
     * Immplementation of updated and delete
     */

    @GetMapping("/books/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Book book = service.get(id);
            model.addAttribute("book", book);
            model.addAttribute("pageTitle", "Edit Book (ID: " + id + ")");

            return "book_from";
        } catch (BookNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/books";
        }
    }

    @GetMapping("/books/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The user id" + id + "has been deleted");
        } catch (BookNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";

    }


}
