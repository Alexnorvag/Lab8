package by.norvag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Created by norvag on 29.02.2016.
 * Реализовать класс Graph, представляющий собой неориентированный граф.
 * В конструкторе класса передается количество вершин в графе.
 * Методы должны поддерживать быстрое добавление и удаление ребер.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Количество вершин в графе: ");
        int VertexCount = Integer.parseInt(reader.readLine());
        Graph graph = new Graph(VertexCount, reader);

        Map<String, List<String>> map = graph.getVertexMap();
        for (Map.Entry<String, List<String>> pair : map.entrySet()) {
            String key = pair.getKey();
            List<String> value = pair.getValue();
            for (int i = 0; i < value.size(); i++)
                System.out.println("(" + key + "; " + value.get(i) + ")");
        }
    }
}
