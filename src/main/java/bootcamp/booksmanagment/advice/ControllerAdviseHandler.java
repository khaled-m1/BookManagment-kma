package bootcamp.booksmanagment.advice;
import bootcamp.booksmanagment.dto.ApiResponce;
import bootcamp.booksmanagment.exsptions.InvalidIdExceptions;
import bootcamp.booksmanagment.exsptions.InvalidPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviseHandler {
    private final Logger log = LoggerFactory.getLogger(ControllerAdviseHandler.class);
    @ExceptionHandler(value = InvalidIdExceptions.class)
    public ResponseEntity<ApiResponce> handlExsptions(InvalidIdExceptions idExceptions){
        String message = idExceptions.getMessage();
        log.info(message);
        return ResponseEntity.status(400).body(new ApiResponce(message,400));
    }
    @ExceptionHandler(value = InvalidPage.class)
    public ResponseEntity<ApiResponce> handlExsptions(InvalidPage invalidPage){
        String message = invalidPage.getMessage();
        log.info(message);
        return ResponseEntity.status(404).body(new ApiResponce(message,404));
    }
    //HttpMessageNotWritableException
    @ExceptionHandler(value = HttpMessageNotWritableException.class)
    public ResponseEntity<ApiResponce> handlExsptions(HttpMessageNotWritableException HTTPMN_W){
        String message = HTTPMN_W.getMessage();
        log.info(message);
        return ResponseEntity.status(500).body(new ApiResponce(message,500));
    }
}
