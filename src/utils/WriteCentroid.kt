package utils
import model.Diabetes
import java.io.FileWriter
import java.io.IOException
import java.util.Arrays

private val CSV_HEADER = "id,pregnancies,glucose,age,blood_pressure"

fun writeCentroid(class1: ArrayList<Any>, class2: ArrayList<Any>, class3: ArrayList<Any>) {

    val diabeteses = Arrays.asList(
        Diabetes(1, class1[0] as Int, class1[1] as Int, class1[2] as Int, class1[3] as Int),
        Diabetes(1, class2[0] as Int, class2[1] as Int, class2[2] as Int, class2[3] as Int),
        Diabetes(1, class3[0] as Int, class3[1] as Int, class3[2] as Int, class3[3] as Int))

    var fileWriter: FileWriter? = null

    try {
        fileWriter = FileWriter("C:\\Users\\Andi\\Documents\\DiabetesData\\initial_centroid.csv")

        fileWriter.append(CSV_HEADER)
        fileWriter.append('\n')

        for (diabetes in diabeteses) {
            fileWriter.append(diabetes.id.toString())
            fileWriter.append(',')
            fileWriter.append(diabetes.pregnancies.toString())
            fileWriter.append(',')
            fileWriter.append(diabetes.glucose.toString())
            fileWriter.append(',')
            fileWriter.append(diabetes.age.toString())
            fileWriter.append(',')
            fileWriter.append(diabetes.blood_pressure.toString())
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