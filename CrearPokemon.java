package CombatePokemon;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class CrearPokemon extends plantillaPokemon{
    int nivelActual;
    int hp;
    int atk;
    int def;
    int spAtk;
    int spDef;
    int spd;
    ArrayList<Ataque> ataques = new ArrayList<Ataque>();


    public CrearPokemon(plantillaPokemon pokemon, int nivelActual) {
        super(pokemon);
        this.nivelActual = nivelActual;
        this.ataques = aprenderAtaques();
    this.hp = calculateHP(pokemon.getEstadisticasCombate().getPsBase());
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
        return emote + " [nivelActual=" + nivelActual + ", hp=" + hp + ", atk=" + atk + ", def=" + def + ", spAtk="
                + spAtk + ", spDef=" + spDef + ", spd=" + spd + ", ataques=" + ataques + "]";
    }

    
    
}