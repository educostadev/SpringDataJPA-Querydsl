package dev.educosta;

import dev.educosta.database1.AuthorDTO;
import dev.educosta.database1.BookDTO;
import dev.educosta.database1.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) {
        log.info("Initializing database");
        var a1 = new AuthorDTO(1L, "Lewis");
        var b1 = new BookDTO(1L, "Narnia", a1);
        var b2 = new BookDTO(2L, "The Reading Life", a1);
        bookRepository.save(b1);
        bookRepository.save(b2);
    }
}
