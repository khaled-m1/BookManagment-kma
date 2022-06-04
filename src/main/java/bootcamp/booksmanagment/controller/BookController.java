package bootcamp.booksmanagment.controller;
import bootcamp.booksmanagment.dto.ApiResponce;
import bootcamp.booksmanagment.model.Books;
import bootcamp.booksmanagment.service.BookService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final Logger log = LoggerFactory.getLogger(BookController.class);
    // find all
    @GetMapping
    public List<Books> getBooks(){
        log.info("get all books");
        return bookService.getBooks();
    }
    // add book
    @PostMapping
    public ResponseEntity<ApiResponce> addBooks(@RequestBody @Valid Books books){
        bookService.addBooks(books);
        log.info("add book");
        return ResponseEntity.status(201).body(new ApiResponce("your request Accepted :)",201));
    }
    // get book ID
    @GetMapping("/bookid")
    public ResponseEntity<Books> getbookId(Long bookId){
        log.info("get book ID");
        return ResponseEntity.status(200).body(bookService.getbookId(bookId));
    }
    // add book to loan
    @PostMapping("/loanbook/{bookId}/{userId}")
    public ResponseEntity<ApiResponce> loanBook(@PathVariable Long bookId,
                                                @PathVariable Long userId){
        bookService.loanBook(bookId,userId);
        log.info("add loan book");
        return ResponseEntity.status(201).body(new ApiResponce("your request Accepted :)",201));
    }
}
