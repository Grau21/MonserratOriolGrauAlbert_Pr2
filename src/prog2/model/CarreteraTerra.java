package prog2.model;

public class CarreteraTerra extends AccesTerra {
    private double amplada;
    public CarreteraTerra(String nom, boolean estat, double longitud, double amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }
    @Override
    public boolean isAccessibilitat() { return true; }
    public double getAmplada() { return amplada; }
    public void setAmplada(double amplada) { this.amplada = amplada; }
    @Override
    public String toString() {
        return super.toString() + ", amplada=" + amplada + " m (Carretera de terra)";
    }
}
