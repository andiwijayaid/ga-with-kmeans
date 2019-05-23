package k

fun findCluster(distances: ArrayList<Double>): Int {
    val minValue = distances.min()
    val cluster = distances.indexOf(minValue)

    return cluster
}