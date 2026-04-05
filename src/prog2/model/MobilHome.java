package prog2.model;

public class MobilHome extends Casa {

    // Atributs
    //------------

    private boolean terrassaBarbacoa;

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
     * @param terrassaBarbacoa
     */
    public MobilHome(String nom, String id,  boolean estat, String illuminacio,
                     String mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa) {
        super(
                nom, id, estat, illuminacio, mida,
                habitacions, placesPersones, 3, 5
        );
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Getters i Setters.
    //---------------------

    /**
     * Retorna si hi ha terrassa a la Mobil Home (true) o no (false).
     * @return
     */
    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa; }

    /**
     * Determina si hi ha o no terrassa a la Mobil Home.
     *
     * @param terrassaBarbacoa
     */
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa; }

    // Mètodes
    //---------

    /**
     * Retorna si la Mobil Home funciona correctament (true) o no (false).
     * @return
     */
    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }

    /**
     * Retorna un String amb la informació de la Mobil Home.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + " MobilHome{terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }
}
