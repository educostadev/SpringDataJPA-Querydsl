package dev.educosta;

import dev.educosta.database1.AuthorDTO;
import dev.educosta.database1.BookDTO;
import dev.educosta.database1.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

@Component
@Slf4j
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) {
        log.info("Initializing database");
        var a1 = new AuthorDTO(1L, "Lewis");
        var a2 = new AuthorDTO(2L, "Stephen");
        LongStream.range(0, 30).forEach(id -> {
            BookDTO b1 = null;
            if (id % 2 == 0) {
                b1 = new BookDTO(id, "Book " + id, a1);
            } else {
                b1 = new BookDTO(id, "Book " + id, a2);
            }
            bookRepository.save(b1);
        });


    }
}
