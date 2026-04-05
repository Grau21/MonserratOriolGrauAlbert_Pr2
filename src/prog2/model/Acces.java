package prog2.model;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean estat;
    private LlistaAllotjaments allotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.allotjaments = new LlistaAllotjaments();  // inicialització important
    }

    public void afegirAllotjament(Allotjament allotjament) {
        try { allotjaments.afegirAllotjament(allotjament); } catch (Exception e) {}
    }
    public void tancarAcces() { estat = false; }
    public void obrirAcces() { estat = true; }
    public String getNom() { return nom; }
    public boolean getEstat() { return estat; }
    public LlistaAllotjaments getAAllotjaments() { return allotjaments; }
    public abstract boolean isAccessibilitat();

    @Override
    public String toString() {
        return "Accés " + nom + ", estat=" + (estat ? "Obert" : "Tancat") +
               ", accessibilitat vehicle=" + (isAccessibilitat() ? "Sí" : "No");
    }
}
