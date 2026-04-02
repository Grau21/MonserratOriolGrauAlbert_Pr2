package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.*;

public class Camping implements InCamping {
    private String nom;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;

    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
    }

    // Getters
    public String getNom() { return nom; }
    public LlistaAllotjaments getLlistaAllotjaments() { return llistaAllotjaments; }
    public LlistaAccessos getLlistaAccessos() { return llistaAccessos; }
    public LlistaTasquesManteniment getLlistaTasquesManteniment() { return llistaTasquesManteniment; }

    // Mètodes per afegir tasques i completar-les (amb actualització d'accessos)
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        Allotjament a = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, a, data, dies);
        llistaAccessos.actualitzaEstatAccessos();
    }

    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment tasca = llistaTasquesManteniment.getTascaManteniment(num);
        llistaTasquesManteniment.completarTascaManteniment(tasca);
        llistaAccessos.actualitzaEstatAccessos();
    }

    // Persistència
    public void guardar(String camiDesti) throws ExcepcioCamping {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(camiDesti))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new ExcepcioCamping("Error en guardar el càmping: " + e.getMessage());
        }
    }

    public static Camping carregar(String camiOrigen) throws ExcepcioCamping {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(camiOrigen))) {
            return (Camping) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new ExcepcioCamping("Error en carregar el càmping: " + e.getMessage());
        }
    }

    // Inicialització de dades segons les taules de l'enunciat
    public void inicialitzaDadesCamping() {
        llistaAccessos.buidar();
        llistaAllotjaments.buidar();

        // --- Creació d'accessos ---
        // A1: Camí asfaltat
        Acces Acc1 = new CamiAsfaltat("A1", true, 200);
        llistaAccessos.afegirAcces(Acc1);
        // A2: Carretera asfaltada
        Acces Acc2 = new CarreteraAsfaltada("A2", true, 800, 10000);
        llistaAccessos.afegirAcces(Acc2);
        // A3: Camí terra
        Acces Acc3 = new CamiTerra("A3", true, 100);
        llistaAccessos.afegirAcces(Acc3);
        // A4: Carretera terra
        Acces Acc4 = new CarreteraTerra("A4", true, 200, 3);
        llistaAccessos.afegirAcces(Acc4);
        // A5: Camí asfaltat
        Acces Acc5 = new CamiAsfaltat("A5", true, 350);
        llistaAccessos.afegirAcces(Acc5);
        // A6: Carretera asfaltada
        Acces Acc6 = new CarreteraAsfaltada("A6", true, 800, 12000);
        llistaAccessos.afegirAcces(Acc6);
        // A7: Camí asfaltat
        Acces Acc7 = new CamiAsfaltat("A7", true, 100);
        llistaAccessos.afegirAcces(Acc7);
        // A8: Carretera asfaltada
        Acces Acc8 = new CarreteraAsfaltada("A8", true, 800, 10000);
        llistaAccessos.afegirAcces(Acc8);
        // A9: Camí terra
        Acces Acc9 = new CamiTerra("A9", true, 50);
        llistaAccessos.afegirAcces(Acc9);
        // A10: Carretera terra
        Acces Acc10 = new CarreteraTerra("A10", true, 400, 4);
        llistaAccessos.afegirAcces(Acc10);
        // A11: Camí terra
        Acces Acc11 = new CamiTerra("A11", true, 80);
        llistaAccessos.afegirAcces(Acc11);
        // A12: Carretera terra
        Acces Acc12 = new CarreteraTerra("A12", true, 800, 5);
        llistaAccessos.afegirAcces(Acc12);

        // --- Creació d'allotjaments ---
        // Parcel·la Nord (ALL1)
        Allotjament ALL1 = new Parcela("Parcel·la Nord", "ALL1", true, 100, 64.0f, true);
        llistaAllotjaments.afegirAllotjament(ALL1);
        // Parcel·la Sud (ALL2)
        Allotjament ALL2 = new Parcela("Parcel·la Sud", "ALL2", true, 100, 64.0f, true);
        llistaAllotjaments.afegirAllotjament(ALL2);
        // Bungalow Nord (ALL3)
        Allotjament ALL3 = new Bungalow("Bungalow Nord", "ALL3", true, 100, 22, 2, 4, 1, true, true, true);
        llistaAllotjaments.afegirAllotjament(ALL3);
        // Bungalow Premium Sud (ALL4)
        Allotjament ALL4 = new BungalowPremium("Bungalow Sud", "ALL4", true, 100, 27, 2, 6, 1, true, true, true, true, "CampingDelMarBP1");
        llistaAllotjaments.afegirAllotjament(ALL4);
        // Glamping Nord (ALL5)
        Allotjament ALL5 = new Glamping("Glamping Nord", "ALL5", true, 100, 20, 1, 2, "Tela", true);
        llistaAllotjaments.afegirAllotjament(ALL5);
        // Mobil Home Sud (ALL6)
        Allotjament ALL6 = new MobilHome("Mobil·Home Sud", "ALL6", true, 100, 22, 2, 4, true);
        llistaAllotjaments.afegirAllotjament(ALL6);

        // --- Assignar accessos als allotjaments ---
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);
    }
}
