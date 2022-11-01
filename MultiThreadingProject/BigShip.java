package Project1;

public class BigShip extends Ship {

    public BigShip(String name, String HomePort, String TransportOrigin, String destination, int MaxWeightCapacity, int MaxNumberOfContainers, int MaxNumberOfHeavyContainers, int MaxNumberOfContainersWithElectricity, int MaxNumberOfToxicContainersAndExplosive) {
        super(name, HomePort, TransportOrigin, destination, MaxWeightCapacity, MaxNumberOfContainers, MaxNumberOfHeavyContainers, MaxNumberOfContainersWithElectricity, MaxNumberOfToxicContainersAndExplosive);
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

}
