import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;

public class EmployeeTurnoverChart extends JFrame {

    public EmployeeTurnoverChart(String title) {
        super(title);

        // Create a dataset
        XYDataset dataset = createDataset();

        // Create a chart based on the dataset
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Плинність кадрів минулого року",
                "Вік",
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
        XYSeries series = new XYSeries("Плинність кадрів");

        // Додати дані про плинність кадрів для різних вікових груп
        // Приклади:
        series.add(25, 10);
        series.add(30, 50);
        series.add(31, 50);
        series.add(35, 45);
        series.add(33, 45);
        series.add(33, 45);
        series.add(34, 45);
        series.add(40, 20);
        series.add(42, 20);
        series.add(45, 15);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeTurnoverChart example = new EmployeeTurnoverChart("Плинність кадрів минулого року");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}