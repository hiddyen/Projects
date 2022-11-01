package Project1;

public class ExplosiveContainer extends StandardContainer{
    public String Explosiveness;
    public ExplosiveContainer(Sender Sender, String SecurityOfContainer, double GrossWeight, double NetWeight, String Certificates, String Explosiveness) {
        super(Sender, SecurityOfContainer, GrossWeight, NetWeight, Certificates);
        this.Explosiveness=Explosiveness;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "Explosiveness='" + Explosiveness + '\'' +
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
