package bootcamp.booksmanagment.service;

import bootcamp.booksmanagment.exsptions.InvalidIdExceptions;
import bootcamp.booksmanagment.model.Books;
import bootcamp.booksmanagment.model.Loan;
import bootcamp.booksmanagment.model.MyUser;
import bootcamp.booksmanagment.repository.BookRepository;
import bootcamp.booksmanagment.repository.LoanRepository;
import bootcamp.booksmanagment.repository.MyUserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final MyUserRepository myUserRepository;
    private final LoanRepository loanRepository;
    private final Logger log = LoggerFactory.getLogger(BookService.class);
    // find all
    public List<Books> getBooks() {
        log.error("Error in get books");
        return bookRepository.findAll();
    }
    // add book
    public Books addBooks(Books books) {
        log.error("Error in add books");
      return bookRepository.save(books);
    }
    // get book ID
    public Books getbookId(Long bookId) {
        log.error("Error in get books ID");
        Optional<Books> books = bookRepository.findById(bookId);
        if (books.isEmpty()){
            throw new InvalidIdExceptions("Invalid ID :(");
        }
        return books.get();
    }
    // loan book
    public void loanBook(Long bookId, Long userId) {
        MyUser myUser = myUserRepository.findById(userId).get();
        if (myUser.equals(null)){
            throw new InvalidIdExceptions("Invalid ID :(");
        }
        Books books = bookRepository.findById(bookId).get();
        if (books.equals(null)){
            throw new InvalidIdExceptions("Invalid ID :(");
        }
        Loan loan = new Loan(null,userId,bookId,null);
        loanRepository.save(loan);
    }
}
