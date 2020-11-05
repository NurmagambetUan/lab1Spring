package net.alterapp.miniproject.repository;

import net.alterapp.miniproject.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long>{
    List<Library> findAllByDeletedAtIsNull();
    Library findByIdAndDeletedAtIsNull(Long id);
    List<Library> findAllByCityAndDeletedAtIsNull(String city);

}
