package net.alterapp.miniproject.repository;

import net.alterapp.miniproject.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{
    List<Account> findAllByDeletedAtIsNull();
    Account findByIdAndDeletedAtIsNull(Long id);
}

