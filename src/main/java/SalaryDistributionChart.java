import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;

public class SalaryDistributionChart extends JFrame {

    public SalaryDistributionChart(String title) {
        super(title);

        // Create a dataset
        DefaultPieDataset dataset = createDataset();

        // Create a chart based on the dataset
        JFreeChart chart = ChartFactory.createPieChart(
                "Розподіл зарплат",  // Chart title
                dataset,             // Chart dataset
                true,                // Include legend
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

    private DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Додайте дані про розподіл зарплат
        dataset.setValue("10-15 тис. грн", 75);
        dataset.setValue("Інші", 25);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalaryDistributionChart example = new SalaryDistributionChart("Розподіл зарплат");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
