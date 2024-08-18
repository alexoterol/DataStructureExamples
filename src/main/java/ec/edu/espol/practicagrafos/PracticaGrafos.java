/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.practicagrafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author alexo
 */

/*
Esta es una tarea grupal, colabore con los mismos integrantes de su grupo de proyecto.

Descargue el código esqueleto y complete una implementación de un grafo en Java basado en listas de adyacencia. Implemente, al menos, los siguientes métodos:

recorrer, que retorna los contenidos de los vértices visitados dado un vértice inicial.
hayUnCamino, que recibe dos vértices y retorna verdadero o falso dependiendo de si existe un camino entre ellos.
esConexo, que retorna verdadero o falso dependiendo de si el grafo es conexo o no.
Lea con detalle los comentarios.

Pruebe sus métodos en el main.
*/
public class PracticaGrafos {
    public static <V, E> List<V> getCercoEpidemiologico(Graph<V, E> grafo, V nombrePersona, int grado) {
        // Creamos un conjunto para almacenar las personas visitadas y evitar ciclos
        HashSet<V> visitados = new HashSet<>();
        // Creamos una cola para manejar la búsqueda en anchura (BFS)
        Queue<Graph<V, E>.Vertex> cola = new LinkedList<>();
        // Lista para almacenar las personas del cerco epidemiológico
        List<V> cercoEpidemiologico = new ArrayList<>();

        // Obtener el vértice de la persona inicial
        Graph<V, E>.Vertex personaInicial = grafo.vertices.get(nombrePersona);
        if (personaInicial == null) {
            return cercoEpidemiologico; // Retorna una lista vacía si no existe la persona en el grafo
        }

        // Añadir la persona inicial a la cola y marcarla como visitada
        cola.offer(personaInicial);
        visitados.add(personaInicial.contenido);

        int nivelActual = 0;
        while (!cola.isEmpty() && nivelActual < grado) {
            int nivelSize = cola.size();
            for (int i = 0; i < nivelSize; i++) {
                Graph<V, E>.Vertex actual = cola.poll();
                for (Graph<V, E>.Edge lado : actual.lados) {
                    V vecino = lado.llegada.contenido;
                    if (!visitados.contains(vecino)) {
                        cola.offer(lado.llegada);
                        visitados.add(vecino);
                    }
                }
            }
            nivelActual++;
        }

        // Al final del BFS, las personas en la cola representan el cerco epidemiológico de grado n
        while (!cola.isEmpty()) {
            cercoEpidemiologico.add(cola.poll().contenido);
        }

        // Ordenar la lista alfabéticamente antes de retornarla

        return cercoEpidemiologico;
    }
public static void main(String[] args) {
        Graph<String,Integer> g = new Graph<String,Integer>();
        g.addVertex("Guayaquil");
        g.addVertex("Manta");
        g.addVertex("Quito");
        g.addVertex("Cuenca");
        g.addVertex("Zamora");
        g.addVertex("Salinas");
        g.addEdge("Guayaquil", "Manta", 200, 200);
        g.addEdge("Guayaquil", "Quito", 400, 400);
        g.addEdge("Guayaquil", "Cuenca", 150, 150);
        g.addEdge("Manta", "Quito", 100, 100);
        g.addEdge("Quito", "Zamora", 230, 230);
        g.addEdge("Quito", "Cuenca", 900, 900);
        g.addEdge("Cuenca", "Salinas", 400, 400);
        g.addEdge("Quito", "Salinas", 100, 100);
        g.addEdge("Manta", "Zamora", 300, 300);
        g.addEdge("Salinas", "Zamora", 600, 600);
        
        System.out.println(g.dijkstra("Guayaquil"));
        System.out.println(g.dijkstra("Quito"));
        System.out.println(g.dijkstra("Zamora"));

        Graph<String, Object> grafo = new Graph<>();
        // Añadir los vértices (personas) al grafo
        grafo.addVertex("Gonzalo");
        grafo.addVertex("Diana");
        grafo.addVertex("José");
        grafo.addVertex("Letty");
        grafo.addVertex("Luis");
        grafo.addVertex("Mafer");
        grafo.addVertex("Raquel");
        grafo.addVertex("Pedro");
        grafo.addVertex("Ana");

        // Añadir las conexiones (contactos directos) entre las personas
        grafo.addEdge("Gonzalo", "Diana", null);
        grafo.addEdge("Gonzalo", "José", null);
        grafo.addEdge("Gonzalo", "Letty", null);
        grafo.addEdge("Gonzalo", "Luis", null);
        grafo.addEdge("Gonzalo", "Mafer", null);
        grafo.addEdge("Gonzalo", "Raquel", null);
        grafo.addEdge("Luis", "Pedro", null);
        grafo.addEdge("Pedro", "Ana", null);
        
        System.out.println(grafo);

        List<String> cercoGrado1 = getCercoEpidemiologico(grafo, "Gonzalo", 1);
        System.out.println("Cerco epidemiológico de grado 1 para Gonzalo: " + cercoGrado1);

        List<String> cercoGrado2 = getCercoEpidemiologico(grafo, "Luis", 1);
        System.out.println("Cerco epidemiológico de grado 2 para Gonzalo: " + cercoGrado2);
    }
}
