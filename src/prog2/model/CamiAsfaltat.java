package prog2.model;

public class CamiAsfaltat extends AccesAsfalt {
    private boolean accesibilitat;

    /**
     * Constructor per defecte de la classe.,
     *
     * @param nom
     * @param estat
     * @param metresQuadratsAsfalt
     */
    public CamiAsfaltat(String nom, boolean estat, double metresQuadratsAsfalt) {
        super(nom, estat, metresQuadratsAsfalt);
        accesibilitat = false;
    }

    public boolean isAccessibilitat() { return accesibilitat; }
}
