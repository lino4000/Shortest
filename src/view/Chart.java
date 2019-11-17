/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author lino4000
 */
public class Chart {
    private final ChartPanel pnChart;
    private final JFreeChart chart;
    private final XYSeriesCollection dataset;
    
    public Chart(JPanel pn){
        dataset = new XYSeriesCollection();
        chart = createChart();
        pnChart = new ChartPanel(chart);
        setChartPanel();
        pnChart.setMouseWheelEnabled(true);
        pn.setLayout(new java.awt.BorderLayout());
        pn.add(pnChart,BorderLayout.CENTER);
        pn.validate();
        pn.repaint();
    }
    
    public void addSeries(List<String> series){
        series.forEach((s) -> {
            dataset.addSeries(new XYSeries(s));
        });
    }
    
    public void update(int serie, double x, double y){
        dataset.getSeries(serie).addOrUpdate(x, y);
    }
    
    public void repaint(){
        pnChart.paintImmediately(0,0,pnChart.getWidth(),pnChart.getHeight());
    }
    
    public void removeAll(){
        dataset.removeAllSeries();
        pnChart.paintImmediately(0,0,pnChart.getWidth(),pnChart.getHeight());
    }
    
    private JFreeChart createChart(){
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Tempo de ordenação por quantidade de elementos",
            "Quantidade",
            "Tempo",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        setPlot(chart.getXYPlot());
        return chart;
    }

    private void setChart(JFreeChart chart){
        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Tempo de ordenação por quantidade de elementos",
                new Font("Tahoma", Font.PLAIN, 11)//new Font("Verdana", Font.BOLD, 16)
            )
        );
    }

    private void setPlot(XYPlot plot){
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);
        
        setRenderer((XYLineAndShapeRenderer) plot.getRenderer());
    }
    
    private void setRenderer(XYLineAndShapeRenderer renderer){
        for(int i = 8 /*this.dataset.getSeriesCount()*/; i>=0;i--){
            renderer.setSeriesStroke(i, new BasicStroke(3.0f));
        }
    }
    
    private void setChartPanel(){
        pnChart.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnChart.setBackground(Color.white);
    }
}
