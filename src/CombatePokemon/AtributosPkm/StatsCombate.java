package CombatePokemon.AtributosPkm;

public class StatsCombate {
    private int psBase;
    private int ataqueBase;
    private int defensa;
    private int ataqueEspecialBase;
    private int defensaEspecialBase;
    private int velocidadBase;

    public StatsCombate(int psBase, int ataqueBase, int defensa, int ataqueEspecialBase, int defensaEspecialBase, int velocidadBase) {
        this.psBase = psBase;
        this.ataqueBase = ataqueBase;
        this.defensa = defensa;
        this.ataqueEspecialBase = ataqueEspecialBase;
        this.defensaEspecialBase = defensaEspecialBase;
        this.velocidadBase = velocidadBase;
    }

    public static StatsCombate bulbasaur = new StatsCombate(45, 49, 49, 65, 65, 45);
    public static StatsCombate ivysaur = new StatsCombate(60, 62, 63, 80, 80, 60);
    public static StatsCombate venusaur = new StatsCombate(80, 82, 83, 100, 100, 80);

    public static StatsCombate charmander = new StatsCombate(39, 52, 43, 60, 50, 65);
    public static StatsCombate charmeleon = new StatsCombate(58, 64, 58, 80, 65, 80);
    public static StatsCombate charizard = new StatsCombate(78, 84, 78, 109, 85, 100);

    public static StatsCombate squirtle = new StatsCombate(44, 48, 65, 50, 64, 43);
    public static StatsCombate wartortle = new StatsCombate(59, 63, 80, 65, 80, 58);
    public static StatsCombate blastoise = new StatsCombate(79, 83, 100, 85, 105, 78);


    public int getPsBase() {
        return psBase;
    }

    public void setPsBase(int psBase) {
        this.psBase = psBase;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public void setAtaqueBase(int ataqueBase) {
        this.ataqueBase = ataqueBase;
    }

    public int getDefensaBase() {
        return defensa;
    }

    public void setDefensaBase(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaqueEspecialBase() {
        return ataqueEspecialBase;
    }

    public void setAtaqueEspecialBase(int ataqueEspecialBase) {
        this.ataqueEspecialBase = ataqueEspecialBase;
    }

    public int getDefensaEspecialBase() {
        return defensaEspecialBase;
    }

    public void setDefensaEspecialBase(int defensaEspecialBase) {
        this.defensaEspecialBase = defensaEspecialBase;
    }

    public int getVelocidadBase() {
        return velocidadBase;
    }

    public void setVelocidadBase(int velocidadBase) {
        this.velocidadBase = velocidadBase;
    }
}
