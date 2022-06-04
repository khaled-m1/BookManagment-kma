package bootcamp.booksmanagment.controller;
import bootcamp.booksmanagment.dto.ApiResponce;
import bootcamp.booksmanagment.model.Loan;
import bootcamp.booksmanagment.service.LoanService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/loan")
@AllArgsConstructor
public class LoanController {
    private final LoanService loanService;
    private final Logger log = LoggerFactory.getLogger(LoanController.class);
    // find all
    @GetMapping
    public List<Loan> getLoans(){
        log.info("get all loans");
        return loanService.getLoans();
    }
    // add loan
    @PostMapping
    public ResponseEntity<ApiResponce> addLoans(@RequestBody @Valid Loan loan){
        loanService.addLoans(loan);
        log.info("add loans");
        return ResponseEntity.status(201).body(new ApiResponce("your request Accepted :)",201));
    }
    // add book to loan
    @PostMapping("/{loanId}/{bookId}")
    public ResponseEntity addBooksLoans(@PathVariable Long loanId,
                                        @PathVariable Long bookId){
        loanService.addBooksLoans(loanId,bookId);
        log.info("add books to loans");
        return ResponseEntity.status(201).body(loanService.addBooksLoans(loanId,bookId));
    }
    // landed book
    @PostMapping("/{loanId}/{bookId}")
    public ResponseEntity landedBooksLoans(@PathVariable Long loanId,
                                        @PathVariable Long bookId){
        loanService.landedBooksLoans(loanId,bookId);
        log.info("add books to loans");
        return ResponseEntity.status(201).body(loanService.addBooksLoans(loanId,bookId));
    }
}
