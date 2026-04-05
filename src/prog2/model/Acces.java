package prog2.model;

import prog2.vista.ExcepcioCamping;

public abstract class Acces implements InAcces {
    private String nom;
    private boolean estat;
    private LlistaAllotjaments allotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.allotjaments = new LlistaAllotjaments();  // inicialització important
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        try {allotjaments.afegirAllotjament(allotjament);}
        catch (ExcepcioCamping e) {
            System.err.println(e.getMessage());
        }
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
