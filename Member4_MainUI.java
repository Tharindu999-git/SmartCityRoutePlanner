import java.util.Scanner;

public class Member4_MainUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Member1_Graph graph = new Member1_Graph();
        Member3_AVLTree tree = new Member3_AVLTree();
        Member2_LocationManager manager = new Member2_LocationManager(graph, tree);

        while (true) {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations (AVL Tree)");
            System.out.println("7. BFS Traversal");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": manager.addLocation(); break;
                case "2": manager.removeLocation(); break;
                case "3": manager.addRoad(); break;
                case "4": manager.removeRoad(); break;
                case "5": graph.displayConnections(); break;
                case "6": tree.display(); break;
                case "7":
                    System.out.print("Enter start location: ");
                    graph.bfsTraversal(sc.nextLine());
                    break;
                case "8":
                    System.out.println("👋 Exiting Smart City Route Planner...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("⚠️ Invalid choice! Try again.");
            }
        }
    }
}
