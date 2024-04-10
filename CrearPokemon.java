package CombatePokemon;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class CrearPokemon extends plantillaPokemon{
    int nivelActual;
    ArrayList<Ataque> ataques = new ArrayList<Ataque>();


    public CrearPokemon(plantillaPokemon pokemon, int nivelActual) {
        super(pokemon);
        this.nivelActual = nivelActual;
        this.ataques = aprenderAtaques();
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

    public ArrayList<Ataque> aprenderAtaques() {
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

    
    public int calculateHP() {
        int psBase = getEstadisticasCombate().getPsBase(); 
        int ps = 10 + ( getNivelActual() / 100 * (psBase * 2))  + getNivelActual();
        return ps;
    }

    public int calculateAtk() {
        int atkBase = getEstadisticasCombate().getAtaqueBase(); 
            int atk =  ( 5 +  getNivelActual() / 100 * (atkBase * 2));
        return atk;
    }
    public int calculateDef() {
        int defBase = getEstadisticasCombate().getDefensaBase(); 
            int def =  ( 5 +  getNivelActual() / 100 * (defBase * 2));
        return def;
    }
    public int calculateSpAtk() {
        int spAtkBase = getEstadisticasCombate().getAtaqueEspecialBase(); 
            int spAtk =  ( 5 +  getNivelActual() / 100 * (spAtkBase * 2));
        return spAtk;
    }

    public int calculateSpDef() {
        int spDefBase = getEstadisticasCombate().getDefensaEspecialBase(); 
            int spDef =  ( 5 +  getNivelActual() / 100 * (spDefBase * 2));
        return spDef;
    }
    public int calculateSpd() {
        int spdBase = getEstadisticasCombate().getVelocidadBase(); 
            int spd =  ( 5 +  getNivelActual() / 100 * (spdBase * 2));
        return spd;
    }

    public boolean precisionAtaque(){
    
        return false;
    }

    public boolean isFisico(){
        if (ataques.get(0).categoria == Categoria.FISICO) 
            return true;
        else
            return false;
        
    }

    public double getStab() {
        double stab = 1;
        if (getTipo() == getAtaques().get(0).getTipo()) 
            stab = 1.5;
        return stab;
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }
    
}