import javax.swing.*;
import java.awt.*;

public class HeatmapViewer extends JPanel {
    private double[][] data;
    private int cellSize = 20; // size of each square in pixels

    public HeatmapViewer(Heatmap heatmap) {
        // Access the Heatmap's private data via a getter or reflection
        this.data = getDataFromHeatmap(heatmap);
    }

    private double[][] getDataFromHeatmap(Heatmap heatmap) {
        try {
            java.lang.reflect.Field f = heatmap.getClass().getDeclaredField("data");
            f.setAccessible(true);
            return (double[][]) f.get(heatmap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (data == null) return;

        int rows = data.length;
        int cols = data[0].length;

        // find min and max for normalization
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double[] row : data) {
            for (double v : row) {
                if (v < min) min = v;
                if (v > max) max = v;
            }
        }

        // draw each cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                double norm = (max == min) ? 0.5 : (data[r][c] - min) / (max - min);
                g.setColor(getHeatColor(norm));
                g.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);
            }
        }
    }

    // Simple heat color: blue → cyan → green → yellow → red
    private Color getHeatColor(double value) {
        if (value < 0.25) return new Color(0, (int)(255 * (value / 0.25)), 255);         // blue → cyan
        else if (value < 0.5) return new Color(0, 255, (int)(255 * (1 - (value - 0.25) / 0.25))); // cyan → green
        else if (value < 0.75) return new Color((int)(255 * ((value - 0.5)/0.25)), 255, 0);      // green → yellow
        else return new Color(255, (int)(255 * (1 - (value - 0.75)/0.25)), 0);          // yellow → red
    }

    @Override
    public Dimension getPreferredSize() {
        if (data == null) return new Dimension(400, 400);
        return new Dimension(data[0].length * cellSize, data.length * cellSize);
    }
}
