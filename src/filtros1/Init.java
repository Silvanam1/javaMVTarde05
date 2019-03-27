package filtros1;

import java.util.ArrayList;

class PilotoAvion {    
    public PilotoAvion(String nombre, int cantidadDeChoques, boolean leGustaVolar) {
        this.nombre = nombre;
        this.cantidadDeChoques = cantidadDeChoques;
        this.leGustaVolar = leGustaVolar;
    }
    public final String nombre;
    public final int cantidadDeChoques;
    public final boolean leGustaVolar;
}

public class Init {
    public static ArrayList<PilotoAvion> filtrarPilotos(ArrayList<PilotoAvion> pilotosParam,
                                                boolean leGustaVolarParam, boolean tieneChoquesParam) {
        
        ArrayList<PilotoAvion> listaRet = new ArrayList<PilotoAvion>();
        
        for (PilotoAvion p : pilotosParam) {
            if (p.leGustaVolar==leGustaVolarParam) {
                boolean tieneChoques = (p.cantidadDeChoques > 0);
                if (tieneChoques == tieneChoquesParam) {
                    listaRet.add(p);
                }
            }
        }
        return listaRet;
    }
    
    public static ArrayList<PilotoAvion> obtenerAquellosQueLesGustaVolarYTienenAccidentes(ArrayList<PilotoAvion> pilotosParam) {
        return filtrarPilotos(pilotosParam, true, true);
    }
    public static ArrayList<PilotoAvion> obtenerAquellosQueLesGustaVolarYNOTienenAccidentes(ArrayList<PilotoAvion> pilotosParam) {
        return filtrarPilotos(pilotosParam, true, false);
    }
    public static ArrayList<PilotoAvion> obtenerAquellosQueNOLesGustaVolarYTienenAccidentes(ArrayList<PilotoAvion> pilotosParam) {
        return filtrarPilotos(pilotosParam, false, true);
    }
    public static ArrayList<PilotoAvion> obtenerAquellosQueNOLesGustaVolarYNOTienenAccidentes(ArrayList<PilotoAvion> pilotosParam) {
        return filtrarPilotos(pilotosParam, false, false);
    }
    public static void mostrarLista(ArrayList<PilotoAvion> pilotos) {
        for (PilotoAvion p : pilotos) {
            System.out.println(p.nombre);
            System.out.println(p.leGustaVolar ? "Le gusta volar" : "No le gusta volar");
            System.out.println("Cantidad de choques: " + p.cantidadDeChoques);
            System.out.println("");
        }
    }
    public static ArrayList<PilotoAvion> crearLosPilotos() {
        ArrayList<PilotoAvion> pilotos = new ArrayList<PilotoAvion>();
        
        pilotos.add(new PilotoAvion("Jose", 2, true));
        pilotos.add(new PilotoAvion("Marcos", 1, true));
        pilotos.add(new PilotoAvion("Jesus", 0, false));
        pilotos.add(new PilotoAvion("Abel", 2, true));
        pilotos.add(new PilotoAvion("Juan", 1, false));
        pilotos.add(new PilotoAvion("Pedro", 0, true));
        pilotos.add(new PilotoAvion("Martin", 6, false));
        pilotos.add(new PilotoAvion("Mario", 3, true));
        
        return pilotos;
    }
    public static void main(String[] args) {
        
        /*
        1. crearLosPilotos()
        2. obtenerAquellosQueLesGustaVolarYTienenAccidentes()
        3. mostrarLista()
        */
        
        mostrarLista(
            obtenerAquellosQueLesGustaVolarYTienenAccidentes(
                  crearLosPilotos()
            )
        );
        
    }
}
