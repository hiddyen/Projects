package Project1;

public abstract class ToxicCargo extends HeavyContainer{
    public String Toxicity;
    public ToxicCargo(Sender Sender, String SecurityOfContainer, double GrossWeight, double NetWeight, String Certificates, String Material,String Toxicity) {
        super(Sender, SecurityOfContainer, GrossWeight, NetWeight, Certificates,Material);
        this.Toxicity=Toxicity;
    }
}
