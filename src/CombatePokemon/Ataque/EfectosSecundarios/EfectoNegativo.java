package CombatePokemon.Ataque.EfectosSecundarios;

public class EfectoNegativo implements EfectoSecundario{
    private SE efecto;
    private double probabilidad;

    public static final EfectoSecundario PARALIZAR = new EfectoNegativo(SE.PARALIZAR, 0.1);
    public static final EfectoSecundario DORMIR = new EfectoNegativo(SE.DORMIR, 0.1);
    public static final EfectoSecundario QUEMAR = new EfectoNegativo(SE.QUEMAR, 0.1);
    public static final EfectoSecundario CONGELAR = new EfectoNegativo(SE.CONGELAR, 0.1);
    public static final EfectoSecundario ENVENENAR = new EfectoNegativo(SE.ENVENENAR, 0.1);
    public static final EfectoSecundario ENVENENAR_GRAVE = new EfectoNegativo(SE.ENVENENAR_GRAVE, 0.1);
    public static final EfectoSecundario CONFUNDIR = new EfectoNegativo(SE.CONFUNDIR, 0.1);
    public static final EfectoSecundario RETROCEDER = new EfectoNegativo(SE.RETROCEDER, 0.2);
    public static final EfectoSecundario DESCANSAR = new EfectoNegativo(SE.DESCANSAR, 1.0);
    
    public EfectoNegativo(SE efecto, double probabilidad) {
        this.efecto = efecto;
        this.probabilidad = probabilidad;
    }

    @Override
    public void efectoSecundario() {
    }

    public SE getEfecto() {
        return efecto;
    }

    public double getProbabilidad() {
        return probabilidad;
    }
}
