package CombatePokemon.AtributosPkm;

public class Evolucion {
    private int estapasEvolutivas;
    private String crecimiento;
    private int NivelEvolucion;
    private int experiencia;

    public static Evolucion bulbasaur = new Evolucion(2, "Parabolico", 1);
    public static Evolucion ivysaur = new Evolucion(1, "Parabolico", 16);
    public static Evolucion venusaur = new Evolucion(0, "Parabolico", 32);

    public static Evolucion charmander = new Evolucion(2, "Parabolico", 1);
    public static Evolucion charmeleon = new Evolucion(1, "Parabolico", 16);
    public static Evolucion charizard = new Evolucion(0, "Parabolico", 36);

    public static Evolucion squirtle = new Evolucion(2, "Parabolico", 1);
    public static Evolucion wartortle = new Evolucion(1, "Parabolico", 16);
    public static Evolucion blastoise = new Evolucion(0, "Parabolico", 36);


    
    public Evolucion(int estapasEvolutivas, String crecimiento, int NivelEvolucion) {
        this.estapasEvolutivas = estapasEvolutivas;
        this.crecimiento = crecimiento;
        this.NivelEvolucion = NivelEvolucion;
        this.experiencia = experienciaNecesaria(NivelEvolucion);
    }

    public int experienciaNecesaria(int NivelEvolucion) {
        int E=0;
        if (crecimiento.equals("Parabolico")) {
            E = (int) (1.2 * Math.pow(NivelEvolucion, 3) - 15 * Math.pow(NivelEvolucion, 2) + 100 * NivelEvolucion - 140);

        } else if (crecimiento.equalsIgnoreCase("Rapido")) {
            E = (int) ((4 *  Math.pow(NivelEvolucion, 3)) / 5);

        } else if (crecimiento.equalsIgnoreCase("Medio")) {
            E = (int) (Math.pow(NivelEvolucion, 3));

        } else if (crecimiento.equalsIgnoreCase("Lento")) {
            E = (int) ((5 *  Math.pow(NivelEvolucion, 3)) / 4);

        } else System.out.println("No se ha implementado aun");

        return E;
    }


    public static void main(String[] args) {
        System.out.println(String.format("Experiencia necesaria para nivel 100: %,d", bulbasaur.experienciaNecesaria(100)));
    }

    public int getEstapasEvolutivas() {
        return estapasEvolutivas;
    }

    public void setEstapasEvolutivas(int estapasEvolutivas) {
        this.estapasEvolutivas = estapasEvolutivas;
    }

    public String getCrecimiento() {
        return crecimiento;
    }

    public void setCrecimiento(String crecimiento) {
        this.crecimiento = crecimiento;
    }

    public int getNivelEvolucion() {
        return NivelEvolucion;
    }

    public void setNivelEvolucion(int NivelEvolucion) {
        this.NivelEvolucion = NivelEvolucion;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }   
}