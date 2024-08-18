/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.practicagrafos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author alexo
 */

// V es el tipo de objeto que se almacena en el Vértice,
//  en algunos ejemplos hemos dicho que se trata de una Ciudad
// E es el tipo de objeto que se almacena en el Arco,
//  en esos mismos ejemplos representa a la distancia entre ciudades
    
public class Graph<V,E> {
    // Escogí un HashMap para que sea fácil encontrar al vértice
    //   correspondiente a un valor en partícular.
    // Por ejemplo si quisiera encontrar al vértice que contiene
    //   a la ciudad de Guayaquil.
    HashMap<V,Vertex> vertices;
    boolean esDirigido;
    
    public Graph(){
        vertices = new HashMap<V,Vertex>();
        esDirigido = false;
    }

    public Graph(boolean esDirigido){
        vertices = new HashMap<V,Vertex>();
        this.esDirigido = esDirigido;
    }

    protected class Vertex{
        public V contenido;
        public ArrayList<Edge> lados;
        
        public Vertex(V v){
            // El contenido del Vertice "Guayaquil", se almacena.
            contenido = v;
            // No hay vértices adyacentes aún.
            lados = new ArrayList<Edge>();
        }
        
        
        public String adyacentes(){
            String s="";
            for(final Edge e:lados){
                s+=e.llegada.contenido+",";
            }
            if(!s.isEmpty()) s=s.substring(0, s.length()-1);
            return ""+contenido+": {"+s+"}";  
        }
        
        public String toString(){
            return ""+contenido;
        }
    }
    protected class Edge{
        public E contenido;
        public Vertex partida, llegada;
        public float peso;

        public Edge(Vertex partida, Vertex llegada, E e){
            contenido = e;
            // Si tenemos acceso al Vertex como objeto
            this.partida = partida;
            this.llegada = llegada;
            peso = 0;
        }
         public Edge(Vertex ppeartida, Vertex llegada, E e, float peso){
            contenido = e;
            // Si tenemos acceso al Vertex como objeto
            this.partida = ppeartida;
            this.llegada = llegada;
            this.peso = peso;
        }
        public Edge(V partida, V llegada, E e){
            contenido = e;
            // Si tenemos solo acceso a los contenidos
            //   Conectar a "Guayaquil" con "Manta"
            Vertex p = vertices.get(partida);
            Vertex l = vertices.get(llegada);
            this.partida = p;
            this.llegada = l;
            peso = 0;
        }
        public Edge(V partida, V llegada, E e, float peso){
            contenido = e;
            // Si tenemos solo acceso a los contenidos
            //   Conectar a "Guayaquil" con "Manta"
            Vertex p = vertices.get(partida);
            Vertex l = vertices.get(llegada);
            this.partida = p;
            this.llegada = l;
            this.peso = peso;
        }
    }
    
    public String toString(){
        String s = "";
        for(final Vertex v:vertices.values()){
            s+="  "+v.adyacentes()+"\n";
        }
        return "Vertices: {\n"+s+"}";
    }

    public V addVertex(V v){
        // COMPLETAR
        // Se debe añadir un Vértice con este contenido nuevo al grafo
        if (!vertices.containsKey(v)) {
            Vertex nuevo = new Vertex(v);
            vertices.put(v, nuevo);
        }
        return v;
    }
        

    public E addEdge(V partida, V llegada, E e){
        // COMPLETAR
        // Considerar si el grafo es dirigido o no
        Vertex p = vertices.get(partida);
        Vertex l = vertices.get(llegada);
        if (p != null && l != null) {
            Edge arista = new Edge(p, l, e);
            p.lados.add(arista);
            if (!esDirigido) {
                Edge aristaReversa = new Edge(l, p, e);
                l.lados.add(aristaReversa);
            }
            return e;
        }
        return null;
    }
    
     public E addEdge(V partida, V llegada, E e, float peso){
        // COMPLETAR
        // Considerar si el grafo es dirigido o no
        Vertex p = vertices.get(partida);
        Vertex l = vertices.get(llegada);
        if (p != null && l != null) {
            Edge arista = new Edge(p, l, e, peso);
            p.lados.add(arista);
            if (!esDirigido) {
                Edge aristaReversa = new Edge(l, p, e, peso);
                l.lados.add(aristaReversa);
            }
            return e;
        }
        return null;
    }
        
        

    public List<V> recorrer(V inicio){
        // Anotar que vertices han sido visitados
        //   tambien se podría utilizar un set
        ArrayList<V> visitados = new ArrayList<V>();
        // Es posible que el contenido no exista como un vertice
        Vertex i = vertices.get(inicio);
        if(i == null) return visitados;
        
        // El Deque ocasionaría un recorrido en ... ¿?
        Queue<Vertex> porRecorrer = new ArrayDeque<Vertex>();
        porRecorrer.offer(i);

        while(!porRecorrer.isEmpty()){
            // 1: Obtener el siguiente por visitar
            Vertex actual = porRecorrer.poll();
            if(!visitados.contains(actual.contenido)){
                // 2: Marcarlo y utilizarlo
                visitados.add(actual.contenido);
                // 3: Añadir sus adyacentes a porRecorrer
                for(Edge e : actual.lados){
                    if(!visitados.contains(e.llegada.contenido)){
                        porRecorrer.offer(e.llegada);
                    }
                }
            }
        }
        
        return visitados;
    }
    

    // Si no importa el vertice inicial, puedo escoger uno cualquiera.
    // Puedo escoger el primero en salir del set.
    public List<V> recorrer(){
        return recorrer(vertices.entrySet().iterator().next().getKey());
    }


    public boolean hayUnCamino(V partida, V llegada){
        // Esto no es lo mismo que decir si son adyacentes.
        // Queremos saber si partiendo de A se puede llegar a B.
        // Es sencillo realizando un recorrido partiendo de A
        //   y verificando que se visito B.
        List<V> visitados = recorrer(partida);
        return visitados.contains(llegada);
    }

    // Considere la definición de "Fuertemente Conexo"
    //   Desde cualquier vertice se pueden visitar todos los otros
    public boolean esConexo(){
        if(vertices.isEmpty()) return true;
        for(V v: vertices.keySet()){
            HashSet<V> visitados = new HashSet<>(recorrer(v));
            if(!visitados.equals(vertices.keySet())){
                return false;
            }
        }
        return true;
    }
    
    protected class Node{
            public V contenido;
            public List<Vertex> vertices;
            public float distancia;
            public Node(V contenido, List<Vertex> vertices, float distancia){
                this.contenido = contenido;
                this.vertices = vertices;
                this.distancia = distancia;
            }
            public String toString(){
                return "{"+contenido+"="+vertices.toString()+",distancia="+distancia+"}";
            }
            
    }
    
    public List<Node> dijkstra(V inicio){
        
        for(V v: vertices.keySet()){
            Vertex vertice = vertices.get(v);
            for(Edge e: vertice.lados){
                if(e.peso < 0){
                    return null;
                }
            }
        }
        
        Vertex start = vertices.get(inicio);
        
        // En esta definición retornamos los caminos mas cortos,
        //  tecnicamente se pueden calcular las distancias desde cada una de estas listas
        HashMap<Vertex,List<Vertex>> caminosMasCortos = new HashMap<Vertex,List<Vertex>>();
        // Considere que conllevaría también retornar las distancias.
        //  Requeriría de una estructura de retorno un poco más compleja.
        //  ¿Cómo lo haría?
        HashMap<Vertex,Float> distancias = new HashMap<Vertex,Float>();
        HashSet<Vertex> visitados = new HashSet<Vertex>();

        // Considere que la info necesaria para ordenar no se encuentra de hecho dentro del vértice
        // Sin embargo, el mapa de distancias es accesible dentro del comparator
        // Si no fuese este el caso, podríamos crear una clase interna a esta función dijkstra
        //  que tuviera un vértice y sus datos importantes para el algoritmo como la distancia y el camino
        // ¿Cambiaría la eficiencia del algoritmo?
        PriorityQueue<Vertex> porVisitar = new PriorityQueue<Vertex>((v1, v2)->{
            return distancias.get(v1).compareTo(distancias.get(v2));
        });

        // Marcamos todas las distancias a los vertice como infinitas, no hemos visitado nada aún
        for(Vertex v: vertices.values()) distancias.put(v, -1.0f);

        // Paso 1, marcamos la distancia y camino mas corto para el vertice inicial
        distancias.put(start, 0.0f);
        porVisitar.offer(start);
        caminosMasCortos.put(start, new ArrayList<Vertex>(Arrays.asList(start)));

        while(!porVisitar.isEmpty()){
            Vertex actual = porVisitar.poll();
            visitados.add(actual);

            for(Edge lado: actual.lados){
                Vertex adyacente = lado.llegada;
                // si el nodo adyacente no ha sido visitado aún
                // significa que aún se puede ir mejorando la ruta hacía él
                if(!visitados.contains(adyacente)){
                    float mejorDistanciaHastaAhora = distancias.get(adyacente);

                    // Para utilizar dijkstra se debió añadir un atributo peso a cada lado
                    //  El contenido genérico pudiera ser comparado mediante comparators,
                    //  pero eso no hubiera asegurado la posibilidad de sumar dos "contenidos".
                    //  Por lo tanto requerimos de está abstracción.
                    // Deben modificar su Clase Lado/Edge apropiadamente.
                    float distanciaPorEsteLado = distancias.get(actual)+lado.peso;

                    // SI aun no existe una ruta hacia el vertice
                    // O  si la ruta nueva es mejor
                    if(mejorDistanciaHastaAhora == -1 || distanciaPorEsteLado < mejorDistanciaHastaAhora){
                        // La ruta hasta el nodo anterior
                        List<Vertex> nuevaRuta = new ArrayList<Vertex>(caminosMasCortos.get(actual));
                        // se añade a dicha ruta el nuevo nodo
                        nuevaRuta.add(adyacente);
                        // se la anota
                        caminosMasCortos.put(adyacente, nuevaRuta);
                        distancias.put(adyacente,distanciaPorEsteLado);

                        // el remover el elemento fuerza una recalculación de orden en la cola de prioridad
                        // si no existía, el método remove devuelve falso... 
                        // ¿Esto afecta la complejidad del algoritmo?
                        porVisitar.remove(adyacente);
                        // añadimos el adyacente que se ubicará según su distancia recientemente calculada
                        porVisitar.offer(adyacente);
                    }
                }
            }
        }
        
        ArrayList<Node> resultado = new ArrayList<>();
        
        for(Vertex v: vertices.values()){
            V contenido = v.contenido;
            List<Vertex> caminos = caminosMasCortos.get(v);
            float distancia = distancias.get(v);
            Node nodo = new Node(contenido,caminos,distancia);
            resultado.add(nodo);
        }

        // Al quedar vacía la cola de prioridad, todos los vértices que se podían alcanzar desde "start" habrían sido visitados
        // Se retornan los caminos que se ha logrado calcular hacia ellos
        return resultado;
    }
}
