package polizas.marcas;

public class Marcas {

    //atributos
    protected int id;
    protected String nombre;
    
    //constructor
    public Marcas(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //metodos, setters y getters
    @Override
    public String toString() {
        return this.nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
