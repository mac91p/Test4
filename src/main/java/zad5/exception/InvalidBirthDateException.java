package zad5.exception;

public class InvalidBirthDateException extends RuntimeException{
    public InvalidBirthDateException(String message) {
        super(message);
    }
}
