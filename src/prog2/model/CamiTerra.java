package prog2.model;

public class CamiTerra extends AccesTerra {
    private boolean accesibilitat;

    /**
     * Constructor per defecte de la classe.,
     *
     * @param nom
     * @param estat
     * @param longitud
     */
    CamiTerra(String nom, boolean estat, double longitud) {
        super(nom, estat, longitud);
        accesibilitat = false;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     * @return
     */
    public boolean isAccessibilitat() { return accesibilitat; }
}
