package Project1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Sender sender1 = new Sender("Kamil","Slimak", "243972", "Wojska Polskiego");
        Sender sender2 = new Sender("Piotr","Miegoc", "230478", "Wyszynskiego");
        Sender sender3 = new Sender("Wojciech","Szczepara", "215023", "Dluga");
        StandardContainer x =  new HeavyContainer(sender1,"High", 20, 24.5, "brak","stal");
        Time time = new Time();
        ExplosiveContainer y =  new ExplosiveContainer(sender1,"High", 20, 24.5, "brak","low");
        //y.start();
        ToxicLiquidCargo y1 =  new ToxicLiquidCargo(sender1,"High", 20, 24.5, "brak","stal","Low Toxicity",390);
        ToxicPowderyCargo y2 =  new ToxicPowderyCargo(sender1,"High", 20, 24.5, "brak","stal","Low Toxicity");
        //y1.start();
        //y2.start();
        //time.start();
        //w1.add(y);
        StandardContainer n1 =  new StandardContainer(sender1,"High", 25, 24.5, "brak");
        HeavyContainer h1 =  new HeavyContainer(sender1,"High", 22, 24.5, "brak","stal");
        LiquidContainer l1 =  new LiquidContainer(sender2,"High", 21, 24.5, "brak",15);
        ToxicPowderyCargo tpc1 =  new ToxicPowderyCargo(sender3,"High", 2, 24.5, "brak","stal","Low Toxicity");
        ToxicLiquidCargo tlc1 =  new ToxicLiquidCargo(sender2,"High", 3, 24.5, "brak","stal","Low Toxicity",200);
        RefrigeratedContainer rc1 =  new RefrigeratedContainer(sender2,"High", 26, 24.5, "brak","stal",3);
        Time global_time = new Time();

        Ship s2 = new Ship("statek2","Poznan","Poland","France",240,30,22,5,3);
        Ship s1 = new Ship("AAstatek1","Gdansk","Poland","USA",200,10,10,10,10);
        Ship s3 = new Ship("statek3","Poznan","Poland","Canada",300,10,4,2,1);
        Warehouse w1 = new Warehouse("w1", 34);
        s1.addContainer(rc1);
        s1.addContainer(tpc1);
        s2.addContainer(n1);
        s2.addContainer(h1);
        s3.addContainer(l1);
        s3.addContainer(tlc1);

        Warehouse.add(rc1);
        Warehouse.add(tpc1);
        Warehouse.add(n1);
        Warehouse.add(h1);
        Warehouse.add(l1);
        Warehouse.add(tlc1);
/*
        try {
            w1.add(h1);
            w1.add(n1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Warehouse");
        for(StandardContainer e : w1.warehouse){
            System.out.println(e);
        }
        System.out.println("WarehouseSorted");
        for(StandardContainer e : w1.warehouse){
            System.out.println(e);
        }
*/
        Sender.sendersFile();
        Ship.ShipsFile();
        Ship.ContainersFile();
        //Warehouse.WarehouseFile();
    }
}
