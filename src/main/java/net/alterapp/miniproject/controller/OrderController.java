package net.alterapp.miniproject.controller;

import net.alterapp.miniproject.domain.Order;
import net.alterapp.miniproject.exception.ServiceException;
import net.alterapp.miniproject.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")

public class OrderController extends BaseController{
    private final net.alterapp.miniproject.service.OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAll(){
        return buildResponse(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Order order){
        return buildResponse(orderService.add(order), HttpStatus.OK);
    }

    @PostMapping("/add/v2")
    public ResponseEntity<?> addV2(@RequestBody Order order) throws ServiceException {
        return buildResponse(orderService.add_v2(order), HttpStatus.OK);
    }

    @PostMapping("/add/v3")
    public ResponseEntity<?> addV3(@RequestBody Order order) throws ServiceException {
        return buildResponse(orderService.add_v3(order), HttpStatus.OK);
    }

    @GetMapping("/findId")
    public ResponseEntity<?> findId(Long id){
        return buildResponse(orderService.findId(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Order order){
        return buildResponse(orderService.update(order), HttpStatus.OK);
    }

    @PutMapping("/update/v2")
    public ResponseEntity<?> update_v2(@RequestParam Long id){
        return buildResponse(orderService.update_v2(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        orderService.delete(id);
        return buildResponse("deleted", HttpStatus.OK);
    }

}
