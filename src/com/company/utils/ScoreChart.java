package com.company.utils;

import com.company.data.ScoreData;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * Created by agnie on 6/16/2016.
 */
public class ScoreChart extends JFrame {

    ScoreData scoreData;

    public ScoreChart(ScoreData scoreData) {
        super("Graph Colouring Problem");
        this.scoreData = scoreData;
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries bestScores = new XYSeries("Best scores");
        XYSeries averageScores = new XYSeries("Average scores");
        XYSeries worstScores = new XYSeries("Worst scores");
        for (int i = 0; i < scoreData.getBestScores().size(); i++) {
            bestScores.add(i, scoreData.getBestScores().get(i));
            averageScores.add(i, scoreData.getAverageScores().get(i));
            worstScores.add(i, scoreData.getWorstScores().get(i));
        }
        dataset.addSeries(bestScores);
        dataset.addSeries(averageScores);
        dataset.addSeries(worstScores);
        return dataset;
    }

    private JPanel createChartPanel() {
        String chartTitle = "Number of errors in solutions developed by genetic algorithms";
        String xAxisLabel = "Generation";
        String yAxisLabel = "Error count";
        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset);
        return new ChartPanel(chart);
    }


}
