package GuessGame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

/**
 * Created by Ross on 25.09.2017.
 */
public class Chart extends ApplicationFrame {
    private static final long serialVersionUID = 1L;

    public Chart(final String title) {
        super(title);

        CategoryDataset dataset = Dataset.createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(1000, 500));
        setContentPane(chartPanel);
    }
    private JFreeChart createChart(final CategoryDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
                "Загадано число от 1 до 10",   // chart title
                "Количество угадываний за 100 попыток",                  // domain axis label
                "Число попаданий",                  // range axis label
                dataset,                  // data
                PlotOrientation.VERTICAL, // orientation
                true,                     // include legend
                true,                     // tooltips?
                false                     // URLs?
        );
        // Определение фона диаграммы
        chart.setBackgroundPaint(new Color(0xFFFFFF));

        // Настройка plot'а
        CategoryPlot plot = chart.getCategoryPlot();

        plot.setBackgroundPaint(new Color(170, 199, 248));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.getRenderer().setSeriesPaint(0, new Color(132, 255, 203));


        // Настройка значений меток NumberAxis (только целочисленные значения)
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setUpperMargin(0.15);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // .UP_90);
        domainAxis.setTickLabelsVisible(false);

        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);



        return chart;
    }
    public static void main(final String[] args) {

        final Chart demo = new Chart("Распределение случайных величин");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}