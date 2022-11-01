package Project1;
import TestIII.C;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

public class StandardContainer extends Thread {
    protected Sender Sender;
    protected String SecurityOfContainer;
    protected double GrossWeight;
    protected double NetWeight;
    protected String Certificates;
    protected static int ID=0;
    protected int id;
    LocalDate WhenAdded;
    public StandardContainer(Sender Sender,String SecurityOfContainer, double GrossWeight, double NetWeight,String Certificates){
        this.Sender=Sender;
        this.SecurityOfContainer=SecurityOfContainer;
        this.GrossWeight=GrossWeight;
        this.NetWeight=NetWeight;
        this.Certificates=Certificates;
        this.id=++ID;
    }

    public boolean  wywalilo=false;
    Count time1 = new Count();
    static Sender badSender;
    static StandardContainer badContainer;
    @Override
    public void run(){
            time1.start();
            while (this instanceof ExplosiveContainer && wywalilo != true ) {
                System.out.print("");
                if (Count.getI() == 5 && wywalilo != true && Sender.warnings<3) {
                    wywalilo = true;
                    Sender.warnings++;
                    badSender=Sender;
                    badContainer=this;
                    Warehouse.warehouse.remove(this);
                    try {
                        throw new IrresponsibleSenderWithDangerousGoods();
                    } catch (IrresponsibleSenderWithDangerousGoods e) {
                        e.printStackTrace();
                    }
                }
            }

            while (this instanceof ToxicLiquidCargo && wywalilo != true) {
                System.out.print("");

                if (Count.getI() == 10 && wywalilo != true && Sender.warnings<2) {
                    wywalilo = true;
                    Sender.warnings++;
                    badSender=Sender;
                    badContainer=this;
                    Warehouse.warehouse.remove(this);
                    try {
                        throw new IrresponsibleSenderWithDangerousGoods();
                    } catch (IrresponsibleSenderWithDangerousGoods e) {
                        e.printStackTrace();
                    }
                }
            }

            while (this instanceof ToxicPowderyCargo && wywalilo != true) {
                System.out.print("");
                if (Count.getI() == 14 && wywalilo != true && Sender.warnings<2) {
                    wywalilo = true;
                    Sender.warnings++;
                    badSender=Sender;
                    badContainer=this;
                    Warehouse.warehouse.remove(this);
                    try {

                        throw new IrresponsibleSenderWithDangerousGoods();
                    } catch (IrresponsibleSenderWithDangerousGoods e) {
                        e.printStackTrace();
                    }
                }
            }


    }

    public static void ToTrain(StandardContainer container){

            if(Ship.train.size()<10){
                Ship.train.add(container);
                Ship.x++;
            }

        if(Ship.x==10){
            System.out.println("Train is full please wait for another train");
            Ship.skip.start();
            Ship.train = new ArrayList<StandardContainer>(10);
        }
    }
    public  void addToWarehouse(){
                try {
                    Warehouse.warehouse.add(this);
                    WhenAdded=Time.getDate();
                } catch (Exception e) {
                    e.printStackTrace();
                }

    }
    public int getid(){
        return id;
    }




    public double getGrossWeight() {
        return GrossWeight;
    }

    public double getNetWeight() {
        return NetWeight;
    }
    public LocalDate getWhenAdded(){
        return WhenAdded;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() +
                "Sender=" + Sender +
                ", SecurityOfContainer='" + SecurityOfContainer + '\'' +
                ", GrossWeight=" + GrossWeight +
                ", NetWeight=" + NetWeight +
                ", Certificates='" + Certificates + '\'' +
                ", id=" + id +
                ", WhenAdded=" + WhenAdded +
                '}';
    }
}




