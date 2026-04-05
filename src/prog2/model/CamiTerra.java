package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt {
    private double pesMaxim;
    public CarreteraAsfaltada(String nom, boolean estat, double metresQuadratsAsfalt, double pesMaxim) {
        super(nom, estat, metresQuadratsAsfalt);
        this.pesMaxim = pesMaxim;
    }
    @Override
    public boolean isAccessibilitat() { return true; }
    public double getPesMaxim() { return pesMaxim; }
    public void setPesMaxim(double pesMaxim) { this.pesMaxim = pesMaxim; }
    @Override
    public String toString() {
        return super.toString() + ", pes màxim=" + pesMaxim + " kg (Carretera asfaltada)";
    }
}
