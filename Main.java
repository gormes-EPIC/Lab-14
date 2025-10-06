import java.io.IOException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Heatmap heatmap = new Heatmap(20, 20, "heatmap_20x20.csv");

        System.out.println("Heatmap 1: ");
        System.out.println("Total sum: " + heatmap.sumHeatmap()); // 14321.831999999997
        System.out.println("Total avg: " + heatmap.avgHeatmap()); // 35.804579999999994

        System.out.println("Sum row 10: " + heatmap.sumRow(10)); // 1190.7696
        System.out.println("Sum col 7: " + heatmap.sumColumn(7)); // 1056.1179999999997

        System.out.println("Are cold: " + heatmap.areCold()); // 48

        System.out.println("\nHeatmap 2: ");
        Heatmap heatmap2 = new Heatmap(20, 20, "heatmap_gradient.csv");

        System.out.println("Total sum: " + heatmap2.sumHeatmap()); // 20000.000000000004
        System.out.println("Total avg: " + heatmap2.avgHeatmap()); // 50.00000000000001

        System.out.println("Sum row 15: " + heatmap2.sumRow(15)); // 1289.4699999999998
        System.out.println("Sum col 2: " + heatmap2.sumColumn(2)); // 605.26

        System.out.println("Are cold: " + heatmap2.areCold()); // 10

        System.out.println("\nHeatmap 3: ");
        Heatmap heatmap3 = new Heatmap(20, 20, "heatmap_random.csv");

        System.out.println("Total sum: " + heatmap3.sumHeatmap()); // 19988.90999999999
        System.out.println("Total avg: " + heatmap3.avgHeatmap()); // 49.972274999999975

        System.out.println("Sum row 1: " + heatmap3.sumRow(1)); // 1018.3099999999998
        System.out.println("Sum col 14: " + heatmap3.sumColumn(14)); // 893.86

        System.out.println("Are cold: " + heatmap3.areCold()); // 36

        heatmap.printHeatmap();

        // Visually displays the heatmap
        JFrame frame = new JFrame("My Heatmap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new HeatmapViewer(heatmap)); // Change which heatmap you want to view here
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}