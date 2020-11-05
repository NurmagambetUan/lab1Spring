package net.alterapp.miniproject.controller;

import net.alterapp.miniproject.domain.Customer;
import net.alterapp.miniproject.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController extends BaseController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAll(){
        return buildResponse(customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Customer customer){
                return buildResponse(customerService.add(customer), HttpStatus.OK);
    }
    @GetMapping("/findId")
    public ResponseEntity<?> getId(@RequestParam Long id){
        return buildResponse(customerService.findId(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Customer customer){
        return buildResponse(customerService.update(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        customerService.delete(id);
        return buildResponse("deleted", HttpStatus.OK);
    }

}
