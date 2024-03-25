import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;

public class ProductionShareChart extends JFrame {

    public ProductionShareChart(String title) {
        super(title);

        // Створення датасету
        DefaultPieDataset dataset = createDataset();

        // Створення графіку на основі датасету
        JFreeChart chart = ChartFactory.createPieChart(
                "Діяльність фондів",
                dataset,
                true,
                true,
                false
        );

        // Налаштування стилю графіку
        chart.setBackgroundPaint(Color.white);

        // Створення та налаштування панелі графіку
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Додавання даних про частку фондів, задіяних у виробництві
        dataset.setValue("Виробництво", 40);
        dataset.setValue("Розпил коштів", 30);
        dataset.setValue("Благодійність", 10);
        dataset.setValue("Не виробництво", 20);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductionShareChart example = new ProductionShareChart("Діяльність фондів");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
