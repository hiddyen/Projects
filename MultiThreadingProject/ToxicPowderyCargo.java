package Project1;

public class ToxicPowderyCargo extends ToxicCargo{
    public ToxicPowderyCargo(Sender Sender, String SecurityOfContainer, double GrossWeight, double NetWeight, String Certificates,String Material,String Toxicity) {
        super(Sender, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Material,Toxicity);
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
                '}';
    }
}
