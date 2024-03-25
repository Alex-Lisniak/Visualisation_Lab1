import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;

public class SeptemberFrameFluidityChart extends JFrame {

    public SeptemberFrameFluidityChart(String title) {
        super(title);

        // Create a dataset
        XYDataset dataset = createDataset();

        // Create a chart based on the dataset
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Рівень плинності кадрів у вересні",
                "Підрозділ",
                "Плинність",
                dataset
        );

        // Set custom chart styling
        chart.setBackgroundPaint(Color.white);

        // Create and set up the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private XYDataset createDataset() {
        XYSeries series = new XYSeries("Підрозділ");

        // Додати дані про рівень плинності кадрів у вересні для шести підрозділів
        // Приклади:
        series.add(1, 80);
        series.add(2, 85);
        series.add(3, 82);
        series.add(4, 88);
        series.add(5, 86);
        series.add(6, 83);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SeptemberFrameFluidityChart example = new SeptemberFrameFluidityChart("Рівень плинності кадрів у вересні");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
