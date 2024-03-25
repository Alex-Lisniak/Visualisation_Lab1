import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;

public class SellerTimeChart extends JFrame {

    public SellerTimeChart(String title) {
        super(title);

        // Створення датасету
        DefaultPieDataset dataset = createDataset();

        // Створення графіку на основі датасету
        JFreeChart chart = ChartFactory.createPieChart(
                "Витрачений час продавця",
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

        // Додавання даних про час, який продавець витрачає на різні види діяльностей
        dataset.setValue("Час з клієнтами", 15);
        dataset.setValue("Інші активності", 100 - 15);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SellerTimeChart example = new SellerTimeChart("Витрачений час продавця");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}