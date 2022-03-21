package by.lamaka.springmvc.exception;

public class BookAlreadyExistException extends RuntimeException{

    public BookAlreadyExistException(String message) {
        super(message);
    }
}
