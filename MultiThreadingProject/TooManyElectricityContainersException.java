package Project1;

public class TooManyElectricityContainersException extends Exception {
    public TooManyElectricityContainersException() {
        super("Too many containers with needed electricity");
    }
}
