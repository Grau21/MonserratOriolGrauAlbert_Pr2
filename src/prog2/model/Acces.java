package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {
    // Atributs
    private String nom;
    private boolean accesibilitat;
    private boolean estat;
    private LlistaAllotjaments acces;

    /**
     * Constructor per defecte de la classe.,
     * @param nom
     * @param accesibilitat
     * @param estat
     */
    Acces(String nom, boolean accesibilitat, boolean estat) {
        this.nom = nom;
        this.accesibilitat = accesibilitat;
        this.estat = estat;
    }

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     * @param allotjament
     */
    public void afegirAllotjament(Allotjament allotjament) {
        acces.add(allotjament);
    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    public void tancarAcces() {
        accesibilitat = false;
    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    public void obrirAcces() {
        accesibilitat = true;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     * @return
     */
    public boolean isAccessibilitat() { return accesibilitat; }

    /**
     * Retorna el nom de l'accés
     * @return
     */
    public String getNom() { return nom; }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     * @return
     */
    public boolean getEstat() { return estat; }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     * @return
     */
    public LlistaAllotjaments getAAllotjaments() { return acces; }
}
