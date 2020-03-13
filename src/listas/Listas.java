/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Collections;

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
            // System.out.println("Dime " + palabras.length + " palabras (Palabra " + (i + 1) + "/4)");
            /*
                %s --> para String
                %d --> para int
                %f --> para doubles
                %.2f --> para definir la cantidad de decimales que nos muestra
                %b --> para boolean
                %n --> para saltar de linea
            */
            System.out.format("Dime %d palabras (Palabra %d/%.2f)%n", 
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
        
        System.out.println("-----------------------------------------");
        
        // Para clonar una lista (ArrayList tiene su propio metodo para clonar)
        ArrayList<String> nuevaListaPalabras = new ArrayList<>();
        nuevaListaPalabras.add("Hola");
        nuevaListaPalabras.add("Adios");
        nuevaListaPalabras.add("Que hay");
        nuevaListaPalabras.add("¿Eres nuevo por aqui?");
        System.out.println(nuevaListaPalabras);
        
        // Creamos una lista y clonamos la lista anterior
        ArrayList<String> clon = (ArrayList<String>)nuevaListaPalabras.clone();
        System.out.println(clon);
        
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
        /* 
            Puedes cambiar aqui entre prueba, prueba2, prueba3 y prueba 4 para 
            ir viendo el funcionamiento de cada uno
        */
        prueba3.add("Hola");
        prueba3.add("Adios");
        prueba3.add("que haces");
        prueba3.add("que hay");
        prueba3.add("bye");
        prueba3.add("bye");
        prueba3.add("bye");
        prueba3.add("bye");
        System.out.println(prueba3);
    }
    
    public void imprimirListaMap(Map<String, Integer> lista) {
        for (String s : lista.keySet()) {
            System.out.println(s);
        }
    }
    
    public void pruebaMap() {
        /*
            Los maps se dividen en dos aspectos, tienen una clave y un valor.
            La clave siempre será unica, en caso de usar una clave ya existente,
            se reemplazara el valor que ya existia por el nuevo valor.
            Al igual que los Set, los Maps no tienen porque mantener los valores
            ordenados segun tu conveniencia
        */
        /*
            Haremos un ejemplo con ciudades y cantidad de habitantes (por 
            supuesto será un simple ejemplo, por lo que no seran valores reales)
        */
        Map<String, Integer> ciudad = new HashMap<>();
        
        // Para insertar datos
        ciudad.put("Madrid", 1000);
        ciudad.put("Madrid", 10000000);
        ciudad.put("Barcelona", 5000);
        
        // Para ver los valores
        
        for (int i : ciudad.values()) {
            System.out.println(i);
        }
        System.out.println("-----------------------------------------");
        
        // Para ver las keys
        
        for (String s : ciudad.keySet()) {
            System.out.println(s);
        }
        System.out.println("-----------------------------------------");
        
        // Para ver clave - valor
        
        for (String s : ciudad.keySet()) {
            System.out.format("La ciudad de %s tiene %d habitantes%n", s, ciudad.get(s));
        }
        System.out.println("-----------------------------------------");
        
        // Para obtener un valor en especifico
        
        System.out.println(ciudad.get("Madrid"));
        System.out.println(ciudad.get("Barcelona"));
        
        System.out.println("-----------------------------------------");
        
        // Para comprobar el tamaño del map
        System.out.println(ciudad.size());
        System.out.println("-----------------------------------------");
        
        // Para eliminar un elemento de un map (a partir de su key)
        ciudad.remove("Barcelona");
        imprimirListaMap(ciudad);
        
        System.out.println("-----------------------------------------");
        
        // Para saber si existe un elemento dentro de un map (true si esta, false si no esta)
        System.out.println(ciudad.containsKey("Madrid"));
        System.out.println(ciudad.containsKey("Barcelona"));
        
        System.out.println("-----------------------------------------");
        
        // Para saber si existe un valor
        System.out.println(ciudad.containsValue(1000));
        System.out.println(ciudad.containsValue(10000000));
        System.out.println("-----------------------------------------");
        
        // Para saber si el map está vacio (true si esta vacio, false si no lo esta)
        
        System.out.println(ciudad.isEmpty());
        
        // Para vaciar el map y dejarlo sin elementos
        ciudad.put("Madrid", 10000000);
        ciudad.put("Barcelona", 5000);
        System.out.println(ciudad);
        
        // Lo vaciamos
        ciudad.clear();
        System.out.println(ciudad);
        System.out.println("-----------------------------------------");
        
        // Para tener siempre un map ordenado (segun la tabla ASCII)
        
        Map<String, Double> listaCiudades = new TreeMap<>();
        listaCiudades.put("Madrid", 10000.0);
        listaCiudades.put("Barcelona", 15000.0);
        listaCiudades.put("Valencia", 20000.0);
        listaCiudades.put("Galicia", 7000.0);
        System.out.println(listaCiudades);
        
    }
    
    public void pruebaIterator() {
        /*
            Los iteradores son practicamente iguales que los bucles for-each,
            sin embargo, estos son muy buenos para hacer borrados mientras
            hacemos recorridos, mientras que los for-each simplemente nos
            sirven para leer lo que posee esa zona de codigo
        */
        
        // Ejemplo con listas (tambien valdria con Set)
        
        List<String> lista = new ArrayList<>();
        lista.add("Andres");
        lista.add("Marcos");
        lista.add("Lucia");
        lista.add("Sandra");
        
        // Hacemos una iteracion simplemente para ver su contenido
        // Lo declaramos
        Iterator<String> iter = lista.iterator();
        // Lo recorremos
        while (iter.hasNext()) {
            /* 
                En caso de que vayamos a hacer varias operaciones con el mismo
                operador, será necesario guardarlo en una variable, ya que si
                vamos declarando varias veces el iter.next, irá pasando al
                siguiente valor.
            */
            String nombre = iter.next();
            System.out.println(nombre);
        }
        System.out.println("-----------------------------------------");
        // Hacemos un borrado, el cual llevara una condicion
        // Como queremos volver a iterar sobre la misma lista, deberemos
        // de volver a declararlo
        iter = lista.iterator();
        
        while (iter.hasNext()) {
            String nombre = iter.next();
            if (nombre.equals("Marcos")) {
                // .remove eliminará el ultimo elemento que hayamos obtenido
                // con .next
                iter.remove();
            }
        }
        System.out.println(lista);
        System.out.println("-----------------------------------------");
        
        // Ejemplos con Maps

        Map<String, Integer> listaCiudades = new TreeMap<>();
        listaCiudades.put("Madrid", 10000);
        listaCiudades.put("Barcelona", 15000);
        listaCiudades.put("Valencia", 20000);
        listaCiudades.put("Galicia", 7000);
        System.out.println(listaCiudades);
        
        // Iteramos sobre las claves
        Iterator<String> iterMap = listaCiudades.keySet().iterator();
        
        while (iterMap.hasNext()) {
            String ciudad = iterMap.next();
            System.out.format("La ciudad de %s tiene %d habitantes %n", 
                    ciudad, listaCiudades.get(ciudad));
        }
        System.out.println();
        // Iteramos sobre los valores
        Iterator<Integer> iterMap2 = listaCiudades.values().iterator();
        
        while (iterMap2.hasNext()) {
            Integer i = iterMap2.next();
            System.out.println(i);
        }
        System.out.println("-----------------------------------------");
        
        // Probamos a hacer borrados con ambos casos
        // Sobre claves
        System.out.println(listaCiudades);
        iterMap = listaCiudades.keySet().iterator();
        while (iterMap.hasNext()) {
            String ciudad = iterMap.next();
            if (ciudad.equals("Galicia")){
                iterMap.remove();
            }
        }
        System.out.println(listaCiudades);
        System.out.println();
        
        // Sobre valores
        iterMap2 = listaCiudades.values().iterator();
        while (iterMap2.hasNext()) {
            Integer i = iterMap2.next();
            if (i == 20000) {
                iterMap2.remove();
            }
        }
        System.out.println(listaCiudades);
    }
    
    public void pruebaColas() {
        /*
            Una cola tiene una estructura de comportambiento FIFO
            (First Input, First Output), es decir, lo primero que metas
            aqui, será lo primero que salga, al igual que cuando comes :D
        */
        /*
            Las principales operaciones que se pueden hacer son:
            añadir un elemento, eliminar el elemento de la cola para procesarlo
            y examinar cual es el siguiente elemento de la cola sin quitarlo
        */
        /*
        Formas de tratarlo:
                        Throws exception        Returns special value
        Insertar	add(e)                  offer(e)
        Eliminar	remove()                poll()
        Examinar	element()               peek()
        
        Los catalogados como Throws exception lanzaran una excepcion 
        sí al eliminar o examinar la cola está vacía
        
        Los catalogados como Return special value devuelven null 
        al intentar eliminar o examinar si la cola está vacía
        */
        
        // Declaracion
        
        Queue<String> cola = new LinkedList<>();
        Queue<String> cola2 = new ArrayDeque<>(); // Es una version más eficiente para colas o pilas
        
        cola2.add("Andres");
        cola2.add("Marcos");
        cola2.add("Sandra");
        cola2.add("Sofia");
        System.out.println(cola2); // Los veras introducidos por orden
        cola2.offer("Angel");
        System.out.println(cola2);
        //---------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Probamos a eliminar un elemento (notaras que es el primero):");
        cola2.remove();
        System.out.println(cola2);
        cola2.poll();
        System.out.println(cola2);
        //---------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Probamos a examinar un elemento");
        System.out.println(cola2.element());
        System.out.println(cola2.peek()); // Siempre sera el mismo elemento porque no lo borramos de la lista
        //---------------------------------------------------------------------------------
        System.out.println();
        System.out.println("Tambien podemos recorrerlos con un bucle, pero no es para lo que se suele usar");
        
        // El iterador de las colas atraviesa los elementos sin ningún orden concreto
        for (String s : cola2) { // Esto no es un iterador
            System.out.println(s);
        }
        
        // Para obtener el tamaño de la cola
        System.out.println();
        System.out.println("Tamaño de la cola:");
        System.out.println(cola2.size());
    }
    
    public void pruebaColasPrioridad() {
        /*
            Una cola de prioridad es una cola en la que el elemento que sale es el menor.
            La clase PriorityQueue implementa una cola de prioridad, e implementa la interface Queue
        */
        
        // Declaracion
        // De menor a mayor
        Queue<String> colaPrioridad = new PriorityQueue<>();
        
        /*
        En una cola de prioridad se pueden tener elementos duplicados, 
        o equivalentes, pero no el valor null.
        
        El iterador de una cola de prioridad atravesará los elementos 
        sin ningún orden concreto: la cola de prioridad no tiene 
        por qué tener los elementos en orden: tan solo garantiza que saldrá el menor.
        
        Las colas de prioridad pueden inicializarse para dar sacar el mayor, 
        en lugar del menor, proporcionando un comparador a tal efecto que está 
        en la clase collections al constructor.
        */
        /*
            **************IMPORTANTE*****************
            Recordar el orden mediante la tabla ASCII
            *****************************************
        */
        // Declaracion colaPrioridad al reves
        // De mayor a menor
        Queue<String> colaPrioridadAlReves = new PriorityQueue<>(Collections.reverseOrder()); 
        
        colaPrioridad.add("Andres");
        colaPrioridad.add("Valentin");
        colaPrioridad.add("Zeldris");
        colaPrioridad.add("Bonencio");
        
        System.out.println(colaPrioridad.element());
        colaPrioridad.remove();
        System.out.println(colaPrioridad.element());
        colaPrioridad.remove();
        System.out.println(colaPrioridad.element());
        colaPrioridad.remove();
        System.out.println(colaPrioridad.element());
        colaPrioridad.remove();
        
        System.out.println();
        colaPrioridadAlReves.add("Andres");
        colaPrioridadAlReves.add("Valentin");
        colaPrioridadAlReves.add("Zeldris");
        colaPrioridadAlReves.add("Bonencio");
        
        System.out.println(colaPrioridadAlReves.poll());
        colaPrioridadAlReves.peek();
        System.out.println(colaPrioridadAlReves.poll());
        colaPrioridadAlReves.peek();
        System.out.println(colaPrioridadAlReves.poll());
        colaPrioridadAlReves.peek();
        System.out.println(colaPrioridadAlReves.poll());
        colaPrioridadAlReves.peek();
        System.out.println(colaPrioridadAlReves.poll());
        colaPrioridadAlReves.peek();
        
        // Para obtener el tamaño de la cola de prioridad
        System.out.println();
        System.out.println("Tamaño de la cola de prioridad:");
        System.out.println(colaPrioridad.size());
    }
    
    public void run() {
        // Puedes ir comentando aqui los metodos dependiendo de lo que quieras ver funcionar
        in = new Scanner(System.in);
        
        //Arrays y declaracion
        //pruebaArrays();
        
        //Pruebas con listas
        //pruebaListas();
        
        //Pruebas con Set
        //pruebaSet();
        
        //Pruebas con Maps
        //pruebaMap();
        
        //Pruebas Iteradores
        //pruebaIterator();
        
        //Pruebas Colas
        //pruebaColas();
        
        //Prueba colas de prioridad
        pruebaColasPrioridad();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Listas().run();
    }

    
    
}
