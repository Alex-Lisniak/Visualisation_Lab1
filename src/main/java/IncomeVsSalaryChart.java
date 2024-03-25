import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;

public class IncomeVsSalaryChart extends JFrame {

    public IncomeVsSalaryChart(String title) {
        super(title);

        // Створення датасету
        XYDataset dataset = createDataset();

        // Створення графіку на основі датасету
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Зв'язок між доходами та зарплатою",
                "Зарплата (грн)",
                "Дохід (грн)",
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
        XYSeries series = new XYSeries("Зв'язок між доходами та зарплатою");

        // Додавання даних про зв'язок між доходами та зарплатою
        // Приклади:
        series.add(20000, 20000);
        series.add(30000, 30000);
        series.add(40000, 40000);
        series.add(50000, 50000);
        series.add(60000, 60000);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IncomeVsSalaryChart example = new IncomeVsSalaryChart("Зв'язок між доходами та зарплатою");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
