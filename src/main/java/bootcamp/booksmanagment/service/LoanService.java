package bootcamp.booksmanagment.service;
import bootcamp.booksmanagment.model.Books;
import bootcamp.booksmanagment.model.Loan;
import bootcamp.booksmanagment.repository.BookRepository;
import bootcamp.booksmanagment.repository.LoanRepository;
import bootcamp.booksmanagment.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    private final Logger log = LoggerFactory.getLogger(LoanService.class);
    // find all
    public List<Loan> getLoans() {
        log.error("Error get loan");
        if (loanRepository.findAll().isEmpty()){
            throw new HttpMessageNotWritableException("500 :(");
        }
        return loanRepository.findAll();
    }
    // add loan
    public Loan addLoans(Loan loan) {
        log.error("Error add loan");
        return loanRepository.save(loan);
    }
    // add book to loan
    public Loan addBooksLoans(Long loanId, Long bookId) {
        log.error("Error add book to loan");
        Loan loan = loanRepository.findById(loanId).get();
        Books books = bookRepository.findById(bookId).get();
        loan.getBooks().add(books);
        loanRepository.save(loan);
        return loan;
    }
    // landed book
    public void landedBooksLoans(Long loanId, Long bookId) {
        log.error("Error landed Books Loans");
        Loan loan = loanRepository.findById(loanId).get();
        Books books = bookRepository.findById(bookId).get();
        books.getLoan().add(loan);
        loanRepository.save(loan);
    }
}
