package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private boolean estat;         // true = operatiu, false = no operatiu
    private int illuminacio;       // percentatge (0, 50, 100)
    private long estadaMinimaBAIXA;
    private long estadaMinimaALTA;

    public Allotjament(String nom, String id, boolean estat, int illuminacio,
                       long estadaMinimaBAIXA, long estadaMinimaALTA) {
        this.nom = nom;
        this.id = id;
        this.estat = estat;
        this.illuminacio = illuminacio;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.estadaMinimaALTA = estadaMinimaALTA;
    }

    // Getters i setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public boolean isEstat() { return estat; }
    public boolean isOperatiu() { return estat; }
    public void setEstat(boolean estat) { this.estat = estat; }
    public String getIluminacio() { return illuminacio + "%"; }
    public void setIlluminacio(int illuminacio) { this.illuminacio = illuminacio; }
    public long getEstadaMinima(Temp temp) {
        return (temp == Temp.ALTA) ? estadaMinimaALTA : estadaMinimaBAIXA;
    }
    public void setEstadaMinima(long estadaMinimaBAIXA, long estadaMinimaALTA) {
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.estadaMinimaALTA = estadaMinimaALTA;
    }

    // Mètodes
    //---------

    public void obrirAllotjament() {
        estat = true;
        illuminacio = 100;
    }

    @Override
    public boolean correcteFuncionament() {
        return estat;
    }

    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id +
               ", estada mínima BAJA=" + estadaMinimaBAIXA +
               ", estada mínima ALTA=" + estadaMinimaALTA +
               ", estat=" + (estat ? "Operatiu" : "No operatiu") +
               ", il·luminació=" + illuminacio + "%";
    }
}
