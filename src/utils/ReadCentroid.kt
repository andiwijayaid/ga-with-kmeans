package utils
import model.Diabetes
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList

private const val DIABETES_ID = 0
private const val DIABAETES_PREGNANCIES = 1
private const val DIABETES_GLUCOSE = 2
private const val DIABETES_AGE = 3
private const val DIABETES_BLOOD_PRESSURE = 4

fun readCentroid(): ArrayList<Diabetes>? {
    var fileReader: BufferedReader? = null

    try {
        val centroids = ArrayList<Diabetes>()
        var line: String?

        fileReader = BufferedReader(FileReader("C:\\Users\\Andi\\Documents\\DiabetesData\\initial_centroid.csv"))

        // Read CSV header
        fileReader.readLine()

        // Read the file line by line starting from the second line
        line = fileReader.readLine()
        while (line != null) {
            val tokens = line.split(",")
            if (tokens.isNotEmpty()) {
                val customer = Diabetes(
                    Integer.parseInt(tokens[DIABETES_ID]),
                    Integer.parseInt(tokens[DIABAETES_PREGNANCIES]),
                    Integer.parseInt(tokens[DIABETES_GLUCOSE]),
                    Integer.parseInt(tokens[DIABETES_AGE]),
                    Integer.parseInt(tokens[DIABETES_BLOOD_PRESSURE]))
                centroids.add(customer)
            }

            line = fileReader.readLine()
        }

        // Print the new customer list
//        for (centroid in centroids) {
//            println(centroid)
//        }
        return centroids
    } catch (e: Exception) {
        println("Reading CSV Error!")
        e.printStackTrace()
    } finally {
        try {
            fileReader!!.close()
        } catch (e: IOException) {
            println("Closing fileReader Error!")
            e.printStackTrace()
        }
    }
    return null
}