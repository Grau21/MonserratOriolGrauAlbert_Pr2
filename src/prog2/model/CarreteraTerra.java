package prog2.model;

public class CarreteraTerra extends AccesTerra {
    private boolean accesibilitat;
    private double amplada;

    /**
     * Constructor per defecte de la classe.,
     *
     * @param nom
     * @param estat
     * @param longitud
     * @param amplada
     */
    public CarreteraTerra(String nom, boolean estat, double longitud, double amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
        accesibilitat = true;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     * @return
     */
    public boolean isAccessibilitat() { return accesibilitat; }

    /**
     * Retorna l'amplada de l'accés.
     * @return
     */
    public double getAmplada() { return amplada; }

    /**
     * Canvia l'amplada de l'accés.
     *
     * @param amplada
     */
    public void setAmplada(double amplada) { this.amplada = amplada; }
}
