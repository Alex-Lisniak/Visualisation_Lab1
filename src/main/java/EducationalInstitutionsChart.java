import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

public class EducationalInstitutionsChart extends JFrame {

    public EducationalInstitutionsChart(String title) {
        super(title);


        // Create a dataset
        DefaultCategoryDataset dataset = createDataset();

        // Create a chart based on the dataset
        JFreeChart chart = ChartFactory.createLineChart(
                "Прогноз кількості навчальних закладів за 10 років", // Chart title
                "Рік",                    // X-axis label
                "Кількість закладів",     // Y-axis label
                dataset                   // Chart dataset
        );

        // Set custom chart styling
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black);

        // Create and set up the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Додайте дані про прогнозовану кількість навчальних закладів для кожного року
        // Приклад:
        dataset.addValue(1000, "Заклади", "2024");
        dataset.addValue(950, "Заклади", "2025");
        dataset.addValue(920, "Заклади", "2026");
        dataset.addValue(890, "Заклади", "2027");
        dataset.addValue(850, "Заклади", "2028");
        dataset.addValue(820, "Заклади", "2029");
        dataset.addValue(800, "Заклади", "2030");
        dataset.addValue(780, "Заклади", "2031");
        dataset.addValue(750, "Заклади", "2032");
        dataset.addValue(720, "Заклади", "2033");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EducationalInstitutionsChart example = new EducationalInstitutionsChart("Прогноз кількості навчальних закладів");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
