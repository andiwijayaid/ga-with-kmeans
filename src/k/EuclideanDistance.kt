package k

import kotlin.math.sqrt

fun euclideanDistance(data: ArrayList<Double>): ArrayList<Double> {
    val distances = ArrayList<Double>()
    for (i in 0 until 3) {
        val distance = sqrt(
            Math.pow((centroids[i][0] - data[0]), 2.0) +
                    Math.pow((centroids[i][1] - data[1]), 2.0) +
                    Math.pow((centroids[i][2] - data[2]), 2.0) +
                    Math.pow((centroids[i][3] - data[3]), 2.0)
        )
        distances.add(distance)
    }
    return distances
}