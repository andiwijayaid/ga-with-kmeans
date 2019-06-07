package utils

import model.Diabetes
import java.io.FileWriter
import java.io.IOException
import java.util.Arrays

private val CSV_HEADER = "id,pregnancies,glucose,age,blood_pressure,class"

fun writeResult(
    diabeteses: ArrayList<ArrayList<Double>>,
    newClusterData: ArrayList<Int>
) {

    var fileWriter: FileWriter? = null

    try {
        fileWriter = FileWriter("C:\\Users\\Andi\\Documents\\DiabetesData\\result.csv")

        fileWriter.append(CSV_HEADER)
        fileWriter.append('\n')

        for (i in 0 until newClusterData.size) {
            fileWriter.append((i+1).toString())
            fileWriter.append(',')
            fileWriter.append((diabeteses[i][0]).toString())
            fileWriter.append(',')
            fileWriter.append((diabeteses[i][1]).toString())
            fileWriter.append(',')
            fileWriter.append((diabeteses[i][2]).toString())
            fileWriter.append(',')
            fileWriter.append((diabeteses[i][3]).toString())
            fileWriter.append(',')
            fileWriter.append((newClusterData[i]).toString())
            fileWriter.append('\n')
        }

        println("Write CSV successfully!")
    } catch (e: Exception) {
        println("Writing CSV error!")
        e.printStackTrace()
    } finally {
        try {
            fileWriter!!.flush()
            fileWriter.close()
        } catch (e: IOException) {
            println("Flushing/closing error!")
            e.printStackTrace()
        }
    }
}