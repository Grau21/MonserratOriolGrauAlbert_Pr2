package prog2.model;

public class Bungalow extends Casa {

    // Atributs
    //------------

    private int placesParquing;
    private boolean terrassa;
    private boolean televisio;
    private boolean aireFred;

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
     * @param placesParquing
     * @param terrassa
     * @param televisio
     * @param aireFred
     */
    public Bungalow(String nom, String id, boolean estat, int illuminacio,
                    String mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean televisio,
                    boolean aireFred) {
        super(
                nom, id, estat, illuminacio, mida,
                habitacions, placesPersones, 4, 7
        );
        this.placesParquing = placesParquing;  // Asumim que és un parquing de 1 o 2 places.
        this.terrassa = terrassa;
        this.televisio = televisio;
        this.aireFred = aireFred;
    }

    // Getters i Setters.
    //---------------------

    /**
     * Retorna el nombre de places de Pàrquing del Bungalow.
     * @return
     */
    public int getPlacesParquing() { return placesParquing; }

    /**
     * Canvia el nombre de places de Pàrquing del Bungalow.
     *
     * @param placesParquing
     */
    public void setPlacesParquing(int placesParquing) { this.placesParquing = placesParquing; }

    /**
     * Retorna si hi ha terrassa al Bungalow (true) o no (false).
     * @return
     */
    public boolean isTerrassa() { return terrassa; }

    /**
     * Determina si hi ha o no terrassa al Bungalow.
     *
     * @param terrassa
     */
    public void setTerrassa(boolean terrassa) { this.terrassa = terrassa; }

    /**
     * Retorna si hi ha televisió al Bungalow (true) o no (false).
     * @return
     */
    public boolean isTelevisio() { return televisio; }

    /**
     * Determina si hi ha o no televisió al Bungalow.
     *
     * @param televisio
     */
    public void setTelevisio(boolean televisio) { this.televisio = televisio; }

    /**
     * Retorna si hi ha aire fred al Bungalow (true) o no (false).
     * @return
     */
    public boolean isAireFred() { return aireFred; }

    /**
     * Determina si hi ha o no aire fred al Bungalow.
     *
     * @param aireFred
     */
    public void setAireFred(boolean aireFred) { this.aireFred = aireFred; }

    // Mètodes
    //---------

    /**
     * Retorna si el Bungalow funciona correctament (true) o no (false).
     * @return
     */
    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    /**
     * Retorna un String amb la informació del Bungalow.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " Bungalow{placesParquing=" + placesParquing +
               ", terrassa=" + terrassa + ", televisio=" + televisio + ", aireFred=" + aireFred + "}";
    }
}
