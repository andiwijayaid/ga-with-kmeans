package kmeans

fun findCluster(distances: ArrayList<Double>): Int {

    // nilai distance didapatkan dari euclidean distance
    // nilai terkecil dari suatu index menandakan individu tersebut masuk pada cluster 0/1/2
    val minValue = distances.min()
    val cluster = distances.indexOf(minValue)

    return cluster
}