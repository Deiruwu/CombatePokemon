package CombatePokemon.AtributosPkm;
import java.util.HashMap;

import CombatePokemon.Ataque.Ataque;
public class Pokemon {
    private String emote;
    private Tipo tipo;
    private double peso;
    private double altura;
    private char sexo;
    private int numPokedex;
    private HashMap<Integer, Ataque> ataquesAprendibles;
    private StatsCombate estadísticasCombate;
    private Evolucion evolucion;
    
    static HashMap<Integer, Ataque> ataquesAprendiblesBulbasaur = new HashMap<Integer, Ataque>() {{
        put(1, Ataque.placaje);
        put(2, Ataque.gruñido);
        put(7, Ataque.drenadoras);
        put(13, Ataque.latigoCepa);
        put(27, Ataque.hojaAfilada);
        put(34, Ataque.desarrollo);
        put(48, Ataque.rayoSolar);
    }};

    static HashMap<Integer, Ataque> ataquesAprendiblesCharmander = new HashMap<Integer, Ataque>() {{
        put(1, Ataque.arañazo);
        put(2, Ataque.gruñido);
        put(9, Ataque.ascuas);
        put(30, Ataque.cuchillada);
        put(38, Ataque.lanzallamas);
    }};

    static HashMap<Integer, Ataque> ataquesAprendiblesSquirtle = new HashMap<Integer, Ataque>() {{
        put(1, Ataque.placaje);
        put(2, Ataque.latigo);
        put(8, Ataque.burbuja);
        put(15, Ataque.pistolaAgua);
        put(28, Ataque.refugio);
        put(35, Ataque.cabezazo);
        put(42, Ataque.hidrobomba);
    }};

    public static Pokemon bulbasaur = new Pokemon("Bulbasaur", Tipo.planta, 6.9, 0.7, 'M', 1, ataquesAprendiblesBulbasaur, StatsCombate.bulbasaur, Evolucion.bulbasaur);
    public static Pokemon charmander = new Pokemon("Charmander", Tipo.fuego, 8.5, 0.6, 'M', 4, ataquesAprendiblesCharmander, StatsCombate.charmander, Evolucion.charmander);
    public static Pokemon squirtle = new Pokemon("Squirtle", Tipo.agua, 9.0, 0.5, 'M', 7, ataquesAprendiblesSquirtle, StatsCombate.squirtle, Evolucion.squirtle);



    public Pokemon(String emote, Tipo tipo, double peso, double altura, char sexo, int numPokedex,
            HashMap<Integer, Ataque> ataquesAprendibles, StatsCombate estadísticasCombate,
            Evolucion evolucion) {
        this.emote = emote;
        this.tipo = tipo;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.numPokedex = numPokedex;
        this.ataquesAprendibles = ataquesAprendibles;
        this.estadísticasCombate = estadísticasCombate;
        this.evolucion = evolucion;
    }

    public Pokemon(Pokemon pokemon) {
        this.emote = pokemon.emote;
        this.tipo = pokemon.tipo;
        this.peso = pokemon.peso;
        this.altura = pokemon.altura;
        this.sexo = pokemon.sexo;
        this.numPokedex = pokemon.numPokedex;
        this.ataquesAprendibles = pokemon.ataquesAprendibles;
        this.estadísticasCombate = pokemon.estadísticasCombate;
        this.evolucion = pokemon.evolucion;
    }
    
    public static void main(String[] args) {
        HashMap <Integer, Ataque> ataques = bulbasaur.getListaAtaquesAprendibles();

        for (int i = 1; i <= 5; i++) {
            if (ataques.containsKey(i)) {
                System.out.println(ataques.get(i).getNombre());
            }
        }
    }
    
    public String getEmote() {
        return emote;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public char getSexo() {
        return sexo;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public HashMap<Integer, Ataque> getListaAtaquesAprendibles() {
        return ataquesAprendibles;
    }


    public StatsCombate getEstadisticasCombate() {
        return estadísticasCombate;
    }

    public Evolucion getEvolucion() {
        return evolucion;
    }       
}
