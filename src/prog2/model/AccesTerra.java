package prog2.model;

public abstract class AccesTerra extends Acces {
    private double longitud;

    public AccesTerra(String nom, boolean estat, double longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    @Override
    public String toString() {
        return super.toString() + ", longitud=" + longitud + " m";
    }
}
