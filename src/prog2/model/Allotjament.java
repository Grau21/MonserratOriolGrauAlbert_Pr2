package prog2.model;

public abstract class Allotjament implements InAllotjament {

    // Atributs
    //------------

    private String nom;
    private String id;
    private boolean estat;
    private int illuminacio;
    private long estadaMinimaALTA_;
    private long estadaMinimaBAIXA_;

    // Constructors
    //---------------

    public Allotjament(String nom, String id, boolean estat, int illuminacio,
                       long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.nom = nom;
        this.id = id;
        this.estat = estat;
        this.illuminacio = illuminacio;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

// Getters i Setters.
    @Override
    public String getNom() { return nom; }

    @Override
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String getId() { return id; }

    @Override
    public void setId(String id) { this.id = id; }

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

    @Override
    public long getEstadaMinima(Temp temp) {
        switch (temp) {
            case ALTA: return this.estadaMinimaALTA_;
            case BAIXA: return this.estadaMinimaBAIXA_;
            // default: throw new IllegalArgumentException("Temp no vàlid");
        }
    // Error, no s'hauria d'arribar mai a aquesta linia de codi
    return -1;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }
// Correcte Funcionament
    @Override
    public abstract boolean correcteFuncionament();
// Estada Minima Alta i Baixa.
    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + 
               ", estada mínima en temp ALTA: " + estadaMinimaALTA_ +
               ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA_ + ".";
    }
}
