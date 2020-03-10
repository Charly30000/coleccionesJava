/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author andre
 */
public class Listas {

    /**
     * @param args the command line arguments
     */
    Scanner in;
    
    // constructor
    public Listas() { 
        // Para que nos detecte las letras en cultura neutra
        // Sirve más bien para que los numeros nos los ponga con un punto en vez de con coma
        Locale.setDefault(Locale.ROOT); 
    }
    
    
    public void pruebaArrays() {
        
        // Un array ya compuesto
        int[] numeros = {1, 16, 25};
        for (int a : numeros) {
            System.out.println(a);
        }
        
        // Con palabras que se reciban por teclado
        String[] palabras = new String[4];
        for (int i = 0; i < palabras.length; i++){
            // System.out.println("Dime " + palabras.length + " palabras (" + (i + 1) + "/4)");
            /*
                %s --> para String
                %d --> para int
                %f --> para doubles
                %.2f --> para definir la cantidad de decimales que nos muestra
                %b --> para boolean
            */
            System.out.format("Dime %d palabras (%d/%.2f)%n", 
                    palabras.length, i + 1, palabras.length + 0.0);
            palabras[i] = in.nextLine();
        }
        
        System.out.println("-----------------------------------------");
        for(String a : palabras) {
            System.out.println(a);
        }
    }
    
    public void imprimirListaString (List<String> listaPalabras) {
        for (String i : listaPalabras) {
            System.out.println(i);
        }
}
    
    public void pruebaListas() {
        // Creacion de la lista
        List<String> listaPalabras = new ArrayList</*String*/>();
        //El String comentado se puede poner, pero no es necesario
        
        //Añadimos datos
        listaPalabras.add("Pamplona");
        /*
            Al poner como primer valor Pamplona, y despues poner en 0, Venezuela,
            lo que ocurre es que Pamplona se mueve a la posicion 1 y Venezuela
            comienza a ocupar la posicion 0
        */
        listaPalabras.add(0, "Venezuela"); 
        
        imprimirListaString(listaPalabras);
        
        System.out.println("-----------------------------------------");
        
        // Si queremos obtener unicamente un unico valor de la lista en especifico
        String palabra = /*(String)*/listaPalabras.get(0);
        // El (String) comentado, no es necesario, 
        // pero puede llegar a haber un caso en el que lo necesites
        System.out.println(palabra);
        
        System.out.println("-----------------------------------------");
        
        //Hacemos un borrado
        System.out.println("Probamos un borrado: ");
        listaPalabras.remove(0);
        imprimirListaString(listaPalabras);
        // Solo deberia de salir Pamplona, debido a que Venezuela ocupaba
        // la primera posicion, por tanto la lista se reestructura
        System.out.println("-----------------------------------------");
        
        // Hacemos una sustitucion
        System.out.println("Hacemos una sustitucion: ");
        listaPalabras.set(0, "España");
        imprimirListaString(listaPalabras);
        // Aqui solo saldria España, ya que con el set, cambiamos lo que haya en
        // esa posicion por el nuevo valor
        System.out.println("-----------------------------------------");
        
        //Probamos las busquedas
        listaPalabras.add("Pamplona");
        listaPalabras.add("Venezuela");
        System.out.println("Probamos las busquedas:");
        System.out.println(listaPalabras.indexOf("Venezuela"));
        System.out.println(listaPalabras.indexOf("a"));
        // En caso de que encuentre la palabra, retornara la posicion en la que se encuentra
        // En caso de que no la encuentre, retornará un -1
        // IMPORTANTE este indexOf, busca la palabra, no busca si la palabra contiene esas letras
        
        System.out.println("-----------------------------------------");
        // Para averiguar el tamaño de la lista
        System.out.println("La lista mide: " + listaPalabras.size());
        // Para averiguar si la lista esta vacia (devuelve true si esta vacia, o false si tiene algo)
        System.out.println("La lista esta vacia: " + listaPalabras.isEmpty());
        
    }
    
    public void pruebaSet() {
        // Las colecciones de Set, no tienen porqué tener los datos ordenados
        /* 
            La principal ventaja de los Set, es que si tratas de introducir
            un dato que ya existe, este lo ignorará y no lo volvera a introducir
        */
        // Existen dos formas de declararlo principalmente
        // HashSet simplemente mantendra todos los datos, y los mantendra ordenados segun le convenga
        Set<String> prueba = new HashSet<>();
        
        //LinkedHashSet tratara de que mantengan la posicion segun los introduces
        Set<String> prueba2 = new LinkedHashSet<>();
        
        // Para tener Set siempre ordenados (clase TreeSet), usamos:
        /* 
            Set TreeSet tratara de mantener ordenados los datos introducidos
            pero ordenados alfabeticamente o de menor a mayor
            (Segun tabla ASCII principalmente)
        */
        Set<String> prueba3 = new TreeSet<>();
        //Preferible para que este ordenado en caso de que lo quieras
        
        /*
            Es más exhaustivo que el anterior, tambien los mantendra ordenados
            en estructura de arbol
        */
        SortedSet<String> prueba4 = new TreeSet<>();
        
        // Principalmente tiene los mismos metodos que una lista, 
        // por tanto se pueden recorrer de forma igual o parecida
        // Los datos no tienen porque ir ordenados cuando tratas de imprimirlos
        
        prueba3.add("Hola");
        prueba3.add("Adios");
        prueba3.add("que haces");
        prueba3.add("que hola");
        prueba3.add("bye");
        prueba3.add("bye");
        prueba3.add("bye");
        prueba3.add("bye");
        System.out.println(prueba3);
    }
    
    public void run() {
        // Puedes ir comentando aqui los metodos dependiendo de lo que quieras ver funcionar
        in = new Scanner(System.in);
        
        //Arrays y declaracion
        //pruebaArrays();
        
        //Pruebas con listas
        //pruebaListas();
        
        //Pruebas con Set
        pruebaSet();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Listas().run();
    }

    
    
}
