package CombatePokemon;
import java.util.ArrayList;
public class Entrenador {
    String nombre;
    ArrayList<CrearPokemon> equipo = new ArrayList<>();

    public Entrenador(String nombre, ArrayList<CrearPokemon> equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public static CrearPokemon bulbasaur = new CrearPokemon(plantillaPokemon.bulbasaur, 5);
    public static ArrayList<CrearPokemon> equipo1 = new ArrayList<>();
    static {equipo1.add(bulbasaur);}
    public static Entrenador entrenador1 = new Entrenador("Selene", equipo1);

    public static CrearPokemon charmander = new CrearPokemon(plantillaPokemon.charmander, 5);
    public static ArrayList<CrearPokemon> equipo2 = new ArrayList<>();
    static {equipo2.add(charmander);}
    public static Entrenador entrenador2 = new Entrenador("Rival", equipo2);

    public static void main(String[] args) {
        ArrayList<Ataque> bulbasaurAtaques = bulbasaur.getAtaques();
        for (Ataque ataque : bulbasaurAtaques) {
            System.out.println(ataque.getNombre());
        }
                ArrayList<Ataque> charmanderAtaques = charmander.getAtaques();
        for (Ataque ataque : charmanderAtaques) {
            System.out.println(ataque.getNombre());
        }

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
}