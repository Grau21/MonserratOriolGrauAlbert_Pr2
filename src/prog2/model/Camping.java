package prog2.model;

import prog2.vista.ExcepcioCamping;
import prog2.vista.ExcepcioReserva;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping {
    private String nom;
    private ArrayList<Allotjament> llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;
    private LlistaReserves llistaReserves;
    private ArrayList<Client> llistaClients;

    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments =  new ArrayList<>();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
        this.llistaReserves = new LlistaReserves();
        this.llistaClients = new ArrayList<>();
    }

    // Getters
    @Override
    public String getNom() { return nom; }
    @Override
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }
    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() { return llistaAllotjaments; }
    @Override
    public ArrayList<Client> getLlistaClients() { return llistaClients; }
    @Override
    public int getNumAllotjaments() { return llistaAllotjaments.size(); }
    @Override
    public int getNumReserves() { return llistaReserves.getNumReserves(); }
    @Override
    public int getNumClients() { return llistaClients.size(); }
    public LlistaAccessos getLlistaAccessos() { return llistaAccessos; }
    public LlistaTasquesManteniment getLlistaTasquesManteniment() { return llistaTasquesManteniment; }

    // Mètodes
    @Override
    public void afegirClient(String nom_, String dni_) {
        Client client = new Client(nom_,dni_);
        llistaClients.add(client);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Allotjament parcela = new Parcela(nom_,idAllotjament_, true, "100%", metres, connexioElectrica);
        llistaAllotjaments.add(parcela);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Allotjament bungalow = new Bungalow(
                nom_, idAllotjament_, true, "100%", mida, habitacions,
                placesPersones, placesParquing, terrassa, tv, aireFred
        );
        llistaAllotjaments.add(bungalow);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                      int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                                      boolean serveisExtra, String codiWifi) {
        Allotjament bungalowPremium = new BungalowPremium(
                nom_, idAllotjament_, true, "100%", mida, habitacions,
                placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra,
                codiWifi
        );
        llistaAllotjaments.add(bungalowPremium);
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               String material, boolean casaMascota) {
        Allotjament glamping = new Glamping(
                nom_, idAllotjament_, true, "100%", mida, habitacions,
                placesPersones, material, casaMascota
        );
        llistaAllotjaments.add(glamping);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                                boolean terrassaBarbacoa) {
        Allotjament mobileHome = new MobilHome(
                nom_, idAllotjament_, true, "100%", mida, habitacions,
                placesPersones, terrassaBarbacoa
        );
        llistaAllotjaments.add(mobileHome);
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        llistaReserves.afegirReserva(id_, dni_, dataEntrada, dataSortida);
    }

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

    public void inicialitzaDadesCamping() {
    llistaAccessos.buidar();
    llistaAllotjaments.buidar();

    // Accessos (idèntic al teu, però amb els constructors correctes)
    try {
        Acces Acc1 = new CamiAsfaltat("A1", true, 200);
        llistaAccessos.afegirAcces(Acc1);
        Acces Acc2 = new CarreteraAsfaltada("A2", true, 800, 10000);
        llistaAccessos.afegirAcces(Acc2);
        Acces Acc3 = new CamiTerra("A3", true, 100);
        llistaAccessos.afegirAcces(Acc3);
        Acces Acc4 = new CarreteraTerra("A4", true, 200, 3);
        llistaAccessos.afegirAcces(Acc4);
        Acces Acc5 = new CamiAsfaltat("A5", true, 350);
        llistaAccessos.afegirAcces(Acc5);
        Acces Acc6 = new CarreteraAsfaltada("A6", true, 800, 12000);
        llistaAccessos.afegirAcces(Acc6);
        Acces Acc7 = new CamiAsfaltat("A7", true, 100);
        llistaAccessos.afegirAcces(Acc7);
        Acces Acc8 = new CarreteraAsfaltada("A8", true, 800, 10000);
        llistaAccessos.afegirAcces(Acc8);
        Acces Acc9 = new CamiTerra("A9", true, 50);
        llistaAccessos.afegirAcces(Acc9);
        Acces Acc10 = new CarreteraTerra("A10", true, 400, 4);
        llistaAccessos.afegirAcces(Acc10);
        Acces Acc11 = new CamiTerra("A11", true, 80);
        llistaAccessos.afegirAcces(Acc11);
        Acces Acc12 = new CarreteraTerra("A12", true, 800, 5);
        llistaAccessos.afegirAcces(Acc12);
    }
    catch (ExcepcioCamping e) { System.err.println(e.getMessage()); }

    // Allotjaments (amb String per mida)
    Allotjament ALL1 = new Parcela("Parcel·la Nord", "ALL1", true, "100%", 64.0f, true);
    Allotjament ALL2 = new Parcela("Parcel·la Sud", "ALL2", true, "100%", 64.0f, true);
    Allotjament ALL3 = new Bungalow("Bungalow Nord", "ALL3", true, "100%", "22", 2, 4, 1, true, true, true);
    Allotjament ALL4 = new BungalowPremium("Bungalow Sud", "ALL4", true, "100%", "27", 2, 6, 1, true, true, true, true, "CampingDelMarBP1");
    Allotjament ALL5 = new Glamping("Glamping Nord", "ALL5", true, "100%", "20", 1, 2, "Tela", true);
    Allotjament ALL6 = new MobilHome("Mobil·Home Sud", "ALL6", true, "100%", "22", 2, 4, true);

    try {
        llistaAllotjaments.afegirAllotjament(ALL1);
        llistaAllotjaments.afegirAllotjament(ALL2);
        llistaAllotjaments.afegirAllotjament(ALL3);
        llistaAllotjaments.afegirAllotjament(ALL4);
        llistaAllotjaments.afegirAllotjament(ALL5);
        llistaAllotjaments.afegirAllotjament(ALL6);
    }
    catch (ExcepcioCamping e) {
        System.err.println(e.getMessage());
    }

    // Assignar accessos
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
