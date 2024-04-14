package CombatePokemon.LogicaCombate;
import java.util.ArrayList;
import java.util.List;

import CombatePokemon.Ataque.Ataque;
import CombatePokemon.Ataque.Categoria;
import CombatePokemon.AtributosPkm.Pokemon;

import java.util.HashMap;
public class FactoryPkm extends Pokemon{
    private int nivelActual;
    private int hpTotal;
    private int hpActual;
    private int atk;
    private int def;
    private int spAtk;
    private int spDef;
    private int spd;
    private ArrayList<Ataque> ataques = new ArrayList<Ataque>();


    public FactoryPkm(Pokemon pokemon, int nivelActual) {
        super(pokemon);
        this.nivelActual = nivelActual;
        this.ataques = asignarAtaques();
        this.hpTotal = calculateHP(pokemon.getEstadisticasCombate().getPsBase());
        this.hpActual = hpTotal;
        this.atk = calculateAtk(pokemon.getEstadisticasCombate().getAtaqueBase());
        this.def = calculateDef(pokemon.getEstadisticasCombate().getDefensaBase());
        this.spAtk = calculateSpAtk(pokemon.getEstadisticasCombate().getAtaqueEspecialBase());
        this.spDef = calculateSpDef(pokemon.getEstadisticasCombate().getDefensaEspecialBase());
        this.spd = calculateSpd(pokemon.getEstadisticasCombate().getVelocidadBase());
    }
    
    public List<Ataque> getAtaquesAprendibles() {
        List<Ataque> listaAtaques = new ArrayList<Ataque>();
        HashMap<Integer, Ataque> ataquesAprendibles = getListaAtaquesAprendibles();
        for (int i = 1; i <= nivelActual; i++) {
            if (ataquesAprendibles.containsKey(i)) {
                listaAtaques.add(ataquesAprendibles.get(i));
            }
        }
        return listaAtaques;
    }

    public ArrayList<Ataque> asignarAtaques() {
        List<Ataque> ataquesAprendibles = getAtaquesAprendibles();
        ArrayList<Ataque> ataques = new ArrayList<Ataque>();
        int count = 0;
        for (Ataque ataque : ataquesAprendibles) {
            if (count >= 4 || ataque == null) {
                break;
            }
            ataques.add(ataque);
            count++;
        }
        return ataques;
    }
    
    public int calculateHP(int psBase) {
        double ps = 10 + ((double) getNivelActual() / 100 * (psBase * 2)) + (double) getNivelActual();
        return (int) ps;
    }
    //PS: 10 + { Nivel / 100 x [(Stat Base x 2)] } + Nivel

    public int calculateAtk(int atkBase) {
        double atk = 5 + ((double) getNivelActual() / 100 * (atkBase * 2));
        return (int) atk;
    }
    
    public int calculateDef(int defBase) {
        double def = 5 + ((double) getNivelActual() / 100 * (defBase * 2));
        return (int) def;
    }
    
    public int calculateSpAtk(int spAtkBase) {
        double spAtk = 5 + ((double) getNivelActual() / 100 * (spAtkBase * 2));
        return (int) spAtk;
    }
    
    public int calculateSpDef(int spDefBase) {
        double spDef = 5 + ((double) getNivelActual() / 100 * (spDefBase * 2));
        return (int) spDef;
    }
    
    public int calculateSpd(int spdBase) {
        double spd = 5 + ((double) getNivelActual() / 100 * (spdBase * 2));
        return (int) spd;
    }

    public boolean precisionAtaque(){
        return false;
    }

    public boolean isFisico(){
        return (ataques.get(0).getCategoria() == Categoria.FISICO) ? true : false;
    }

    public double getStab(int i) {
        return (getTipo() == getAtaques().get(i).getTipo()) ? 1.5 : 1;

    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }

    public int getHpTotal() {
        return hpTotal;
    }

    public void setHpTotal(int hp) {
        this.hpTotal = hp;
    }

    public int getHpActual() {
        
        return (hpActual > 0) ? hpActual : 0;
    }

    public void setHpActual(int hpActual) {
        this.hpActual = hpActual;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }

    @Override
    public String toString() {
        return String.format("%s\t[PS: %d/%d Lvl: %d Atk: %d Def: %d AtkSP: %d DefSP: %d Spd: %d] \tAtaques: %s", 
        getEmote(), getHpActual(), getHpTotal(), getNivelActual(), getAtk(), getDef(), getSpAtk(), getSpDef(), getSpd(), getAtaques());
    }

    public String getPSCombate() {
        return String.format("%s\t: %d/%d (%d%%)",getEmote(),getHpActual(), getHpTotal(), (int) (((double) getHpActual() / getHpTotal()) * 100.0));
    }
}