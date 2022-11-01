package Project1;

public class WrongPesel extends Exception{
    public WrongPesel(){
        System.out.println("You provided not possible pesel number");
    }
}
