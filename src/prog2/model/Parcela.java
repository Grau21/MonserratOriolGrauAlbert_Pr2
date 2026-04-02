package prog2.model;

public class Parcela extends Allotjament {

    // Atributs
    //------------

    private float mida;
    private boolean connexioElectrica;

    // Constructors
    //---------------

    /**
     * Constructor per defecte de la classe.
     * @param nom
     * @param id
     * @param estat
     * @param illuminacio
     * @param mida
     * @param connexioElectrica
     */
    public Parcela(String nom, String id, boolean estat, int illuminacio,
                   float mida, boolean connexioElectrica) {
        super(nom, id, estat, illuminacio, 4, 2);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    // Getters i Setters.
    //---------------------

    /**
     * Retorna la mida de la Parcela.
     * @return
     */
    public float getMida() { return mida; }

    /**
     * Canvia la mida de la Parcela.
     *
     * @param mida
     */
    public void setMida(float mida) { this.mida = mida; }

    /**
     * Retorna si hi ha connexió elèctrica en la Parcela (true) o no (false).
     * @return
     */
    public boolean isConnexioElectrica() { return connexioElectrica; }

    /**
     * Determina si hi ha connexió elèctrica en la Parcela.
     *
     * @param connexioElectrica
     */
    public void setConnexioElectrica(boolean connexioElectrica) { this.connexioElectrica = connexioElectrica; }

    // Mètodes
    //---------

    /**
     * Retorna si la Parcela funciona correctament (true) o no (false).
     * @return
     */
    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;
    }

    /**
     * Retorna un String amb la informació de la Parcela.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + mida +
                ", connexioElectrica=" + connexioElectrica + "}";
    }
}
