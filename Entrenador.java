package CombatePokemon;
import java.util.ArrayList;
public class Entrenador {
    String nombre;
    ArrayList<CrearPokemon> equipo = new ArrayList<>();

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador(String nombre, ArrayList<CrearPokemon> equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<CrearPokemon> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<CrearPokemon> equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Entrenador: nombre [equipo=" + equipo + "]";
    }
    
    
}