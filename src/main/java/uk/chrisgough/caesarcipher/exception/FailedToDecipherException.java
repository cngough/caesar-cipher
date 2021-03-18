package uk.chrisgough.caesarcipher.exception;

public class FailedToDecipherException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FailedToDecipherException(String errorMessage) {

        super(errorMessage);
    }

}
