package Project1;

public class LiquidContainer extends StandardContainer implements ILiquidContainer{
    public int Volume;
    public LiquidContainer(Sender Sender, String SecurityOfContainer, double GrossWeight, double NetWeight, String Certificates, int Volume) {
        super(Sender, SecurityOfContainer, GrossWeight, NetWeight, Certificates);
        this.Volume=Volume;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "Volume=" + Volume +
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
