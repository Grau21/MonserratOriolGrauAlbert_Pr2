package prog2.model;

public abstract class Allotjament implements InAllotjament {

    // Atributs
    //------------

    private String nom;
    private String id;
    private boolean estat;
    private int illuminacio;
    private long estadaMinimaBAIXA_;
    private long estadaMinimaALTA_;

    // Constructors
    //---------------

    /**
     * Constructor per defecte de la classe.
     * @param nom
     * @param id
     * @param estat
     * @param illuminacio
     * @param estadaMinimaBAIXA_
     * @param estadaMinimaALTA_
     */
    public Allotjament(String nom, String id, boolean estat, int illuminacio,
                       long estadaMinimaBAIXA_, long estadaMinimaALTA_) {
        this.nom = nom;
        this.id = id;
        this.estat = estat;
        this.illuminacio = illuminacio;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
    }

    // Getters i Setters.
    //---------------------

    @Override
    public String getNom() { return nom; }

    @Override
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String getId() { return id; }

    @Override
    public void setId(String id) { this.id = id; }

    /**
     * Retorna si l'Allotjament està operatiu (true) o no (false).
     * @return
     */
    public boolean isEstat() { return estat; }

    /**
     * Destermina l'estat de l'Allotjament.
     *
     * @param estat
     */
    public void setEstat(boolean estat) { this.estat = estat; }

    /**
     * Retorna la il·luminació de l'Allotjament.
     * @return
     */
    public int getIlluminacio() { return illuminacio; }

    /**
     * Canvia la il·luminació de l'Allotjament.
     *
     * @param illuminacio
     */
    public void setIlluminacio(int illuminacio) { this.illuminacio = illuminacio; }

    @Override
    public long getEstadaMinima(Temp temp) {
        switch (temp) {
            case BAIXA: return this.estadaMinimaBAIXA_;
            case ALTA: return this.estadaMinimaALTA_;
            // default: throw new IllegalArgumentException("Temp no vàlid");
        }
    // Error, no s'hauria d'arribar mai a aquesta linia de codi
    return -1;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaBAIXA_, long estadaMinimaALTA_) {
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
    }

    // Mètodes
    //---------

    /**
     * Retorna si l'Allotjament funciona correctament (true) o no (false).
     * @return
     */
    @Override
    public abstract boolean correcteFuncionament();

    /**
     * Retorna un String amb la informació de l'Allotjament.
     * @return
     */
    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id +
               ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA_ +
               ", estada mínima en temp ALTA: " + estadaMinimaALTA_ +
               ", estat=" + estat + ", illuminacio=" + illuminacio + ".";
    }
}
