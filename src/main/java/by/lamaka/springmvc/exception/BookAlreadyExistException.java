package by.lamaka.springmvc.exception;

public class BookAlreadyExistException extends Exception{

    public BookAlreadyExistException(String message) {
        super(message);
    }
}
