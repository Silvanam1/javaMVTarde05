package filtros2;

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

interface ICriterio {
    boolean operar(PilotoAvion piloto);
}


public class Init {
    
    public static ArrayList<PilotoAvion> filtrarPilotos(ArrayList<PilotoAvion> pilotosParam,
                                                ICriterio criterio) {
        
        ArrayList<PilotoAvion> listaRet = new ArrayList<PilotoAvion>();
        
        for (PilotoAvion p : pilotosParam) {
            if (criterio.operar(p)) {
                listaRet.add(p);
            }
        }
        return listaRet;
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

        ArrayList<PilotoAvion> pilotos = crearLosPilotos();
        pilotos = filtrarPilotos(pilotos, new LesGustaVolar());
        pilotos = filtrarPilotos(pilotos, p -> p.leGustaVolar);
        mostrarLista(pilotos);
    }
}

class LesGustaVolar implements ICriterio {
    public boolean operar(PilotoAvion piloto) {
        return piloto.leGustaVolar;
    }
}