package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt {
    private boolean accesibilitat;
    private double pesMaxim;

    /**
     * Constructor per defecte de la classe.,
     *
     * @param nom
     * @param estat
     * @param metresQuadratsAsfalt
     * @param pesMaxim
     */
    public CarreteraAsfaltada(String nom, boolean estat, double metresQuadratsAsfalt, double pesMaxim) {
        super(nom, estat, metresQuadratsAsfalt);
        this.pesMaxim = pesMaxim;
        accesibilitat = true;
    }

    public boolean isAccessibilitat() { return accesibilitat; }

    /**
     * Retorna el pes màxim de l'accés.
     * @return
     */
    public double getpesMaxim() { return pesMaxim; }

    /**
     * Canvia el pes màxim de l'accés.
     *
     * @param pesMaxim
     */
    public void setpesMaxim(double pesMaxim) { this.pesMaxim = this.pesMaxim; }
}
