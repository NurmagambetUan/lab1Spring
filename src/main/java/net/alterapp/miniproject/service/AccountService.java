package net.alterapp.miniproject.service;

import net.alterapp.miniproject.domain.Account;
import net.alterapp.miniproject.repository.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public List<Account> findAll() {
        return accountRepo.findAllByDeletedAtIsNull();
    }


    public Account add(Account account) {
            accountRepo.save(account);
            return account;
        }

    public Account findId (Long id){
        return accountRepo.findByIdAndDeletedAtIsNull(id);
    }

    public String update (Long id, int pin){
        Account account = accountRepo.findByIdAndDeletedAtIsNull(id);
        account.setPin(pin);
        accountRepo.save(account);
        return "updated";
    }
    public void delete (Long id) {
            Account account = accountRepo.findByIdAndDeletedAtIsNull(id);
            Date date = new Date();
            account.setDeletedAt(date);
            accountRepo.save(account);
        }
    }

