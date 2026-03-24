package prog2.model;

public abstract class AccesTerra extends Acces {
    private double longitud;

    /**
     * Constructor per defecte de la classe.,
     *
     * @param nom
     * @param accesibilitat
     * @param estat
     */
    AccesTerra(String nom, boolean accesibilitat, boolean estat) {
        super(nom, accesibilitat, estat);
    }
}
