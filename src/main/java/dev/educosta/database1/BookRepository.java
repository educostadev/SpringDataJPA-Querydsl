package dev.educosta.database1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Long> , QuerydslPredicateExecutor<BookDTO> {
}
