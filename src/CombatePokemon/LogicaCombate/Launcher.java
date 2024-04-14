package CombatePokemon.LogicaCombate;
import java.util.Scanner;
import CombatePokemon.AtributosPkm.Pokemon;
public class Launcher {
    static Scanner sc = Combate.getScanner();
    
    public static Entrenador Jugador = Entrenador.instanciaJugador();
    public static Entrenador Rival = new Entrenador("Rival");
    public static Combate combate;


    public static void selecionarPokemon(){
        System.out.println("1. Bulbasaur");
        System.out.println("2. Charmander");
        System.out.println("3. Squirtle");
        int pkm = 0;
        do {
            System.out.print("Seleccione un Pokemon: ");
            pkm = sc.nextInt();
            FactoryPkm bulbasaur = new FactoryPkm(Pokemon.bulbasaur, 5);
            FactoryPkm charmander = new FactoryPkm(Pokemon.charmander, 5);
            FactoryPkm squirtle = new FactoryPkm(Pokemon.squirtle, 5);

            switch (pkm) {
                case 1:
                    Jugador.agregarPkm(bulbasaur);
                    System.out.println("¡Rival ha seleccionado a Charmander!");
                    Rival.agregarPkm(charmander);
                    break;
                case 2:
                    Jugador.agregarPkm(charmander);
                    System.out.println("¡Rival ha seleccionado a Squirtle!");
                    Rival.agregarPkm(squirtle);
                    break;
                case 3:
                    Jugador.agregarPkm(squirtle);
                    System.out.println("¡Rival ha seleccionado a Bulbasaur!");
                    Rival.agregarPkm(bulbasaur);
                    break;
            
                default: System.out.println("Opción no valida");
                    break;
            }
            System.out.println();
        } while (pkm < 1 || pkm > 3); 
        combate = getInstanceCombate(Jugador, Rival);
    }

    public static Combate getInstanceCombate (Entrenador entrenador1, Entrenador entrenador2) {
        Combate combate = new Combate(entrenador1, entrenador2);
        System.out.printf("¡%s te reta a un combate Pokemon!\n",combate.getDefensor().getNombre());
        return combate;
    }



    public static void main(String[] args) {
        selecionarPokemon();

        
        
        System.out.printf("Entrenador %s: %s\n",combate.getAtacante().getNombre(), combate.getPkmAtac());
        System.out.printf("Entrenador %s: %s\n",combate.getDefensor().getNombre(), combate.getPkmDef());

        do {
            combate.primerAtacante();
            menuSelecion();
            combate.combateSwitch();
            System.out.println(combate.getPkmAtac().getPSCombate());
            System.out.println(combate.getPkmDef().getPSCombate());
            
        } while (combate.getPkmAtac().getHpActual() > 0 && combate.getPkmDef().getHpActual() > 0);
    }

    public static void menuSelecion(){
        System.out.println("1. Ataque");
        System.out.println("2. Cambiar Pokemon");
        boolean next = true;
        do {
            int key = sc.nextInt();
            switch (key) {
                case 1:
                    combate.selecionarAtaque();
                    next = false;
                    break;
                case 2:
                    if (combate.getAtacante().getEquipo().size() == 1) {
                        System.out.println("No puedes cambiar de Pokemon");
                        break;
                    } else
                    combate.cambiarPkm();
                    next = false;
                    break;
                default: System.out.println("Opción no valida");
                    break;
            }
        } while (next);
    }
}

