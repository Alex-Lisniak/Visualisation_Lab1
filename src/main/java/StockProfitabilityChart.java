import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import javax.swing.*;
import java.awt.*;

public class StockProfitabilityChart extends JFrame {

    public StockProfitabilityChart(String title) {
        super(title);

        // Create a dataset
        TimeSeriesCollection dataset = createDataset();

        // Create a chart based on the dataset
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Прибутковість акцій компанії",
                "Час",
                "Прибуток",
                dataset,
                true,
                true,
                false
        );

        // Set custom chart styling
        chart.setBackgroundPaint(Color.white);

        // Create and set up the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private TimeSeriesCollection createDataset() {
        TimeSeries series = new TimeSeries("Прибутковість акцій");

        // Додавання даних про прибутковість акцій компанії за кожен місяць
        // Приклади:
        series.add(new Month(1, 2023), 100);
        series.add(new Month(2, 2023), 95);
        series.add(new Month(3, 2023), 90);
        series.add(new Month(4, 2023), 85);
        series.add(new Month(5, 2023), 80);
        series.add(new Month(6, 2023), 75);
        // Додавайте інші точки даних за потреби
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StockProfitabilityChart example = new StockProfitabilityChart("Прибутковість акцій компанії");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}