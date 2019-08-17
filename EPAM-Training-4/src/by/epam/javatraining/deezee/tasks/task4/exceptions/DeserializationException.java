package by.epam.javatraining.deezee.tasks.task4.exceptions;

public class DeserializationException extends Exception {
    public DeserializationException() {

    }

    public DeserializationException(String message) {
        super (message);
    }

    public DeserializationException(Throwable cause) {
        super (cause);
    }

    public DeserializationException(String message, Throwable cause) {
        super (message, cause);
    }
}
