package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private double metresAsfalt;

    /**
     * Constructor per defecte de la classe.,
     *
     * @param nom
     * @param accesibilitat
     * @param estat
     */
    AccesAsfalt(String nom, boolean accesibilitat, boolean estat) {
        super(nom, accesibilitat, estat);
    }
}
