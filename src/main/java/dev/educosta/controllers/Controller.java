package dev.educosta.controllers;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import dev.educosta.database1.BookDTO;
import dev.educosta.database1.BookRepository;
import dev.educosta.database1.QBookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("book/{id}")
    BookDTO readById(@PathVariable long id) {
        var qbook = QBookDTO.bookDTO;
        return bookRepository.findOne(qbook.id.eq(id)).orElse(null);
    }

    @GetMapping("books/author/{author}")
    Page<BookDTO> readAllBookPaged(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @PathVariable String author) {

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(QBookDTO.bookDTO.author.name.eq(author));

        return bookRepository.findAll(booleanBuilder.getValue(),
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));

    }

    /**
     * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#core.web.type-safe
     * https://github.com/spring-projects/spring-data-examples/tree/main/web/querydsl
     */
    @GetMapping("books/author/simplified")
    Page<BookDTO> readAllBookPagedSimplified(
            @QuerydslPredicate(root = BookDTO.class) Predicate predicate,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {

        return bookRepository.findAll(predicate,
                PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id")));


    }

}


