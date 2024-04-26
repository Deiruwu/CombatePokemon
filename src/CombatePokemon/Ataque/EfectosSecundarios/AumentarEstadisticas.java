package CombatePokemon.Ataque.EfectosSecundarios;

public class AumentarEstadisticas implements EfectoSecundario{
    private SE estadisca;
    private double cantidad;

    public static final EfectoSecundario AUMENTAR_ATAQUE = new AumentarEstadisticas(SE.ATAQUE, 0.5);
    public static final EfectoSecundario AUMENTAR_DEFENSA = new AumentarEstadisticas(SE.DEFENSA, 0.5);
    public static final EfectoSecundario AUMENTAR_ATAQUE_ESPECIAL = new AumentarEstadisticas(SE.ATAQUE_ESPECIAL, 0.5);
    public static final EfectoSecundario AUMENTAR_DEFENSA_ESPECIAL = new AumentarEstadisticas(SE.DEFENSA_ESPECIAL, 0.5);
    public static final EfectoSecundario AUMENTAR_VELOCIDAD = new AumentarEstadisticas(SE.VELOCIDAD, 0.5);

    public AumentarEstadisticas(SE estadisca, double cantidad) {
        this.estadisca = estadisca;
        this.cantidad = cantidad;
    }

    @Override
    public void efectoSecundario() {
    }

    public double getCantidad() {
        return cantidad;
    }

    public SE getEstadisca() {
        return estadisca;
    }
}
