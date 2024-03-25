import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

public class BirthRateChart extends JFrame {

    public BirthRateChart(String title) {
        super(title);

        // Create a dataset
        DefaultCategoryDataset dataset = createDataset();

        // Create a chart based on the dataset
        JFreeChart chart = ChartFactory.createBarChart(
                "Народжуваність за регіонами",
                "Регіон",
                "Кількість народжень",
                dataset
        );

        // Set custom chart styling
        chart.setBackgroundPaint(Color.white);

        // Create and set up the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Додавання даних про кількість народжень для кожного регіону
        // Приклади:
        dataset.addValue(2000, "Кількість народжень", "Північний регіон");
        dataset.addValue(1800, "Кількість народжень", "Східний регіон");
        dataset.addValue(1500, "Кількість народжень", "Західний регіон");
        dataset.addValue(1000, "Кількість народжень", "Південний регіон");
        dataset.addValue(500, "Кількість народжень", "Центральний регіон");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BirthRateChart example = new BirthRateChart("Народжуваність за регіонами");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
