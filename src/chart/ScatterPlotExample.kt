package chart

import kmeans.age
import kmeans.centroid
import kmeans.glucose
import java.awt.Color

import javax.swing.JFrame

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.plot.PlotOrientation
import org.jfree.chart.plot.XYPlot
import org.jfree.data.xy.XYDataset
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import utils.readDiabetes

/**
 * @author imssbora
 */
class ScatterPlotExample(title: String) : JFrame(title) {

    init {

        // Create dataset
        val dataset = createDataset()

        // Create chart
        val chart = ChartFactory.createScatterPlot(
            "Pima Diabetes Clustering",
            "Glucose", "Age", dataset, PlotOrientation.VERTICAL, true, true, false
        )

        //Changes background color
        val plot = chart.plot as XYPlot
        plot.backgroundPaint = Color(255, 228, 196)


        // Create Panel
        val panel = ChartPanel(chart)
        contentPane = panel
    }

    private fun createDataset(): XYDataset {
        val dataset = XYSeriesCollection()

        //Prediabetes (Age,weight) series
        val series1 = XYSeries("Prediabetes")
        series1.add(centroid[0][1], centroid[0][2])

        dataset.addSeries(series1)

        //Type 1 (Age,weight) series
        val series2 = XYSeries("Type 1")
        series2.add(centroid[1][1], centroid[1][2])

        dataset.addSeries(series2)

        //Type 2 (Age,weight) series
        val series3 = XYSeries("Type 2")
        series3.add(centroid[2][1], centroid[2][2])

        dataset.addSeries(series3)

        // diabetes dataset
        val data = XYSeries("Data")
        val myData =  readDiabetes()
        for (i in 0 until myData!!.size) {
            data.add(myData.get(i).glucose, myData.get(i).age)
        }
        dataset.addSeries(data)

        // new data
        val newData = XYSeries("New Data")
        newData.add(glucose, age)
        dataset.addSeries(newData)

        return dataset
    }
}