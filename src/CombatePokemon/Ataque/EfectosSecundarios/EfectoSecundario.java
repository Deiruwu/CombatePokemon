package CombatePokemon.Ataque.EfectosSecundarios;

public interface EfectoSecundario {
    
    public void efectoSecundario();

}

enum SE {
    ATAQUE,
    DEFENSA,
    ATAQUE_ESPECIAL,
    DEFENSA_ESPECIAL,
    VELOCIDAD,
    PARALIZAR,
    QUEMAR,
    CONGELAR,
    DORMIR,
    ENVENENAR,
    ENVENENAR_GRAVE,
    CONFUNDIR,
    RETROCEDER,
    DESCANSAR,
    DRENADORAS
}