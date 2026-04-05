package prog2.model;

public class BungalowPremium extends Bungalow {

    // Atributs
    //------------

    private boolean serveisExtra;
    private String codiWifi;

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
     * @param serveisExtra
     * @param codiWifi
     */
    public BungalowPremium(String nom, String id, boolean estat, String illuminacio,
                           String mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean televisio,
                           boolean aireFred, boolean serveisExtra, String codiWifi) {
        super(
                nom, id, estat, illuminacio, mida, habitacions,
                placesPersones, placesParquing, terrassa, televisio,
                aireFred);
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    // Getters i Setters.
    //---------------------

    /**
     * Retorna si hi ha serveis extra al Bungalow Premium (true) o no (false).
     * @return
     */
    public boolean isServeisExtra() { return serveisExtra; }

    /**
     * Determina si hi ha o no serveis extra al Bungalow Premium.
     *
     * @param serveisExtra
     */
    public void setServeisExtra(boolean serveisExtra) { this.serveisExtra = serveisExtra; }

    /**
     * Retorna el codi de la wifi del Bungalow Premium.
     * @return
     */
    public String getCodiWifi() { return codiWifi; }

    /**
     * Canvia el codi de la wifi del Bungalow Premium.
     *
     * @param codiWifi
     */
    public void setCodiWifi(String codiWifi) { this.codiWifi = codiWifi; }


    // Mètodes
    //---------

    /**
     * Retorna si el Bungalow Premium funciona correctament (true) o no (false).
     * @return
     */
    @Override
    public boolean correcteFuncionament() {
        return isAireFred() && codiWifi != null && codiWifi.length() >= 8 && codiWifi.length() <= 16;
    }

    /**
     * Retorna un String amb la informació del Bungalow Premium.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " BungalowPremium{serveisExtra=" + serveisExtra +
               ", codiWifi=" + codiWifi + "}";
    }
}
