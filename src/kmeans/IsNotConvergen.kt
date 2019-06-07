package kmeans

fun isNotConvergen(): Boolean {

    // suatu data dikatakan convergen ketika
    // untuk setiap isi previousDataCluster sama dengan currentDataCluster
    if (previousDataCluster == currentDataCluster) {
        return true
    }
    return false
}