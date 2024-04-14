package CombatePokemon.Ataque;

import CombatePokemon.AtributosPkm.Tipo;

public abstract class AtaqueBase {
    private String nombre;
    private Tipo tipo = Tipo.normal;
    private int potencia = 0;
    private int ppTotal = 35;
    private int ppActual = 35;
    
    public AtaqueBase(String nombre, Tipo tipo, int potencia, int ppTotal) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.potencia = potencia;
        this.ppTotal = ppTotal;
        this.ppActual = ppTotal;
    }

    public void reducirPP() {
        ppActual--;
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

    public int getPpTotal() {
        return ppTotal;
    }

    public void setPpTotal(int ppTotal) {
        this.ppTotal = ppTotal;
    }


    public int getPpActual() {
        return ppActual;
    }

    public void setPpActual(int ppActual) {
        this.ppActual = ppActual;
    }

    @Override
    public String toString() {
        return String.format("%s %d PP de %d", nombre, ppActual, ppTotal);
    }

    
}
