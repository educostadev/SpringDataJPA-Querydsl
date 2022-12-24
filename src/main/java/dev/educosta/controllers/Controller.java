package dev.educosta.controllers;

import dev.educosta.database1.BookDTO;
import dev.educosta.database1.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("books/readall")
    List<BookDTO> readAllBooks() {
        return bookRepository.findAll();
    }

}
