import java.util.Scanner;

public class Member2_LocationManager {
    private Member1_Graph graph;
    private Member3_AVLTree tree;
    private Scanner sc;

    public Member2_LocationManager(Member1_Graph graph, Member3_AVLTree tree) {
        this.graph = graph;
        this.tree = tree;
        this.sc = new Scanner(System.in);
    }

    public void addLocation() {
        System.out.print("Enter location name: ");
        String loc = sc.nextLine();
        graph.addLocation(loc);
        tree.insert(loc);
    }

    public void removeLocation() {
        System.out.print("Enter location name to remove: ");
        String loc = sc.nextLine();
        graph.removeLocation(loc);
        System.out.println("(Tree removal not implemented for simplicity)");
    }

    public void addRoad() {
        System.out.print("Enter first location: ");
        String l1 = sc.nextLine();
        System.out.print("Enter second location: ");
        String l2 = sc.nextLine();
        graph.addRoad(l1, l2);
    }

    public void removeRoad() {
        System.out.print("Enter first location: ");
        String l1 = sc.nextLine();
        System.out.print("Enter second location: ");
        String l2 = sc.nextLine();
        graph.removeRoad(l1, l2);
    }
}
