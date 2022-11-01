package Project1;
import java.awt.image.BufferedImageFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sender {
    private String name;
    private String surname;
    private String pesel;
    private String adress;
    public  int warnings=0;
    public static List<Sender> senders = new ArrayList<>(10);
    public Sender(String name, String surname, String pesel, String adress) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.adress = adress;
        senders.add(this);
    }
    public String getName(){
        return name;
    }

    public LocalDate DateOfBirth() throws Exception{
        char tmp[] = pesel.toCharArray();
        if(tmp.length!=11)throw new WrongPesel();
            int year = (int)((tmp[2]-48)/2);
            int month = (int)((tmp[2]-48)*10 + (tmp[3]-48))%20;
            int day = (tmp[4]-48)*10 + (tmp[5]-48);
        year = year + (tmp[0]-48)*10+(tmp[1]-48);
        LocalDate odp = LocalDate.of(year,month,day);
        return odp;
    }
    @Override
    public String toString() {
        return "Sender{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
    public static void sendersFile(){
        BufferedWriter s = null;
        try{
            s = new BufferedWriter(new FileWriter("Senders.txt"));
            for(Sender e : senders){
                s.write(e + "\n");
            }

            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
