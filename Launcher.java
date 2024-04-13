package CombatePokemon;
import java.util.ArrayList;
public class Launcher {
    public static void main(String[] args) {
        CrearPokemon bulbasaur = new CrearPokemon(plantillaPokemon.bulbasaur, 5);
        ArrayList<CrearPokemon> equipo1 = new ArrayList<>();
        equipo1.add(bulbasaur);
        Entrenador entrenador1 = new Entrenador("Selene", equipo1);
    
        CrearPokemon charmander = new CrearPokemon(plantillaPokemon.charmander, 5);
        ArrayList<CrearPokemon> equipo2 = new ArrayList<>();
        equipo2.add(charmander);
        Entrenador entrenador2 = new Entrenador("Rival", equipo2);

        Combate combate = new Combate(entrenador1, entrenador2);
        do {
            System.out.println(combate.getPkmAtac());
            System.out.println(combate.getPkmDef());
            combate.primerAtacante();
            combate.selecionarAtaque();
            combate.combateSwitch();
            


        } while (combate.getPkmAtac().hp > 1 || combate.getPkmDef().hp > 1);
        
        
    }
}
