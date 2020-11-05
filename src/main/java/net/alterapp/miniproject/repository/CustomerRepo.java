package net.alterapp.miniproject.repository;

import net.alterapp.miniproject.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    List<Customer> findAllByDeletedAtIsNull();
    Customer findByIdAndDeletedAtIsNull(Long id);
}
