/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo_zad1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author banyaai
 */
public class Wykres {

    private String nazwa = "Wykres";
    private String nazwaOsiX;
    private String nazwaOsiY;

    public Wykres(String nazwaOsiX, String nazwaOsiY) {
        this.nazwaOsiX = nazwaOsiX;
        this.nazwaOsiY = nazwaOsiY;
    }

    public JFreeChart rysuj(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(nazwa, // Title
                nazwaOsiY,
                nazwaOsiX,
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                true, // Show legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
                );
        return chart;
    }
}
