package Project1;

public class NoSuchContainerOnShipException extends Exception{
    public NoSuchContainerOnShipException() {
        super("There is no such container on the ship !");
    }
}
