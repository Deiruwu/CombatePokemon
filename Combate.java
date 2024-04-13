package CombatePokemon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Combate {
    Entrenador atacante;
    Entrenador defensor;
    public static Scanner sc = new Scanner(System.in);

    public Combate(Entrenador atacante, Entrenador defensor){
        this.atacante = atacante;
        this.defensor = defensor;
    }

    public void combateSwitch(){
        Entrenador aux = atacante;
        this.atacante = defensor;
        this.defensor = aux;
    }

    public void dañarPkm(int daño){
        getPkmDef().hp -= daño;
    }

    public CrearPokemon getPkmAtac() {
        return atacante.equipo.get(0);
    }

    public CrearPokemon getPkmDef() {
        return defensor.equipo.get(0);
    }
    
    public boolean primerAtacante(){
        return (getPkmAtac().getSpd() > getPkmDef().getSpd() && getPrioAtacan() >= getPrioDefen()) ? true : false;
    }

    public short getPrioAtacan(){
        return getPkmAtac().getAtaques().get(0).getPrioridad();
    }

    public short getPrioDefen(){
        return getPkmDef().getAtaques().get(0).getPrioridad();
    }

    public int calcularDaño(int i){
        i--;
        double b = getPkmAtac().getStab(); // STAB
        double e = getEfectividad(); // Efectividad
        double v = variacionDaño(); // Variación de daño
        double n = getPkmAtac().getNivelActual(); // Nivel del atacante
        double a = getStatOfensivo(); // Ataque del atacante
        double d = getStatDefensiva(); // Defensa del defensor
        double p = getPkmAtac().getAtaques().get(i).getPotencia(); /* Potencia del ataque 
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

    public boolean fisicoOrSpecial(){
        return getPkmAtac().isFisico();
    }

    public int getStatOfensivo(){
        return fisicoOrSpecial() ?
        getPkmAtac().getAtk() :
        getPkmAtac().getSpAtk();
    }

    public int getStatDefensiva(){
            return fisicoOrSpecial() ?
            getPkmDef().getDef() : 
            getPkmDef().getSpDef();
    }
    
    public void selecionarAtaque(){
        System.out.printf("¿Qué debería hacer %s?\n", getPkmAtac().getEmote());
        listaAtaques();
        int ataque = sc.nextInt();
        if (ataque > 0 && ataque <= getPkmAtac().getAtaques().size()) {
            int daño = calcularDaño(ataque);
            dañarPkm(daño);
            System.out.printf("¡%s ha recibido %d puntos de daño!\n",getPkmDef().getEmote(), daño);
        } else {
            System.out.println("Ataque no valido");
        }
    }

    public void listaAtaques(){
        ArrayList<Ataque> ataques = getPkmAtac().getAtaques();
        for (int i = 0; i < ataques.size(); i++) {
            System.out.printf("Movimiento %d: %s\n",i+1, getPkmAtac().getAtaques().get(i).getNombre());
        }
    }

    public double getEfectividad(){
        String tipo = getPkmAtac().getTipo().getNombre();
        HashMap<String, Double> efectividades = getPkmDef().getTipo().efectividades;

        return (efectividades.containsKey(tipo)) ? efectividades.get(tipo) : 1;
    }

    public StatsCombate getStatsAtacante(){
        return getPkmAtac().getEstadisticasCombate();
    }

    public StatsCombate getStatsDefensor(){
        return getPkmDef().getEstadisticasCombate();
    }

    public Entrenador getAtacante() {
        return atacante;
    }

    public Entrenador getDefensor() {
        return defensor;
    }
}