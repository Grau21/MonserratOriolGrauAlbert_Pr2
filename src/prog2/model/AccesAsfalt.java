package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private double metresQuadratsAsfalt;

    public AccesAsfalt(String nom, boolean estat, double metresQuadratsAsfalt) {
        super(nom, estat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }
    public double getMetresQuadratsAsfalt() { return metresQuadratsAsfalt; }
    public void setMetresQuadratsAsfalt(double metresQuadratsAsfalt) { this.metresQuadratsAsfalt = metresQuadratsAsfalt; }

    @Override
    public String toString() {
        return super.toString() + ", metres² asfalt=" + metresQuadratsAsfalt;
    }
}
