package prog2.model;

public class Glamping extends Casa {

    // Atributs
    //------------

    private String material;
    private boolean casaMascota;

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
    public Glamping(String nom, String id, boolean estat, String illuminacio,
                    String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota) {
        super(
                nom, id, estat, illuminacio, mida,
                habitacions, placesPersones, 3, 5
        );
        this.material = material;
        this.casaMascota = casaMascota;
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
               ", casaMascota=" + casaMascota + '}';
    }
}
