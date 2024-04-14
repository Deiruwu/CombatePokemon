package CombatePokemon.LogicaCombate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import CombatePokemon.Ataque.Ataque;
import CombatePokemon.AtributosPkm.StatsCombate;
public class Combate {
    private Entrenador atacante;
    private Entrenador defensor;
    
    private static Scanner sc = new Scanner(System.in);
    public static Scanner getScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        return sc;
    }
    public Combate(Entrenador atacante, Entrenador defensor){
        this.atacante = atacante;
        this.defensor = defensor;
    }

    public void combateSwitch(){
        Entrenador aux = atacante;
        this.atacante = defensor;
        this.defensor = aux;
    }

    public void cambiarPkm(){
        ArrayList<FactoryPkm> equipo = atacante.getEquipo();
        atacante.showTeam();
        int pkm = 0;
        do {
            try {
                System.out.print("¿Qué Pokemon quieres usar? ");
                pkm = sc.nextInt();
                pkm -=1;
                Collections.swap(equipo, 0, pkm);
                atacante.setEquipo(equipo);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error al cambiar de Pokemon; opción no valida");
            }
        } while (pkm < 0 || pkm >= equipo.size());
    }

    public void dañarPkm(int ataque){
        System.out.printf("¡%s ha usado %s! y ", getPkmAtac().getEmote(), getPkmAtac().getAtaques().get(ataque).getNombre());
        int daño = calcularDaño(ataque);
        System.out.printf("¡%s ha recibido %d puntos de daño!\n",getPkmDef().getEmote(), daño);
        getPkmDef().setHpActual(getPkmDef().getHpActual() - daño);

    }

    public void usarAtaque(int ataque){
        atacante.getEquipo().get(0).getAtaques().get(ataque).reducirPP();
    }

    public boolean isAlive(){
        return getPkmDef().getHpActual() > 0;
    }

    public FactoryPkm getPkmAtac() {
        return atacante.getEquipo().get(0);
    }

    public FactoryPkm getPkmDef() {
        return defensor.getEquipo().get(0);
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
        double b = getPkmAtac().getStab(i); // STAB
        double e = getEfectividad(i); // Efectividad
        double v = variacionDaño(); // Variación de daño
        double n = getPkmAtac().getNivelActual(); // Nivel del atacante
        double a = getStatOfensivo(); // Ataque del atacante
        double d = getStatDefensiva(); // Defensa del defensor
        double p = getPkmAtac().getAtaques().get(i).getPotencia(); 
        /* Potencia del ataque 
        double b = 1.5;
        double e = 0.5;
        int v = 85;
        int n = 100;
        int d = 450;
        int a = 410;
        int p = 150; */
        double primeraParte = 0.01 * b * e * v;
        double primerParentesis = 0.2 * n + 1;
        double segundoParentesis = primerParentesis * a * p; 
        double parteDivisora = 25 * d;
        double daño = primeraParte * ((segundoParentesis / parteDivisora) + 2);
        return (int) daño;
    }

    public int variacionDaño(){
        double variacion =  85 + (int) (Math.random() * (100 - 85) + 1);
        return (int) variacion;
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
        listaAtaques();
        boolean valido;
        do {
            System.out.printf("¿Qué debería hacer %s? ", getPkmAtac().getEmote());
            int ataque = sc.nextInt();
            ataque -= 1;
            valido = (ataque >= 0 && ataque <= getPkmAtac().getAtaques().size() && getPkmAtac().getAtaques().get(ataque).getPpActual() > 0);
            if (valido) {
                dañarPkm(ataque);
                usarAtaque(ataque);
            } else {
                System.out.println("Ataque no valido");
            }
        } while (!valido);
    }

    public void listaAtaques(){
        ArrayList<Ataque> ataques = getPkmAtac().getAtaques();
        int maxLength = 0;
        for (Ataque ataque : ataques) {
            maxLength = Math.max(maxLength, ataque.toString().length());
        }
        maxLength += 16;
        System.out.println("*" + repeatChar('-', maxLength) + "*");
        for (int i = 0; i < ataques.size(); i++) {
            String output = String.format("Movimiento %d: %s", i + 1, ataques.get(i));
            int longitudEspacios = ((maxLength + 2) - output.length()) / 2;
            String espacios = repeatChar(' ', longitudEspacios);
            System.out.println(espacios + output + espacios);
        }
        System.out.println("*" + repeatChar('-', maxLength) + "*");
    }

    public static String repeatChar(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String getEmojiTipos(int i){
        switch (i) {
            case 1:
                return "🔥";
            case 2:
                return "🌿";
            case 3:
                return "💧";
            default:
                return "❓";
        }
    }
    public double getEfectividad(int i){
        String tipo = getPkmAtac().getAtaques().get(i).getTipo().getNombre();
        HashMap<String, Double> efectividades = getPkmDef().getTipo().getEfectividades();
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