package prog2.model;

public abstract class AccesTerra extends Acces {
    private double longitud;

    /**
     * Constructor per defecte de la classe.,
     *
     * @param nom
     * @param estat
     * @param longitud
     */
    AccesTerra(String nom, boolean estat, double longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Retorna els la longitud de l'accés.
     * @return
     */
    double getlongitud() { return longitud; }

    /**
     * Canvia els la longitud de l'accés.
     * @param longitud
     */
    void setlongitud(double longitud) {
        this.longitud = longitud;
    }
}
