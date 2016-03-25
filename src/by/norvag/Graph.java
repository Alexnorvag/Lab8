package by.norvag;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by norvag on 29.02.2016.
 * Реализовать класс Graph, представляющий собой неориентированный граф.
 * В конструкторе класса передается количество вершин в графе.
 * Методы должны поддерживать быстрое добавление и удаление ребер.
 */

public class Graph {
    private HashMap<String, List<String>> vertexMap = new HashMap<String, List<String>>();
    private int _VertexCount;

    public Graph (int VertexCount, BufferedReader reader) throws IOException {
        _VertexCount = VertexCount;
        for (int i = 0; i < _VertexCount; i++) {
            addVertex(Integer.toString(i));
        }

        System.out.println("Добавление рёбер:");
        while (true) {
            String vertexName1 = reader.readLine();
            String vertexName2 = reader.readLine();
            if (!vertexName1.equals("exit"))
                addEdge(vertexName1, vertexName2);
            else break;
        }
        System.out.println("Удаление рёбер: ");
        while (true) {
            String vertexName1 = reader.readLine();
            String vertexName2 = reader.readLine();
            if (!vertexName1.equals("exit"))
                removeEdge(vertexName1, vertexName2);
            else break;
        }
    }

    public void addVertex(String vertexName) {
        if (!hasVertex(vertexName))
            vertexMap.put(vertexName, new ArrayList<String>());
    }

    public boolean hasVertex (String vertexName) {
        return vertexMap.containsKey(vertexName);
    }

    public void addEdge (String vertexName1, String vertexName2) {
        if (!hasVertex(vertexName1)) addVertex(vertexName1);
        if (!hasVertex(vertexName2)) addVertex(vertexName2);
        List<String> edges1 = vertexMap.get(vertexName1);
        List<String> edges2 = vertexMap.get(vertexName2);
        edges1.add(vertexName2);
        edges2.add(vertexName1);
        Collections.sort(edges1);
        Collections.sort(edges2);
    }

    public void removeEdge (String vertexName1, String vertexName2) {
        if (vertexMap.containsKey(vertexName1) && vertexMap.containsKey(vertexName2)) {
            List<String> edges1 = vertexMap.get(vertexName1);
            List<String> edges2 = vertexMap.get(vertexName2);
            edges1.remove(vertexName2);
            edges2.remove(vertexName1);
            Collections.sort(edges1);
            Collections.sort(edges2);
        }
    }

    public Map<String, List<String>> getVertexMap() {
        return vertexMap;
    }
}
