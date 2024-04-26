package CombatePokemon.Ataque.EfectosSecundarios;

public class Estado implements EfectoSecundario{
    double daño;
    int recuperacion;

    public static final EfectoSecundario DRENADORAS = new Estado((1/8));

    public Estado(double daño) {
        this.daño = daño;
        this.recuperacion = 0;
    }
    @Override
    public void efectoSecundario() {
    }
}
