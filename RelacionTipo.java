package CombatePokemon;

public class RelacionTipo {
    Tipo nombre;
    double multiplicador;

    public RelacionTipo(Tipo nombre, double m) {
        this.nombre = nombre;
        this.multiplicador = m;
    }

    public Tipo getNombre() {
        return nombre;
    }

    public void setNombre(Tipo nombre) {
        this.nombre = nombre;
    }

    public double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(double multiplicador) {
        this.multiplicador = multiplicador;
    }
    
}
