package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private double metresQuadratsAsfalt;

    /**
     * Constructor per defecte de la classe.,
     *
     * @param nom
     * @param estat
     * @param metresQuadratsAsfalt
     */
    AccesAsfalt(String nom, boolean estat, double metresQuadratsAsfalt) {
        super(nom, estat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    /**
     * Retorna els metres quadrats d'asfalt de l'accés.
     * @return
     */
    double getMetresQuadratsAsfalt() { return metresQuadratsAsfalt; }

    /**
     * Canvia els metres quadrats d'asfalt de l'accés.
     * @param metresQuadratsAsfalt
     */
    void setMetresQuadratsAsfalt(double metresQuadratsAsfalt) {
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }
}
