package CombatePokemon.LogicaCombate;
import java.util.ArrayList;
import java.util.Scanner;
public class Entrenador {
    private String nombre;
    private ArrayList<FactoryPkm> equipo = new ArrayList<>();

    public static Scanner sc = Combate.getScanner();
    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador(String nombre, ArrayList<FactoryPkm> equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public static Entrenador instanciaJugador(){
        System.out.print("¿Cuál  es tu nombre? ");
        String name = sc.nextLine();
        Entrenador jugador = new Entrenador(name);
    return jugador;
    }
    
    public void agregarPkm(FactoryPkm pkm){
        ArrayList<FactoryPkm> equipo = getEquipo();
        if (equipo.size() == 6) {
            System.out.println("No puedes tener más de 6 pokemon en tu equipo");
        }
        equipo.add(pkm);
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<FactoryPkm> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<FactoryPkm> equipo) {
        this.equipo = equipo;
    }

    public void showTeam(){
        int maxLength = 0;
        for (FactoryPkm pkm : equipo) {
            maxLength = Math.max(maxLength, pkm.getEmote().length());
        }
        maxLength += 6;
        System.out.println("*" + Combate.repeatChar('-', maxLength) + "*");
        for (int i = 0; i < equipo.size(); i++) {
            String output = String.format("%d.- %s", i + 1, equipo.get(i).getEmote());
            int longitudEspacios = ((maxLength + 2) - output.length()) / 2;
            String espacios = Combate.repeatChar(' ', longitudEspacios);
            System.out.println(espacios + output + espacios);
        }
        System.out.println("*" + Combate.repeatChar('-', maxLength) + "*");
    
    }

    @Override
    public String toString() {
        return String.format("Entrenador: %s [equipo: %s]", nombre, equipo);
    }

    
}
