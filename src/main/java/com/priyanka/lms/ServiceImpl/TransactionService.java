package com.priyanka.lms.ServiceImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.lms.Entity.Book;
import com.priyanka.lms.Entity.Member;
import com.priyanka.lms.Entity.Transaction;
import com.priyanka.lms.Repository.BookRepository;
import com.priyanka.lms.Repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    public Transaction borrowBook(Long memberId, Long bookId) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.getAvailable()) throw new RuntimeException("Book is not available");

        book.setAvailable(false);
        bookRepository.save(book);

        Transaction transaction = new Transaction();
        transaction.setMember(new Member(memberId));
        transaction.setBook(book);
        transaction.setBorrowDate(LocalDate.now());

        return transactionRepository.save(transaction);
    }

    public Transaction returnBook(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
            .orElseThrow(() -> new RuntimeException("Transaction not found"));

        Book book = transaction.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        transaction.setReturnDate(LocalDate.now());
        return transactionRepository.save(transaction);
    }
}