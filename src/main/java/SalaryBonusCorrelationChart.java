import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;

public class SalaryBonusCorrelationChart extends JFrame {

    public SalaryBonusCorrelationChart(String title) {
        super(title);

        // Створення датасету
        XYDataset dataset = createDataset();

        // Створення графіку на основі датасету
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Кореляція між розміром надбавки та трудовим стажем",
                "Трудовий стаж (роки)",
                "Розмір надбавки (грн)",
                dataset
        );

        // Налаштування стилю графіку
        chart.setBackgroundPaint(Color.white);

        // Створення та налаштування панелі графіку
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private XYDataset createDataset() {
        XYSeries series = new XYSeries("Працівники");

        // Додавання даних про розмір надбавки та трудовий стаж працівників
        // У цьому прикладі ми припускаємо відсутність кореляції
        // Приклади:
        series.add(5, 300);   // 5 років стажу, 300 грн надбавки
        series.add(10, 310);  // 10 років стажу, 310 грн надбавки
        series.add(15, 320);  // 15 років стажу, 320 грн надбавки
        series.add(20, 305);  // 20 років стажу, 305 грн надбавки
        series.add(25, 315);  // 25 років стажу, 315 грн надбавки

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SalaryBonusCorrelationChart example = new SalaryBonusCorrelationChart("Кореляція між розміром надбавки та трудовим стажем");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}