package prog2.vista;

import prog2.model.*;
import java.util.Scanner;

public class VistaCamping {
    private Camping camping;
    private Scanner scanner;

    public VistaCamping(String nomCamping) {
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
        scanner = new Scanner(System.in);
    }

    public void gestioCamping() {
        enum OpcionsMenu {
            LLISTAR_TOTS, LLISTAR_OPERATIUS, LLISTAR_NO_OPERATIUS,
            LLISTAR_ACCESSOS_OBERTS, LLISTAR_ACCESSOS_TANCATS, LLISTAR_TASQUES,
            AFEGIR_TASCA, COMPLETAR_TASCA, ACCESSOS_NO_ACCESSIBLES,
            METRES_TERRA, GUARDAR, CARREGAR, SORTIR
        }
        String[] desc = {
            "Llistar tots els allotjaments",
            "Llistar allotjaments operatius",
            "Llistar allotjaments no operatius",
            "Llistar accessos oberts",
            "Llistar accessos tancats",
            "Llistar tasques de manteniment actives",
            "Afegir una tasca de manteniment",
            "Completar una tasca de manteniment",
            "Calcular accessos sense accessibilitat amb vehicle",
            "Calcular metres totals d'accessos de terra",
            "Guardar càmping a fitxer",
            "Recuperar càmping de fitxer",
            "Sortir"
        };
        Menu<OpcionsMenu> menu = new Menu<>("Menú Càmping Green", OpcionsMenu.values());
        menu.setDescripcions(desc);

        OpcionsMenu opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(scanner);
            try {
                switch (opcio) {
                    case LLISTAR_TOTS:
                        System.out.println(camping.getLlistaAllotjaments().llistarAllotjaments("Operatiu"));
                        System.out.println(camping.getLlistaAllotjaments().llistarAllotjaments("No operatiu"));
                        break;
                    case LLISTAR_OPERATIUS:
                        System.out.println(camping.getLlistaAllotjaments().llistarAllotjaments("Operatiu"));
                        break;
                    case LLISTAR_NO_OPERATIUS:
                        System.out.println(camping.getLlistaAllotjaments().llistarAllotjaments("No operatiu"));
                        break;
                    case LLISTAR_ACCESSOS_OBERTS:
                        System.out.println(camping.getLlistaAccessos().llistarAccessos(true));
                        break;
                    case LLISTAR_ACCESSOS_TANCATS:
                        System.out.println(camping.getLlistaAccessos().llistarAccessos(false));
                        break;
                    case LLISTAR_TASQUES:
                        System.out.println(camping.getLlistaTasquesManteniment().llistarTasquesManteniment());
                        break;
                    case AFEGIR_TASCA:
                        System.out.print("Número tasca: ");
                        int num = scanner.nextInt(); scanner.nextLine();
                        System.out.print("ID allotjament (ALL1..ALL6): ");
                        String id = scanner.nextLine();
                        System.out.print("Tipus (Reparacio, Neteja, RevisioTecnica, Desinfeccio): ");
                        String tipus = scanner.nextLine();
                        System.out.print("Data (qualsevol format): ");
                        String data = scanner.nextLine();
                        System.out.print("Dies esperats: ");
                        int dies = scanner.nextInt(); scanner.nextLine();
                        camping.afegirTascaManteniment(num, tipus, id, data, dies);
                        System.out.println("Tasca afegida correctament.");
                        break;
                    case COMPLETAR_TASCA:
                        System.out.println(camping.getLlistaTasquesManteniment().llistarTasquesManteniment());
                        System.out.print("Número de la tasca a completar: ");
                        int numT = scanner.nextInt(); scanner.nextLine();
                        camping.completarTascaManteniment(numT);
                        System.out.println("Tasca completada.");
                        break;
                    case ACCESSOS_NO_ACCESSIBLES:
                        int n = camping.getLlistaAccessos().calculaAccessosNoAccessibles();
                        System.out.println("Accessos sense accessibilitat: " + n);
                        break;
                    case METRES_TERRA:
                        float metres = camping.getLlistaAccessos().calculaMetresTerra();
                        System.out.println("Total metres accessos de terra: " + metres);
                        break;
                    case GUARDAR:
                        System.out.print("Nom fitxer: ");
                        String fitxer = scanner.nextLine();
                        camping.guardar(fitxer);
                        System.out.println("Guardat a " + fitxer);
                        break;
                    case CARREGAR:
                        System.out.print("Nom fitxer a carregar: ");
                        String fitxerCar = scanner.nextLine();
                        camping = Camping.carregar(fitxerCar);
                        System.out.println("Càmping carregat correctament.");
                        break;
                    case SORTIR:
                        System.out.println("Fins aviat!");
                        break;
                }
            } catch (ExcepcioCamping e) {
                System.err.println("ERROR: " + e.getMessage());
            }
        } while (opcio != OpcionsMenu.SORTIR);
    }
}
