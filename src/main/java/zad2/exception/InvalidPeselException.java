package zad2.exception;

public class InvalidPeselException extends RuntimeException{

    public InvalidPeselException(String message) {
        super(message);
    }
}
