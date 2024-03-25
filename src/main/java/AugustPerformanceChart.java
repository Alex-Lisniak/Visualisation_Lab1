import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;

public class AugustPerformanceChart extends JFrame {

    public AugustPerformanceChart(String title) {
        super(title);

        // Створення датасету
        DefaultCategoryDataset dataset = createDataset();

        // Створення графіку на основі датасету
        JFreeChart chart = ChartFactory.createBarChart(
                "Успішність студентів у серпні",
                "Студенти",
                "Успішність",
                dataset
        );

        // Налаштування стилю графіку
        chart.setBackgroundPaint(Color.white);

        // Створення та налаштування панелі графіку
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Додавання даних про успішність студентів у серпні
        dataset.addValue(90, "Успішність", "Студент 1");
        dataset.addValue(90, "Успішність", "Студент 2");
        dataset.addValue(80, "Успішність", "Студент 3");
        dataset.addValue(75, "Успішність", "Студент 4");
        dataset.addValue(70, "Успішність", "Студент 5");
        dataset.addValue(65, "Успішність", "Студент 6");
        dataset.addValue(60, "Успішність", "Студент 7");
        dataset.addValue(55, "Успішність", "Студент 8");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AugustPerformanceChart example = new AugustPerformanceChart("Успішність студентів у серпні");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
