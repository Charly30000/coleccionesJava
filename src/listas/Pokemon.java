package listas;

public class Pokemon implements Comparable<Pokemon> {

    private String nombre;
    private int nivel;

    public Pokemon(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public int compareTo(Pokemon o) {
        // Este metodo hara que se ordenen por el nombre A-Z
        return this.getNombre().compareToIgnoreCase(o.getNombre());
        // Para ordenar de Z-A
        //return o.getNombre().compareToIgnoreCase(this.getNombre());
    }
/*
    // En el caso de querer ordenar por el nivel
    @Override
    public int compareTo(Pokemon o) {
        return new Integer(this.getNivel()).compareTo(o.getNivel());
    }
*/
}
