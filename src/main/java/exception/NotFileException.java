package exception;

public class NotFileException extends Exception {
    public NotFileException() {
    }
    public  NotFileException(String message){
        super(message);
    }
    public NotFileException(Throwable cause){
        super(cause);
    }
    public NotFileException(String message, Throwable cause){
        super(message,cause);
    }
}
