import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;

public class GasolineQualityCorrelationChart extends JFrame {

    public GasolineQualityCorrelationChart(String title) {
        super(title);

        // Create a dataset
        XYDataset dataset = createDataset();

        // Create a chart based on the dataset
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Кореляція між ціною та якістю бензину",
                "Ціна (грн)",
                "Якість",
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
        XYSeries series = new XYSeries("Бензин");

        // Додати дані про ціну та якість бензину
        // Приклади:
        series.add(32, 4);
        series.add(35, 3);
        series.add(40, 2);
        series.add(45, 2);
        series.add(50, 1);
        series.add(55, 1);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GasolineQualityCorrelationChart example = new GasolineQualityCorrelationChart("Кореляція між ціною та якістю бензину");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}