package Project1;

import TestIII.B;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.*;

public class Ship {

    public  void sortShipContainers(){
        Collections.sort(containers,(a,b) ->{
            return (int) (a.getGrossWeight()-b.getGrossWeight());
        });
    }
    public static void sortContainerShips(){
        Collections.sort(ships,(a,b) ->{
           return b.name.compareTo(a.name);
        });
    }

    Scanner in = new Scanner(System.in);
    protected static int NUMBER=0;
    protected int number;
    protected static int TrainCapacity=10;
    protected String name;
    protected String HomePort;
    protected String TransportOrigin;
    protected String destination;
    protected int MaxWeightCapacity;
    protected int MaxNumberOfHeavyContainers;
    protected int MaxNumberOfContainersWithElectricity;
    protected int MaxNumberOfToxicContainersAndExplosive;
    protected int MaxNumberOfContainers;
    public static TimeSkip skip = new TimeSkip();
    public static int x =0;
    public  List<StandardContainer> containers = new ArrayList<>();
    public static List<Ship> ships = new ArrayList<>(10);
    public static List<StandardContainer> train = new ArrayList<>(10);
    public static Ship []shipsT = new Ship[10];
    public Ship(String name,String HomePort,String TransportOrigin, String destination, int MaxWeightCapacity, int MaxNumberOfContainers,int MaxNumberOfHeavyContainers,int MaxNumberOfContainersWithElectricity, int MaxNumberOfToxicContainersAndExplosive){
        this.name=name;
        this.HomePort=HomePort;
    this.TransportOrigin=TransportOrigin;
    this.destination=destination;
    this.number=++NUMBER;
    this.MaxWeightCapacity=MaxWeightCapacity;
    this.MaxNumberOfContainers=MaxNumberOfContainers;
    this.MaxNumberOfContainersWithElectricity=MaxNumberOfContainersWithElectricity;
    this.MaxNumberOfHeavyContainers=MaxNumberOfHeavyContainers;
    this.MaxNumberOfToxicContainersAndExplosive=MaxNumberOfToxicContainersAndExplosive;
    ships.add(this);
    }


    public static void addToShipWithId(int id, StandardContainer container){
        for(int i=0; i<ships.size(); i++){
            if(ships.get(i).getNumber()==id){
                try {
                    ships.get(i).addContainer(container);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public int getNumber(){
        return number;
    }

    public double SumWeight(){
        double sum=0;
        for(StandardContainer e : containers){
            sum=sum+e.GrossWeight;
        }
        return sum;
    }
    public void addContainer(StandardContainer container)throws Exception {
        if(SumWeight()<=MaxWeightCapacity ){
            if(containers.size()<MaxNumberOfContainers){
                if(CountHeavy()<MaxNumberOfHeavyContainers){
                    if(CountElectricity()<MaxNumberOfContainersWithElectricity){
                        if(CountToxicAndExplosive()<MaxNumberOfToxicContainersAndExplosive){
                            containers.add(container);
                            container.WhenAdded=Time.getDate();
                        } else throw new TooManyToxicOrExplosiveContainersException();
                    } else throw new TooManyElectricityContainersException();
                } else throw new TooManyHeavyContainersException();
            }else throw new TooManyContainersException();
        } else throw new TooMuchWeightException();
    }
    public void unloadToTrain(StandardContainer container){
            if(this.containers.contains(container)){
                if(train.size()<10){
                    this.containers.remove(container);
                    train.add(container);
                    x++;
                }
            }
            if(x==10){
                System.out.println("Train is full please wait for another train");
                skip.start();
                train = new ArrayList<StandardContainer>(10);
            }
    }
    public StandardContainer UnloadToWarehouse(StandardContainer container) throws Exception{
        if(containers.contains(container)){
                containers.remove(container);
                return container;
            } else throw new NoSuchContainerOnShipException();
    }

    public int CountHeavy(){
        int count=0;
        for(StandardContainer e : containers){
            if(e instanceof HeavyContainer) count++;
        }
        return count;
    }
    public int CountElectricity(){
        int count=0;
        for(StandardContainer e : containers){
            if(e instanceof RefrigeratedContainer) count++;
        }
        return count;
    }
    public int CountToxicAndExplosive(){
        int count=0;
        for(StandardContainer e : containers){
            if(e instanceof ToxicCargo || e instanceof ExplosiveContainer) count++;
        }
        return count;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "number=" + number +
                ", name='" + name + '\'' +
                ", HomePort='" + HomePort + '\'' +
                ", TransportOrigin='" + TransportOrigin + '\'' +
                ", destination='" + destination + '\'' +
                ", MaxWeightCapacity=" + MaxWeightCapacity +
                ", MaxNumberOfHeavyContainers=" + MaxNumberOfHeavyContainers +
                ", MaxNumberOfContainersWithElectricity=" + MaxNumberOfContainersWithElectricity +
                ", MaxNumberOfToxicContainersAndExplosive=" + MaxNumberOfToxicContainersAndExplosive +
                ", MaxNumberOfContainers=" + MaxNumberOfContainers +
                '}' + containers;
    }

    public String getName() {
        return name;
    }

    public static void ShipsFile(){
        BufferedWriter s = null;
        Ship.sortContainerShips();
        try{
            s = new BufferedWriter(new FileWriter("Ships.txt"));
            for(Ship e : ships){
                s.write(e + "\n");
            }
            s.close();
        }  catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void ContainersFile(){
        BufferedWriter s = null;
        for(Ship e : ships){
          e.sortShipContainers();
        }
        try{
            s = new BufferedWriter(new FileWriter("Containers.txt"));
                for(int i=0; i<ships.size(); i++){
                    s.write("Ship " + ships.get(i).getNumber() + "\n");
                    for(int j=0; j<ships.get(i).containers.size();j++){
                        s.write(ships.get(i).containers.get(j) + "\n");
                    }
                }
            s.close();
        }  catch (IOException e){
            e.printStackTrace();
        }
    }

}
