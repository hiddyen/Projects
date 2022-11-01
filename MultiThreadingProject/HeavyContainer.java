package Project1;

public class HeavyContainer extends StandardContainer{
    public String Material;
    public HeavyContainer(Sender Sender, String SecurityOfContainer, double GrossWeight, double NetWeight, String Certificates, String Material) {
        super(Sender, SecurityOfContainer, GrossWeight, NetWeight, Certificates);
        this.Material=Material;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "Material='" + Material + '\'' +
                ", Sender=" + Sender +
                ", SecurityOfContainer='" + SecurityOfContainer + '\'' +
                ", GrossWeight=" + GrossWeight +
                ", NetWeight=" + NetWeight +
                ", Certificates='" + Certificates + '\'' +
                ", id=" + id +
                ", WhenAdded=" + WhenAdded +
                '}';
    }
}
