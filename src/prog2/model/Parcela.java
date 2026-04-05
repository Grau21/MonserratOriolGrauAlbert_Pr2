package prog2.model;

public class Parcela extends Allotjament {
    private float mida;
    private boolean connexioElectrica;

    public Parcela(String nom, String id, boolean estat, String illuminacio,
                   float mida, boolean connexioElectrica) {
        super(nom, id, estat, illuminacio, 4, 2);  // estada mínima: 4 dies baixa, 2 alta?
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    // Getters i setters (igual que abans)
    public float getMida() { return mida; }
    public void setMida(float mida) { this.mida = mida; }
    public boolean isConnexioElectrica() { return connexioElectrica; }
    public void setConnexioElectrica(boolean connexioElectrica) { this.connexioElectrica = connexioElectrica; }

    @Override
    public String toString() {
        return super.toString() + ", Parcela{mida=" + mida + ", connexioElectrica=" + connexioElectrica + "}";
    }
}
