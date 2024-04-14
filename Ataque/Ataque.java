package CombatePokemon.Ataque;

import CombatePokemon.AtributosPkm.Tipo;

public class Ataque extends AtaqueBase{
    private Categoria categoria = Categoria.FISICO;
    private int precision = 100;
    private short prioridad = 0;
    private boolean contacto = true;
    private String efectoSecundario = null;


    public static Ataque burbuja = new Ataque("Burbuja", Tipo.agua, 40, 30, Categoria.ESPECIAL, "Baja la velocidad del objetivo");
    public static Ataque cascada = new Ataque("Cascada", Tipo.agua, 100, 15, 80, "Puede hacer retroceder al objetivo");
    public static Ataque hidrobomba = new Ataque("Hidrobomba", Tipo.agua, 110, 5, Categoria.ESPECIAL, 80);
    public static Ataque pistolaAgua = new Ataque("Pistola Agua", Tipo.agua, 40, 25, Categoria.ESPECIAL);
    public static Ataque refugio = new Ataque("Refugio", Tipo.agua, 0, 40, Categoria.ESTADO, "Aumenta la defensa del usuario");

    public static Ataque ascuas = new Ataque("Ascuas", Tipo.fuego, 40, 25, Categoria.ESPECIAL);
    public static Ataque lanzallamas = new Ataque("Lanzallamas", Tipo.fuego, 90, 15, Categoria.ESPECIAL);

    public static Ataque latigoCepa = new Ataque("Latigo Cepa", Tipo.planta, 45, 25);
    public static Ataque hojaAfilada = new Ataque("Hoja Afilada", Tipo.planta, 55, 25, 95);
    public static Ataque desarrollo = new Ataque("Desarrollo", Tipo.planta, 0, 20, Categoria.ESTADO, "Aumenta el ataque especial del usuario");
    public static Ataque rayoSolar = new Ataque("Rayo Solar", Tipo.planta, 120, 10, Categoria.ESPECIAL, "El usuario ataca en el siguiente turno");
    public static Ataque drenadoras = new Ataque("Drenadoras", Tipo.planta, 0, 10, Categoria.ESPECIAL, 90,  "Recupera la mitad del daño causado");

    public static Ataque placaje = new Ataque("Placaje", Tipo.normal, 40, 35);
    public static Ataque arañazo = new Ataque("Arañazo", Tipo.normal, 40, 35);
    public static Ataque cabezazo = new Ataque("Cabezazo", Tipo.normal, 130, 10);
    public static Ataque cuchillada = new Ataque("Cuchillada", Tipo.normal, 70, 20);
    public static Ataque gruñido = new Ataque("Gruñido", Tipo.normal, 0, 40, Categoria.ESTADO, "Baja el ataque del objetivo");
    public static Ataque latigo = new Ataque ("Latigo", Tipo.normal, 0, 40, Categoria.ESTADO, "Baja la defensa del objetivo");

    
    public Ataque(String nombre, Tipo tipo, int potencia, int pp) {
        super(nombre, tipo, potencia, pp);
    }

    public Ataque(String nombre, Tipo tipo, int potencia, int pp, Categoria categoria) {
        super(nombre, tipo, potencia, pp);
        this.categoria = categoria;
        this.contacto = false;
    }

    public Ataque(String nombre, Tipo tipo, int potencia, int pp, Categoria categoria, String efectoSecundario) {
        super(nombre, tipo, potencia, pp);
        this.categoria = categoria;
        this.contacto = false;
        this.efectoSecundario = efectoSecundario;
    }

    public Ataque(String nombre, Tipo tipo, int potencia, int pp, Categoria categoria, int precision) {
        super(nombre, tipo, potencia, pp);
        this.categoria = categoria;
        this.precision = precision;

        this.contacto = false;
    }
    
    public Ataque(String nombre, Tipo tipo, int potencia, int pp, int precision) {
        super(nombre, tipo, potencia, pp);
        this.precision = precision;
    }

    public Ataque(String nombre, Tipo tipo, int potencia, int pp, String efectoSecundario) {
        super(nombre, tipo, potencia, pp);
        this.efectoSecundario = efectoSecundario;
    }

    public Ataque(String nombre, Tipo tipo, int potencia, int pp, short prioridad) {
        super(nombre, tipo, potencia, pp);
        this.prioridad = prioridad;
    }

    public Ataque(String nombre, Tipo tipo, int potencia, int pp, boolean contacto) {
        super(nombre, tipo, potencia, pp);
        this.contacto = contacto;
    }

    public Ataque(String nombre, Tipo tipo, int potencia, int pp, String efectoSecundario, short prioridad) {
        super(nombre, tipo, potencia, pp);
        this.efectoSecundario = efectoSecundario;
        this.prioridad = prioridad;
    }

    public Ataque(String nombre, Tipo tipo, int potencia,  int pp, int precision, String efectoSecundario) {
        super(nombre, tipo, potencia, pp);
        this.precision = precision;
        this.efectoSecundario = efectoSecundario;
    }

    public Ataque(String nombre, Tipo tipo, int potencia, int pp, Categoria categoria,int precision , String efectoSecundario) {
        super(nombre, tipo, potencia, pp);
        this.categoria = categoria;
        this.precision = precision;
        this.efectoSecundario = efectoSecundario;
        this.contacto = false;
    }

    public Ataque(String nombre, Tipo tipo,  int potencia,  int pp, int precision, String efectoSecundario, short prioridad) {
        super(nombre, tipo, potencia, pp);
        this.precision = precision;
        this.efectoSecundario = efectoSecundario;
        this.prioridad = prioridad;
        this.contacto = false;
    }

    public Ataque(String nombre, Tipo tipo,  int potencia,  int pp, Categoria categoria, int precision, String efectoSecundario, short prioridad) {
        super(nombre, tipo, potencia, pp);
        this.categoria = categoria;
        this.precision = precision;
        this.efectoSecundario = efectoSecundario;
        this.prioridad = prioridad;
        this.contacto = false;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public short getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(short prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isContacto() {
        return contacto;
    }

    public void setContacto(boolean contacto) {
        this.contacto = contacto;
    }

    public String getEfectoSecundario() {
        return efectoSecundario;
    }

    public void setEfectoSecundario(String efectoSecundario) {
        this.efectoSecundario = efectoSecundario;
    }
}