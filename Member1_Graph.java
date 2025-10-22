import java.util.*;

public class Member1_Graph {
    private Map<String, List<String>> adjList;

    public Member1_Graph() {
        adjList = new HashMap<>();
    }

    public void addLocation(String name) {
        if (!adjList.containsKey(name)) {
            adjList.put(name, new ArrayList<>());
            System.out.println("✅ Location added: " + name);
        } else {
            System.out.println("⚠️ Location already exists.");
        }
    }

    public void removeLocation(String name) {
        if (!adjList.containsKey(name)) {
            System.out.println("⚠️ Location not found.");
            return;
        }
        adjList.remove(name);
        for (List<String> neighbors : adjList.values()) {
            neighbors.remove(name);
        }
        System.out.println("🗑️ Location removed: " + name);
    }

    public void addRoad(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            System.out.println("⚠️ One or both locations not found.");
            return;
        }
        adjList.get(from).add(to);
        adjList.get(to).add(from);
        System.out.println("🛣️ Road added between " + from + " and " + to);
    }

    public void removeRoad(String from, String to) {
        if (adjList.containsKey(from)) adjList.get(from).remove(to);
        if (adjList.containsKey(to)) adjList.get(to).remove(from);
        System.out.println("❌ Road removed between " + from + " and " + to);
    }

    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No locations available.");
            return;
        }
        System.out.println("\n--- City Connections ---");
        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }

    // BFS Traversal (Queue)
    public void bfsTraversal(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("⚠️ Starting location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.println("\n🚍 BFS Route from " + start + ":");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public boolean contains(String location) {
        return adjList.containsKey(location);
    }
}
