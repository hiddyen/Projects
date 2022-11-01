package Project1;

public class ToxicLiquidCargo extends ToxicCargo implements ILiquidContainer{

    public int Volume;
    public ToxicLiquidCargo(Sender Sender, String SecurityOfContainer, double GrossWeight, double NetWeight, String Certificates,String Material,String Toxicity,int Volume) {
        super(Sender, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Material,Toxicity);
        this.Volume=Volume;
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
                ", Toxicity='" + Toxicity + '\'' +
                ", Volume=" + Volume +
                '}';
    }
}
