package CombatePokemon;
import java.util.HashMap;

public class CombatePokemon {
    Entrenador you;
    Entrenador rival;

    public CombatePokemon(Entrenador you, Entrenador rival) {
        this.you = you;
        this.rival = rival;
    }

    public int calcularDaño(){
            double daño = 0.01 * you.getPrimerPokemon().getStab() * getEfectividad() * variacionDaño() * ((0.2 * you.getPrimerPokemon().getNivelActual()) / (25 * rival.getPrimerPokemon().getEstadisticasCombate().getDefensaBase()) + 2);
        return (int) daño;
    }

    public int variacionDaño(){
        return 85 + (int) (Math.random() * (100 - 85) + 1);
    }

    public double getEfectividad(){
        String tipo = you.getPrimerPokemon().getTipo().getNombre();
        HashMap<String, Double> efectividades = you.getPrimerPokemon().getTipo().efectividades;        
        return efectividades.get(tipo);
    }

    public Entrenador getYou() {
        return you;
    }

    public Entrenador getRival() {
        return rival;
    }

}
