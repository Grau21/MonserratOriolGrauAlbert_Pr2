package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {
    public CamiAsfaltat(String nom, boolean estat, double metresQuadratsAsfalt) {
        super(nom, estat, metresQuadratsAsfalt);
    }
    @Override
    public boolean isAccessibilitat() { return false; }
    @Override
    public String toString() {
        return super.toString() + " (Camí asfaltat)";
    }
}
