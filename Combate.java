package CombatePokemon;
import java.util.HashMap;

public class Combate {
    Entrenador atacante;
    Entrenador defensor;

    public Combate(Entrenador atacante, Entrenador defensor){
        this.atacante = atacante;
        this.defensor = defensor;
    }

    public void combateSwitch(){
        Entrenador aux = atacante;
        this.atacante = defensor;
        this.defensor = aux;
    }

    public int calcularDaño(){

        double b = atacante.getPrimerPokemon().getStab(); // STAB
        double e = getEfectividad(); // Efectividad
        int v = variacionDaño(); // Variación de daño
        int n = atacante.getPrimerPokemon().getNivelActual(); // Nivel del atacante
        int a = getStatOfensiva(); // Ataque del atacante
        int d = getStatDefensiva(); // Defensa del defensor
        int p = atacante.getPrimerPokemon().getAtaques().get(0).getPotencia(); /* Potencia del ataque 
        double b = 1.5;
        double e = 0.5;
        int v = 85;
        int n = 100;
        int d = 450;
        int a = 410;
        int p = 150; */

        double daño = 0.01 * b * e * v * (((0.2 * n + 1) * a * p) /(25 * d) + 2);
        return (int) daño;
    }

    public int variacionDaño(){
        return 85 + (int) (Math.random() * (100 - 85) + 1);
    }

    public boolean isFisico(){
        return atacante.getPrimerPokemon().isFisico();
    }

    public int getStatOfensiva(){
        return isFisico() ?
        atacante.getPrimerPokemon().getEstadisticasCombate().getAtaqueBase() :
        atacante.getPrimerPokemon().getEstadisticasCombate().getAtaqueEspecialBase();
    }

    public int getStatDefensiva(){
            return isFisico() ?
            defensor.getPrimerPokemon().getEstadisticasCombate().getDefensaBase() : 
            defensor.getPrimerPokemon().getEstadisticasCombate().getDefensaEspecialBase();
    }

    public double getEfectividad(){
        String tipo = atacante.getPrimerPokemon().getTipo().getNombre();
        HashMap<String, Double> efectividades = defensor.getPrimerPokemon().getTipo().efectividades;        
        return efectividades.get(tipo);
    }

    public StatsCombate getStatsAtacante(){
        return atacante.getPrimerPokemon().getEstadisticasCombate();
    }

    public StatsCombate getStatsDefensor(){
        return defensor.getPrimerPokemon().getEstadisticasCombate();
    }

    public Entrenador getAtacante() {
        return atacante;
    }


    public Entrenador getRival() {
        return defensor;
    }

}