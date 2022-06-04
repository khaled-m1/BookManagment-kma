package bootcamp.booksmanagment.exsptions;

public class InvalidIdExceptions extends RuntimeException{
    public InvalidIdExceptions(String message) {
        super(message);
    }
}
