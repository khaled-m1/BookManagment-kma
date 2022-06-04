package bootcamp.booksmanagment.exsptions;

public class InvalidPage extends RuntimeException{
    public InvalidPage(String message) {
        super(message);
    }
}
