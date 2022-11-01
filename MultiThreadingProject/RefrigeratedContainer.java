package Project1;

public class RefrigeratedContainer extends HeavyContainer{
    public int kWh;
    public RefrigeratedContainer(Sender Sender, String SecurityOfContainer, double GrossWeight, double NetWeight, String Certificates,String Material , int kWh) {
        super(Sender, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Material);
        this.kWh=kWh;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "Material='" + Material + '\'' +
                ", kWh=" + kWh +
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
