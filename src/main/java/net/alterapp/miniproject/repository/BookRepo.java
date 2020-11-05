package net.alterapp.miniproject.repository;

import net.alterapp.miniproject.domain.Book;
import net.alterapp.miniproject.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{
    List<Book> findAllByDeletedAtIsNull();
    Book findByIdAndDeletedAtIsNull(Long id);
    List<Book> findAllByLibraryIdAndDeletedAtIsNull(Long id);
    List<Book> findAllByTitleAndDeletedAtIsNull(String title);

}

