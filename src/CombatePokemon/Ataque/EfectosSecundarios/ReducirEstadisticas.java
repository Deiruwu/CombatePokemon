package CombatePokemon.Ataque.EfectosSecundarios;

public class ReducirEstadisticas implements EfectoSecundario{
    private SE estadisca;
    private double cantidad;

    public static final EfectoSecundario REDUCIR_ATAQUE = new ReducirEstadisticas(SE.ATAQUE, 0.5);
    public static final EfectoSecundario REDUCIR_DEFENSA = new ReducirEstadisticas(SE.DEFENSA, 0.5);
    public static final EfectoSecundario REDUCIR_ATAQUE_ESPECIAL = new ReducirEstadisticas(SE.ATAQUE_ESPECIAL, 0.5);
    public static final EfectoSecundario REDUCIR_DEFENSA_ESPECIAL = new ReducirEstadisticas(SE.DEFENSA_ESPECIAL, 0.5);
    public static final EfectoSecundario REDUCIR_VELOCIDAD = new ReducirEstadisticas(SE.VELOCIDAD, 0.5);

    public ReducirEstadisticas(SE estadisca, double cantidad) {
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
