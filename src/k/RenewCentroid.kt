package k

fun renewCentroid(clusterData: ArrayList<Int>) {

    var pregnancies0 = 0.toDouble()
    var glucose0 = 0.toDouble()
    var age0 = 0.toDouble()
    var blood_pressure0 = 0.toDouble()
    var numberOfCluster0 = 0

    var pregnancies1 = 0.toDouble()
    var glucose1 = 0.toDouble()
    var age1 = 0.toDouble()
    var blood_pressure1 = 0.toDouble()
    var numberOfCluster1 = 0

    var pregnancies2 = 0.toDouble()
    var glucose2 = 0.toDouble()
    var age2 = 0.toDouble()
    var blood_pressure2 = 0.toDouble()
    var numberOfCluster2 = 0

    for (i in 0 until clusterData.size) {

        val cluster = clusterData[i]

        if (cluster == 0) {
            pregnancies0 = pregnancies0 + diabeteses[i][0]
            glucose0 = glucose0 + diabeteses[i][1]
            age0 = age0 + diabeteses[i][2]
            blood_pressure0 = blood_pressure0 + diabeteses[i][3]
            numberOfCluster0++
        } else if (cluster == 1) {
            pregnancies1 = pregnancies1 + diabeteses[i][0]
            glucose1 = glucose1 + diabeteses[i][1]
            age1 = age1 + diabeteses[i][2]
            blood_pressure1 = blood_pressure1 + diabeteses[i][3]
            numberOfCluster1++
        } else if (cluster == 2) {
            pregnancies2 = pregnancies2 + diabeteses[i][0]
            glucose2 = glucose2 + diabeteses[i][1]
            age2 = age2 + diabeteses[i][2]
            blood_pressure2 = blood_pressure2 + diabeteses[i][3]
            numberOfCluster2++
        }
    }

    pregnancies0 = pregnancies0 / numberOfCluster0
    glucose0 = glucose0 / numberOfCluster0
    age0 = age0 / numberOfCluster0
    blood_pressure0 = blood_pressure0 / numberOfCluster0

    pregnancies1 = pregnancies1 / numberOfCluster1
    glucose1 = glucose1 / numberOfCluster1
    age1 = age1 / numberOfCluster1
    blood_pressure1 = blood_pressure1 / numberOfCluster1

    pregnancies2 = pregnancies2 / numberOfCluster2
    glucose2 = glucose2 / numberOfCluster2
    age2 = age2 / numberOfCluster2
    blood_pressure2 = blood_pressure2 / numberOfCluster2

    centroids[0] = arrayListOf(pregnancies0, glucose0, age0, blood_pressure0)
    centroids[1] = arrayListOf(pregnancies1, glucose1, age1, blood_pressure1)
    centroids[2] = arrayListOf(pregnancies2, glucose2, age2, blood_pressure2)

    println("${centroids[0]}, ${centroids[1]}, ${centroids[2]}")
}