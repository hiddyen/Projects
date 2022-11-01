package Project1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        int x;
        Sender sender1 = new Sender("Kamil", "Slimak", "70010936378", "Wojska Polskiego");
        Sender sender2 = new Sender("Piotr", "Miegoc", "89062175934", "Wyszynskiego");
        Sender sender3 = new Sender("Wojciech", "Koc", "64060862431", "Dluga");
        Scanner in = new Scanner(System.in);
        StandardContainer n1 = new StandardContainer(sender1, "High", 25, 15, "none");
        StandardContainer h1 = new HeavyContainer(sender1, "None", 11, 7, "none","Steel");
        StandardContainer l1 = new LiquidContainer(sender3, "Medium", 31, 24.5, "none",20);
        StandardContainer tpc1 = new ToxicPowderyCargo(sender2, "Low", 7, 3.5, "none","Copper","High Toxicity");
        StandardContainer tlc1 = new ToxicLiquidCargo(sender3, "None", 14, 4.56, "none","Aluminium ","High Toxicity",15);
        StandardContainer rc1 = new RefrigeratedContainer(sender2, "High", 20, 15.3, "All","Aluminium",4);
        StandardContainer ec1 = new ExplosiveContainer(sender2, "High", 23, 20, "none","low");
        StandardContainer n2 = new StandardContainer(sender2, "High", 25, 15, "none");
        StandardContainer h2 = new HeavyContainer(sender2, "None", 11, 7, "none","Steel");
        StandardContainer l2 = new LiquidContainer(sender3, "Medium", 31, 24.5, "none",20);
        StandardContainer tpc2 = new ToxicPowderyCargo(sender3, "Low", 7, 3.5, "none","Copper","High Toxicity");
        StandardContainer tlc2 = new ToxicLiquidCargo(sender3, "None", 14, 4.56, "none","Aluminium ","High Toxicity",15);
        StandardContainer rc2 = new RefrigeratedContainer(sender2, "High", 20, 15.3, "All","Aluminium",4);
        StandardContainer ec2 = new ExplosiveContainer(sender1, "High", 23, 20, "none","low");
        StandardContainer n3 = new StandardContainer(sender2, "High", 25, 15, "none");
        StandardContainer h3 = new HeavyContainer(sender2, "None", 11, 7, "none","Steel");
        StandardContainer l3 = new LiquidContainer(sender3, "Medium", 31, 24.5, "none",20);
        StandardContainer tpc3 = new ToxicPowderyCargo(sender3, "Low", 7, 3.5, "none","Copper","High Toxicity");
        StandardContainer tlc3 = new ToxicLiquidCargo(sender3, "None", 14, 4.56, "none","Aluminium ","High Toxicity",15);
        StandardContainer rc3 = new RefrigeratedContainer(sender2, "High", 20, 15.3, "All","Aluminium",4);
        StandardContainer ec3 = new ExplosiveContainer(sender1, "High", 23, 20, "none","low");
        Time global_time = new Time();
        Ship s1 = new SmallShip("Maly", "Gdansk", "Poland", "USA", 200, 10, 4, 3, 5);
        Ship s2 = new MediumShip("Sredni", "Swinoujscie", "Poland", "Canada", 300, 20, 5, 5, 5);
        Ship s3 = new BigShip("Duzy", "Gdynia", "Poland", "GB", 500, 50, 15, 15, 10);
        Ship s4 = new LiquidShip("Liquid", "Szczecin", "Poland", "Brazil", 250, 30, 10, 20,5);
        Ship s5 = new ToxicShip("Toxic", "Tallinn", "Estonia", "Poland", 260, 20, 7, 19, 30);
        Warehouse w = new Warehouse("Warehouse", 55);
        try {
            w.add(tlc1);
            w.add(ec1);
            w.add(n1);
            w.add(l1);
            s1.addContainer(h1);
            s1.addContainer(tpc1);
            s1.addContainer(rc1);
            s2.addContainer(n2);
            s2.addContainer(h2);
            s2.addContainer(l2);
            s3.addContainer(tpc2);
            s3.addContainer(rc2);
            s3.addContainer(ec2);
            s4.addContainer(tlc2);
            s4.addContainer(n3);
            s4.addContainer(h3);
            s4.addContainer(l3);
            s5.addContainer(tpc3);
            s5.addContainer(tlc3);
            s5.addContainer(rc3);
            s5.addContainer(ec3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        global_time.start();
        while (true) {
            System.out.println("Press 0 to exit");
            System.out.println("Press 1 to create a container");
            System.out.println("Press 2 to create a ship");
            System.out.println("Press 3 to unload a container to warehouse or to the train");
            System.out.println("Press 4 to get rid of container from the warehouse with the given id");
            System.out.println("Press 5 to send a ship from a port");
            System.out.println("Press 6 to display everything");
            System.out.println("Press 7 to save current data to txt file");

            x = in.nextInt();
            if (x == 0) System.exit(0);

            if (x == 1) {

                System.out.println("What type of container would you like to create?");
                System.out.println("Press 1 to a standard container");
                System.out.println("Press 2 to a heavy container ");
                System.out.println("Press 3 to a refrigerated container");
                System.out.println("Press 4 to a liquids cargo container");
                System.out.println("Press 5 to a explosive container");
                System.out.println("Press 6 to a toxic liquid cargo container");
                System.out.println("Press 7 to a toxic powdery cargo container");
                StandardContainer tmpC = null;
                int y = in.nextInt();

                if (y == 1) {
                    System.out.println("Please input all the required data all in separate lines in written order ");
                    System.out.println("GrossWeight, NetWeight, (Name, Surname, PESEL, adress) for Sender, and  SecurityOfContainer,  Certificates");
                    double GrossWeight = in.nextDouble();
                    double NetWeight = in.nextDouble();
                    String idk = in.nextLine();
                    String Name = in.nextLine();
                    String Surname = in.nextLine();
                    String PESEL = in.nextLine();
                    String adress = in.nextLine();
                    Sender s = new Sender(Name, Surname, PESEL, adress);
                    String SecurityOfContainer = in.nextLine();
                    String Certificates = in.nextLine();
                    tmpC = new StandardContainer(s, SecurityOfContainer, GrossWeight, NetWeight, Certificates);

                }
                if (y == 2) {
                    System.out.println("Please input all the required data all in separate lines in written order ");
                    System.out.println("GrossWeight, NetWeight, (Name, Surname, PESEL, adress) for Sender, and  SecurityOfContainer,  Certificates, Material");
                    double GrossWeight = in.nextDouble();
                    double NetWeight = in.nextDouble();
                    String idk = in.nextLine();
                    String Name = in.nextLine();
                    String Surname = in.nextLine();
                    String PESEL = in.nextLine();
                    String adress = in.nextLine();
                    Sender s = new Sender(Name, Surname, PESEL, adress);
                    String SecurityOfContainer = in.nextLine();
                    String Certificates = in.nextLine();
                    String Material = in.nextLine();
                    tmpC = new HeavyContainer(s, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Material);

                }
                if (y == 3) {
                    System.out.println("Please input all the required data all in separate lines in written order ");
                    System.out.println("kWh(kilowatt-hour) ,GrossWeight, NetWeight, (Name, Surname, PESEL, adress) for Sender, and  SecurityOfContainer,  Certificates, Material");
                    double GrossWeight = in.nextDouble();
                    double NetWeight = in.nextDouble();
                    int kWh = in.nextInt();
                    String idk = in.nextLine();
                    String Name = in.nextLine();
                    String Surname = in.nextLine();
                    String PESEL = in.nextLine();
                    String adress = in.nextLine();
                    Sender s = new Sender(Name, Surname, PESEL, adress);
                    String SecurityOfContainer = in.nextLine();
                    String Certificates = in.nextLine();
                    String Material = in.nextLine();
                    tmpC = new RefrigeratedContainer(s, SecurityOfContainer, GrossWeight, NetWeight, Certificates, Material, kWh);

                }
                if (y == 4) {
                    System.out.println("Please input all the required data all in separate lines in written order ");
                    System.out.println("Volume, GrossWeight, NetWeight, (Name, Surname, PESEL, adress) for Sender, and  SecurityOfContainer,  Certificates");
                    int Volume = in.nextInt();
                    double GrossWeight = in.nextDouble();
                    double NetWeight = in.nextDouble();
                    String idk = in.nextLine();
                    String Name = in.nextLine();
                    String Surname = in.nextLine();
                    String PESEL = in.nextLine();
                    String adress = in.nextLine();
                    Sender s = new Sender(Name, Surname, PESEL, adress);
                    String SecurityOfContainer = in.nextLine();
                    String Certificates = in.nextLine();
                    tmpC = new LiquidContainer(s, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Volume);

                }
                if (y == 5) {
                    System.out.println("Please input all the required data all in separate lines in written order ");
                    System.out.println("GrossWeight, NetWeight, (Name, Surname, PESEL, adress) for Sender, and  SecurityOfContainer,  Certificates and Explosiveness");
                    double GrossWeight = in.nextDouble();
                    double NetWeight = in.nextDouble();
                    String idk = in.nextLine();
                    String Name = in.nextLine();
                    String Surname = in.nextLine();
                    String PESEL = in.nextLine();
                    String adress = in.nextLine();
                    Sender s = new Sender(Name, Surname, PESEL, adress);
                    String SecurityOfContainer = in.nextLine();
                    String Certificates = in.nextLine();
                    String Explosiveness = in.nextLine();
                    tmpC = new ExplosiveContainer(s, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Explosiveness);

                }
                if (y == 6) {
                    System.out.println("Please input all the required data all in separate lines in written order ");
                    System.out.println("Volume ,GrossWeight, NetWeight, (Name, Surname, PESEL, adress) for Sender, and  SecurityOfContainer,  Certificates, Material, Toxicity");
                    int Volume= in.nextInt();
                    double GrossWeight = in.nextDouble();
                    double NetWeight = in.nextDouble();
                    String idk = in.nextLine();
                    String Name = in.nextLine();
                    String Surname = in.nextLine();
                    String PESEL = in.nextLine();
                    String adress = in.nextLine();
                    Sender s = new Sender(Name, Surname, PESEL, adress);
                    String SecurityOfContainer = in.nextLine();
                    String Certificates = in.nextLine();
                    String Material = in.nextLine();
                    String Toxicity = in.nextLine();
                    tmpC = new ToxicLiquidCargo(s, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Material,Toxicity,Volume);

                }
                if (y == 7) {
                    System.out.println("Please input all the required data all in separate lines in written order ");
                    System.out.println("GrossWeight, NetWeight, (Name, Surname, PESEL, adress) for Sender, and  SecurityOfContainer,  Certificates, Material, Toxicity");
                    double GrossWeight = in.nextDouble();
                    double NetWeight = in.nextDouble();
                    String idk = in.nextLine();
                    String Name = in.nextLine();
                    String Surname = in.nextLine();
                    String PESEL = in.nextLine();
                    String adress = in.nextLine();
                    Sender s = new Sender(Name, Surname, PESEL, adress);
                    String SecurityOfContainer = in.nextLine();
                    String Certificates = in.nextLine();
                    String Material = in.nextLine();
                    String Toxicity = in.nextLine();
                    tmpC = new ToxicPowderyCargo(s, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Material,Toxicity);

                }

                System.out.println("Where would you like to place the container?");
                System.out.println("Press 1 for ship");
                System.out.println("Press 2 for train");
                System.out.println("Press 3 for warehouse");
                y = in.nextInt();
                if (y == 1) {
                    System.out.println("Enter the ID of the ship that u want to put container in");
                    int id = in.nextInt();
                    Ship.addToShipWithId(id, tmpC);
                }
                if (y == 2) {
                    try {
                        StandardContainer.ToTrain(tmpC);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (y == 3) {
                    tmpC.addToWarehouse();
                }
            }
            if (x == 2) {
                System.out.println("Please input all the required data all in separate lines in written order");
                System.out.println("MaxWeightCapacity, MaxNumberOfContainers, MaxNumberOfContainersWithElectricity, MaxNumberOfHeavyContainers, MaxNumberOfToxicContainersAndExplosive,Name, HomePort, TransportOrigin, Destination");
                int MaxWeightCapacity = in.nextInt();
                int MaxNumberOfContainers = in.nextInt();
                int MaxNumberOfContainersWithElectricity = in.nextInt();
                int MaxNumberOfHeavyContainers = in.nextInt();
                int MaxNumberOfToxicContainersAndExplosive = in.nextInt();
                String wtf1 = in.nextLine();
                String Name = in.nextLine();
                String HomePort = in.nextLine();
                String TransportOrigin = in.nextLine();
                String Destination = in.nextLine();

                Ship tmpS = new Ship(Name, HomePort, TransportOrigin, Destination, MaxWeightCapacity, MaxNumberOfContainers, MaxNumberOfHeavyContainers, MaxNumberOfContainersWithElectricity, MaxNumberOfToxicContainersAndExplosive);
                System.out.println(tmpS);
            }
            if (x == 3) {
                System.out.println("Input id of the ship that you want to unload from");
                int Which = in.nextInt();
                System.out.println("Press 1 to unload a given container to warehouse");
                System.out.println("Press 2 to unload a given container to train");
                int where = in.nextInt();
                for (int i = 0; i < Ship.ships.size(); i++) {
                    if (Which == Ship.ships.get(i).getNumber()) {
                        System.out.println("Input id of the container that you want to unload");
                        int idC = in.nextInt();
                        for (int j = 0; j < Ship.ships.get(i).containers.size(); j++) {
                            if (idC == Ship.ships.get(i).containers.get(j).getid()) {
                                try {
                                    if(where==1) Warehouse.add(Ship.ships.get(i).UnloadToWarehouse(Ship.ships.get(i).containers.get(j)));
                                    if(where==2) Ship.ships.get(i).unloadToTrain(Ship.ships.get(i).containers.get(j));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
            if (x == 4) {
                System.out.println("Input the id of the container that you want to get rid of");
                int y = in.nextInt();
                for (int i = 0; i < Warehouse.warehouse.size(); i++) {
                    if (y == Warehouse.warehouse.get(i).id) {
                        Warehouse.warehouse.remove(i);
                    }
                }
            }
            if (x == 5) {
                System.out.println("Input the id of the ship that you want to departure");
                int y = in.nextInt();
                for (int i = 0; i < Ship.ships.size(); i++) {
                    if (y == Ship.ships.get(i).getNumber()) {
                        Ship.ships.remove(Ship.ships.get(i));
                        System.out.println("Ship with id: " + y + " has departed");
                    }
                }
            }
            if (x == 6){
                    System.out.println("Current state of the warehouse");
                    for (StandardContainer e : Warehouse.warehouse) {
                        System.out.println(e);
                    }
                    System.out.println("Current state of all ships");
                    for (int i = 0; i < Ship.ships.size(); i++) {
                        System.out.println("Ship " + Ship.ships.get(i).getNumber());
                        for (StandardContainer e : Ship.ships.get(i).containers) {
                            System.out.println(e);
                        }
                    }
            }
            if(x == 7){
                Sender.sendersFile();
                Ship.ShipsFile();
                Ship.ContainersFile();
                Warehouse.WarehouseFile();
            }
        }
    }
}