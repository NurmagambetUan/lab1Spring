package net.alterapp.miniproject.service;

import net.alterapp.miniproject.domain.Customer;
import net.alterapp.miniproject.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> findAll() {
        return customerRepo.findAllByDeletedAtIsNull();
    }

    public Customer add (Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer findId(Long id){
        return customerRepo.findByIdAndDeletedAtIsNull(id);
    }

    public Customer update (Customer customer){
        customerRepo.save(customer);
        return customer;
    }

    public void delete(Long id){
        Customer customer = customerRepo.findByIdAndDeletedAtIsNull(id);
        Date date = new Date();
        customer.setDeletedAt(date);
        customerRepo.save(customer);
    }

}
