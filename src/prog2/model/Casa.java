package prog2.model;

public abstract class Casa extends Allotjament {

    // Atributs
    //------------

    private String mida;
    private int habitacions;
    private int placesPersones;

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
     * @param estadaMinimaALTA_
     * @param estadaMinimaBAIXA_
     */
    public Casa(String nom, String id, boolean estat, String illuminacio,
                String mida, int habitacions, int placesPersones,
                long estadaMinimaBAIXA_, long estadaMinimaALTA_) {
        super(nom, id, estat, illuminacio, estadaMinimaBAIXA_, estadaMinimaALTA_);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    // Getters i Setters.
    //---------------------

    /**
     * Retorna la mida de la Casa.
     * @return
     */
    public String getMida() { return mida; }

    /**
     * Canvia la mida de la Casa.
     *
     * @param mida
     */
    public void setMida(String mida) { this.mida = mida; }

    /**
     * Retorna el nombre d'habitacions de la Casa.
     * @return
     */
    public int getHabitacions() { return habitacions; }

    /**
     * Canvia el mombre d'habitacions de la Casa.
     *
     * @param habitacions
     */
    public void setHabitacions(int habitacions) { this.habitacions = habitacions; }

    /**
     * Retorna el nombre de persones que caben a la Casa.
     * @return
     */
    public int getPlacesPersones() { return placesPersones; }

    /**
     * Canvia el nombre de persones que caben en la Casa.
     *
     * @param placesPersones
     */
    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones; }

    // Mètodes
    //---------

    /**
     * Retorna un String amb la informació de la Casa.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " Casa{mida=" + mida + ", habitacions=" + habitacions +
               ", placesPersones=" + placesPersones + "}";
    }
}
