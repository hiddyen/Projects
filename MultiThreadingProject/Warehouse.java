package Project1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;
public class Warehouse  {
    private String name;
    private static int capacity;
    public static int ID=0;
    public int id;
    Scanner in = new Scanner(System.in);
    static List<StandardContainer> warehouse = new ArrayList<>(capacity);
    static Sender forbiddenSender;

    public static void sortWarehouseContainers(){
        Collections.sort(warehouse,(a,b) ->{
            if(a.WhenAdded==b.WhenAdded) return (a.Sender.getName().compareTo(b.Sender.getName()));
            else return (a.WhenAdded.compareTo(b.WhenAdded));
        });
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", id=" + id +
                ", warehouse=" + warehouse +
                '}';
    }

    public Warehouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.id=++ID;
    }
    public Warehouse(String name, int capacity,List<StandardContainer> warehouse) {
        this.name = name;
        this.capacity = capacity;
        this.warehouse=warehouse;
        this.id=++ID;
    }

    public static void add(StandardContainer container) throws Exception {
        if(container.Sender!=forbiddenSender){
            if (warehouse.size() < capacity && container.Sender.warnings<2 && container.Sender!=forbiddenSender) {
                warehouse.add(container);
                container.WhenAdded=Time.getDate();
                container.start();
            } else{
                if(container.Sender.warnings>=2){
                    forbiddenSender=container.Sender;
                    throw new IrresponsibleSenderException();
                }
                throw new TooManyContainersException();
            }
        } else throw new IrresponsibleSenderException();


    }

    public int getId(){
        return this.id;
    }
    public static void WarehouseFile(){
        BufferedWriter s =null;
       Warehouse.sortWarehouseContainers();
        try {
            s = new BufferedWriter(new FileWriter("Warehouse.txt"));
            for(StandardContainer e : warehouse){
                s.write(e + "\n");
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
