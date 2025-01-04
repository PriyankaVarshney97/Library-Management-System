package com.priyanka.lms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.lms.Entity.Transaction;
import com.priyanka.lms.ServiceImpl.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/borrow")
    public Transaction borrowBook(@RequestParam Long memberId, @RequestParam Long bookId) {
        return transactionService.borrowBook(memberId, bookId);
    }

    @PostMapping("/return/{id}")
    public Transaction returnBook(@PathVariable Long id) {
        return transactionService.returnBook(id);
    }
}
