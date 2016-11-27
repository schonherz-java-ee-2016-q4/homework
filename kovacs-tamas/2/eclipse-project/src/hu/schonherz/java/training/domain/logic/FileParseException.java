package hu.schonherz.java.training.domain.logic;

public class FileParseException extends Exception {

    public FileParseException(String message, Throwable exceptionToCover) {
        super(message, exceptionToCover);
    }

}
