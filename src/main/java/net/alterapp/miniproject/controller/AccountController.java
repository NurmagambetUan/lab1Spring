package net.alterapp.miniproject.controller;

import net.alterapp.miniproject.domain.Account;
import net.alterapp.miniproject.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/account")
public class AccountController extends BaseController {
    private final net.alterapp.miniproject.service.AccountService AccountService;

    public AccountController(AccountService accountService) {
        this.AccountService = accountService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAll() {
        return buildResponse(AccountService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Account account) {
        return buildResponse(AccountService.add(account), HttpStatus.OK);
    }

    @GetMapping("/findId")
    public ResponseEntity<?> getId(@RequestParam Long id){
        return buildResponse(AccountService.findId(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long id,
                                    @RequestParam int pin){
        return buildResponse(AccountService.update(id, pin), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        AccountService.delete(id);
        return buildResponse("deleted", HttpStatus.OK);
    }
}
