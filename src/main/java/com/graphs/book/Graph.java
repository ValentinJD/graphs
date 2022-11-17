package com.graphs.book;

import java.util.ArrayList;
import java.util.List;

// Класс для представления graphического объекта
public class Graph {
    // Список списков для представления списка смежности
    List<List<Integer>> adjList = new ArrayList<>();

    // Конструктор для построения Graphа
    public Graph(List<Edge> edges)
    {
        // найти вершину с максимальным номером
        int n = 0;
        for (Edge e: edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        // выделяем память для списка смежности
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // добавляем ребра в ориентированный graph
        for (Edge current: edges)
        {
            // выделяем новый узел в списке смежности от src до dest
            adjList.get(current.src).add(current.dest);

            // раскомментировать строку ниже для неориентированного Graph

            // выделяем новый узел в списке смежности от места назначения до источника
            // adjList.get(current.dest).add(current.src);
        }
    }

    // Функция для печати представления списка смежности Graph
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();

        while (src < n)
        {
            // вывести текущую вершину и все соседние с ней вершины
            for (int dest: graph.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }

    public static List<Edge> getRoute(Edge start, Edge end, Graph graph) {
        return null;
    }
}
