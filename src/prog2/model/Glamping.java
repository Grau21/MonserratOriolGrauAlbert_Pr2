package prog2.model;

public class Glamping extends Casa {

    // Atributs
    //------------

    private String material;
    private boolean casaMascota;
    private boolean estat;
    private int illuminacio;

    // Constructors
    //---------------

    /**
     * Constructor per defecte de la classe.
     * @param nom
     * @param id
     * @param mida
     * @param estat
     * @param illuminacio
     * @param habitacions
     * @param placesPersones
     * @param material
     * @param casaMascota
     */
    public Glamping(String nom, String id, String mida, boolean estat, int illuminacio,
                    int habitacions, int placesPersones, String material, boolean casaMascota) {
        super(nom, id, mida, habitacions, placesPersones); // Heretem de casa amb el super.
        this.material = material;
        this.casaMascota = casaMascota;
        this.estat = estat;
        this.illuminacio = illuminacio;
    }

    // Getters i Setters.
    //---------------------

    /**
     * Retorna el material del que està fet el Glamping.
     * @return
     */
    public String getMaterial() { return material; }

    /**
     * Canvia el material del que està fet el Glamping.
     *
     * @param material
     */
    public void setMaterial(String material) { this.material = material; }

    /**
     * Retorna si el Glamping inclou una cas per mascota (true) o no (false).
     * @return
     */
    public boolean isCasaMascota() { return casaMascota; }

    /**
     * Determina si hi ha o no case de mascotes al Glamping.
     *
     * @param casaMascota
     */
    public void setCasaMascota(boolean casaMascota) { this.casaMascota = casaMascota; }

    /**
     * Retorna si el Glamping està operatiu (true) o no (false).
     * @return
     */
    public boolean isEstat() { return estat; }

    /**
     * Destermina l'estat del Glamping.
     *
     * @param estat
     */
    public void setEstat(boolean estat) { this.estat = estat; }

    /**
     * Retorna la il·luminació del Glamping.
     * @return
     */
    public int getIlluminacio() { return illuminacio; }

    /**
     * Canvia la il·luminació del Glamping.
     *
     * @param illuminacio
     */
    public void setIlluminacio(int illuminacio) { this.illuminacio = illuminacio; }

    // Mètodes
    //---------

    /**
     * Retorna si el Glamping funciona correctament (true) o no (false).
     * @return
     */
    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    /**
     * Retorna un String amb la informació del Glamping.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " Glamping{material=" + material +
               ", casaMascota=" + casaMascota + ",  estat=" + estat +
               ", illuminacio=" + illuminacio + '}';
    }
}
