package CombatePokemon;

public abstract class AtaqueBase {
    String nombre;
    Tipo tipo = Tipo.normal;
    int potencia = 0;
    int pp = 35;

    public AtaqueBase(String nombre, Tipo tipo, int potencia, int pp) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.potencia = potencia;
        this.pp = pp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
