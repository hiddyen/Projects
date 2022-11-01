package Project1;

public class NoSuchOptionException extends Exception{
    public NoSuchOptionException() {
        super("There is no such option to unload container to");
    }
}
