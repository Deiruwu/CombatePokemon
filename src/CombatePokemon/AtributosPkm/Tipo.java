package CombatePokemon.AtributosPkm;
import java.util.HashMap;

public class Tipo {
    private String nombre;
    private HashMap<String, Double> efectividades = new HashMap<>();
    
    public static HashMap<String, Double> efectividadesPlanta = new HashMap<>();
    public static HashMap<String, Double> efectividadesAgua = new HashMap<>();
    public static HashMap<String, Double> efectividadesFuego = new HashMap<>();
    public static HashMap<String, Double> efectividadesElectrico = new HashMap<>();

    static {
        efectividadesPlanta.put("fuego", 2.0);
        efectividadesPlanta.put("planta", 0.5);
        efectividadesPlanta.put("agua", 0.5);

        efectividadesAgua.put("planta", 2.0);
        efectividadesAgua.put("electrico", 2.0);
        efectividadesAgua.put("fuego", 0.5);
        efectividadesAgua.put("agua", 0.5);

        efectividadesFuego.put("agua", 2.0);
        efectividadesFuego.put("fuego", 0.5);
        efectividadesFuego.put("planta", 0.5);

        efectividadesElectrico.put("eléctrico", 0.5);
    }

    public static Tipo veneno = new Tipo("veneno");
    public static Tipo volador = new Tipo("volador");
    //public static Tipo acero = new Tipo("acero");
    public static Tipo agua = new Tipo("agua", efectividadesAgua);
    /*
    public static Tipo bicho = new Tipo("bicho");
    public static Tipo dragón = new Tipo("dragón");
    public static Tipo fantasma = new Tipo("fantasma");
    */
    public static Tipo eléctrico = new Tipo("electrico", efectividadesElectrico);
    public static Tipo fuego = new Tipo("fuego");
    /* 
    public static Tipo hada = new Tipo("hada");
    public static Tipo hielo = new Tipo("hielo");
    public static Tipo lucha = new Tipo("lucha");
    */
    public static Tipo normal = new Tipo("normal");
    public static Tipo planta = new Tipo("planta", efectividadesPlanta);
    /* 
    public static Tipo psíquico = new Tipo("psíquico");
    public static Tipo roca = new Tipo("roca");
    public static Tipo siniestro = new Tipo("siniestro");
    public static Tipo tierra = new Tipo("tierra");
    */


    public Tipo(String nombre) {
        this.nombre = nombre;
    }

    public Tipo(String nombre, HashMap<String, Double> efectividades) {
        this.nombre = nombre;
        this.efectividades = efectividades;
    }

    public static void main(String[] args) {
        /* 
        acero.debilidades = Arrays.asList(new RelacionTipo(fuego, 2), new RelacionTipo(lucha, 2), new RelacionTipo(tierra, 2));
        acero.resistencias = Arrays.asList(new RelacionTipo(normal, 0.5), new RelacionTipo(planta, 0.5), new RelacionTipo(hielo, 0.5), new RelacionTipo(volador, 0.5), new RelacionTipo(bicho, 0.5), new RelacionTipo(roca, 0.5), new RelacionTipo(psíquico, 0.5), new RelacionTipo(hada, 0.5), new RelacionTipo(acero, 0.5), new RelacionTipo(dragón, 0.5));
        acero.inmunidades = Arrays.asList(new RelacionTipo(veneno, 0));

        agua.debilidades = Arrays.asList(new RelacionTipo(planta, 2), new RelacionTipo(eléctrico, 2));
        agua.resistencias = Arrays.asList(new RelacionTipo(fuego, 0.5), new RelacionTipo(acero, 0.5), new RelacionTipo(agua, 0.5), new RelacionTipo(hielo, 0.5));

        bicho.debilidades = Arrays.asList(new RelacionTipo(volador, 2), new RelacionTipo(fuego, 2), new RelacionTipo(roca, 2));
        bicho.resistencias = Arrays.asList(new RelacionTipo(lucha, 0.5), new RelacionTipo(planta, 0.5), new RelacionTipo(tierra, 0.5));

        dragón.debilidades = Arrays.asList(new RelacionTipo(hada, 2), new RelacionTipo(hielo, 2), new RelacionTipo(dragón, 2));
        dragón.resistencias = Arrays.asList(new RelacionTipo(eléctrico, 0.5), new RelacionTipo(fuego, 0.5), new RelacionTipo(planta, 0.5), new RelacionTipo(agua, 0.5));
            
        eléctrico.debilidades = Arrays.asList(new RelacionTipo(tierra, 2));
        eléctrico.resistencias = Arrays.asList(new RelacionTipo(eléctrico, 0.5), new RelacionTipo(acero, 0.5));

        fantasma.debilidades = Arrays.asList(new RelacionTipo(fantasma, 2), new RelacionTipo(siniestro, 2));
        fantasma.resistencias = Arrays.asList(new RelacionTipo(bicho, 0.5), new RelacionTipo(veneno, 0.5)); 
        fantasma.inmunidades = Arrays.asList(new RelacionTipo(normal, 0), new RelacionTipo(lucha, 0));

        fuego.debilidades = Arrays.asList(new RelacionTipo(tierra, 2), new RelacionTipo(agua, 2), new RelacionTipo(roca, 2));
        fuego.resistencias = Arrays.asList(new RelacionTipo(fuego, 0.5),new RelacionTipo(acero, 0.5), new RelacionTipo(bicho, 0.5), new RelacionTipo(hada, 0.5), new RelacionTipo(hielo, 0.5), new RelacionTipo(planta, 0.5));

        hada.debilidades = Arrays.asList(new RelacionTipo(acero, 2), new RelacionTipo(veneno, 2));
        hada.resistencias = Arrays.asList(new RelacionTipo(lucha, 0.5), new RelacionTipo(siniestro, 0.5), new RelacionTipo(bicho, 0.5));
        hada.inmunidades = Arrays.asList(new RelacionTipo(dragón, 0));

        hielo.debilidades = Arrays.asList(new RelacionTipo(lucha, 2), new RelacionTipo(acero, 2), new RelacionTipo(roca, 2), new RelacionTipo(fuego, 2));
        hielo.resistencias = Arrays.asList(new RelacionTipo(hielo, 0.5));

        
        lucha.debilidades = Arrays.asList(new RelacionTipo(psíquico, 2), new RelacionTipo(volador, 2), new RelacionTipo(hada, 2));
        lucha.resistencias = Arrays.asList(new RelacionTipo(bicho, 0.5), new RelacionTipo(roca, 0.5), new RelacionTipo(siniestro, 0.5));

        normal.debilidades = Arrays.asList(new RelacionTipo(lucha, 2));
        normal.inmunidades = Arrays.asList(new RelacionTipo(fantasma, 0));

        planta.debilidades = Arrays.asList(new RelacionTipo(volador, 2), new RelacionTipo(bicho, 2), new RelacionTipo(veneno, 2), new RelacionTipo(hielo, 2), new RelacionTipo(fuego, 2));
        planta.resistencias = Arrays.asList(new RelacionTipo(tierra, 0.5), new RelacionTipo(agua, 0.5), new RelacionTipo(eléctrico, 0.5), new RelacionTipo(planta, 0.5));

        psíquico.debilidades = Arrays.asList(new RelacionTipo(bicho, 2), new RelacionTipo(fantasma, 2), new RelacionTipo(siniestro, 2));
        psíquico.resistencias = Arrays.asList(new RelacionTipo(lucha, 0.5), new RelacionTipo(psíquico, 0.5));

        roca.debilidades = Arrays.asList(new RelacionTipo(lucha, 2), new RelacionTipo(tierra, 2), new RelacionTipo(acero, 2), new RelacionTipo(agua, 2), new RelacionTipo(planta, 2));
        roca.resistencias = Arrays.asList(new RelacionTipo(normal, 0.5), new RelacionTipo(fuego, 0.5), new RelacionTipo(volador, 0.5), new RelacionTipo(veneno, 0.5));

        siniestro.debilidades = Arrays.asList(new RelacionTipo(lucha, 2), new RelacionTipo(hada, 2), new RelacionTipo(bicho, 2));
        siniestro.resistencias = Arrays.asList(new RelacionTipo(siniestro, 0.5), new RelacionTipo(fantasma, 0.5));
        siniestro.inmunidades = Arrays.asList(new RelacionTipo(psíquico, 0));

        tierra.debilidades = Arrays.asList(new RelacionTipo(agua, 2), new RelacionTipo(planta, 2), new RelacionTipo(hielo, 2));
        tierra.resistencias = Arrays.asList(new RelacionTipo(roca, 0.5), new RelacionTipo(veneno, 0.5));
        tierra.inmunidades = Arrays.asList(new RelacionTipo(eléctrico, 0));

        veneno.debilidades = Arrays.asList(new RelacionTipo(tierra, 2), new RelacionTipo(psíquico, 2));
        veneno.resistencias = Arrays.asList(new RelacionTipo(lucha, 0.5), new RelacionTipo(veneno, 0.5), new RelacionTipo(planta, 0.5), new RelacionTipo(bicho, 0.5), new RelacionTipo(hada, 0.5));

        volador.debilidades = Arrays.asList(new RelacionTipo(roca, 2), new RelacionTipo(hielo, 2), new RelacionTipo(eléctrico, 2));
        volador.resistencias = Arrays.asList(new RelacionTipo(planta, 0.5), new RelacionTipo(lucha, 0.5), new RelacionTipo(bicho, 0.5));
        volador.inmunidades = Arrays.asList(new RelacionTipo(tierra, 0));*/
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Double> getEfectividades() {
        return efectividades;
    }

    public void setEfectividades(HashMap<String, Double> efectividades) {
        this.efectividades = efectividades;
    }

}