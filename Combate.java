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

    public CrearPokemon getPkmAtac() {
        return atacante.equipo.get(0);
    }

    public CrearPokemon getPkmDef() {
        return defensor.equipo.get(0);
    }
    public boolean primerAtacante(){
        return (getPkmAtac().calculateSpd() > getPkmDef().calculateSpd() && getPrioAtacan() >= getPrioDefen()) ? true : false;
    }

    public short getPrioAtacan(){
        return getPkmAtac().getAtaques().get(0).getPrioridad();
    }

    public short getPrioDefen(){
        return getPkmDef().getAtaques().get(0).getPrioridad();
    }

    public int calcularDaño(){
        double b = getPkmAtac().getStab(); // STAB
        double e = getEfectividad(); // Efectividad
        int v = variacionDaño(); // Variación de daño
        int n = getPkmAtac().getNivelActual(); // Nivel del atacante
        int a = getStatOfensivo(); // Ataque del atacante
        int d = getStatDefensiva(); // Defensa del defensor
        int p = getPkmAtac().getAtaques().get(0).getPotencia(); /* Potencia del ataque 
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
        return getPkmAtac().isFisico();
    }

    public int getStatOfensivo(){
        return isFisico() ?
        getPkmAtac().getEstadisticasCombate().getAtaqueBase() :
        getPkmAtac().getEstadisticasCombate().getAtaqueEspecialBase();
    }

    public int getStatDefensiva(){
            return isFisico() ?
            getPkmDef().getEstadisticasCombate().getDefensaBase() : 
            getPkmDef().getEstadisticasCombate().getDefensaEspecialBase();
    }

    public double getEfectividad(){
        String tipo = getPkmAtac().getTipo().getNombre();
        HashMap<String, Double> efectividades = getPkmDef().getTipo().efectividades;        
        return efectividades.get(tipo);
    }

    public StatsCombate getStatsAtacante(){
        return getPkmAtac().getEstadisticasCombate();
    }

    public StatsCombate getStatsDefensor(){
        return getPkmDef().getEstadisticasCombate();
    }

}