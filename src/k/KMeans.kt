package k

import utils.readCentroid
import utils.readDiabetes
import java.util.Scanner
import kotlin.collections.ArrayList

var oldClusterData = ArrayList<Int>()
var newClusterData = ArrayList<Int>()

val centroids = ArrayList<ArrayList<Double>>()
var diabeteses = ArrayList<ArrayList<Double>>()

fun kMeans() {

    // read CSV
    // dilakukan pembacaan data centroid yang telah dihasilkan dari algoritma Genetika
    // data tersebut akan digunakan sebagai intial centroid untuk masing-masing cluster
    // intial centroid ini disimpan dalam sebuah array centroidData
    // data ini lalu kembali dimasukkan dalam sebuah array centroids
    // array centroids sebesar panjang dari diabetesData yaitu 3 indeks
    // 3 indeks ini merupakan pembagian dari 3 kelas yang berbeda yaitu:
    // prediabetes, type1, type2
    // masing-masing array mengandung centroid awal dengan parameter:
    // indeks 0 merupakan data pregnancies
    // indeks 1 merupakan data glucose
    // indeks 2 merupakan data age
    // indeks 3 merupakan data blood_presure

    // Selanjutnya dilakukan pembacaan data set diabetes
    // data tersebut disimpan dalam array diabeteses, dimana:
    // indeks 0 merupakan data pregnancies
    // indeks 1 merupakan data glucose
    // indeks 2 merupakan data age
    // indeks 3 merupakan data blood_presure

    // selanjutnya dilakukan proses perulangan selama data cluster belum konvergen
    // masing-masing data individu diabetes dihitung jaraknya menggunakan euclidean distance
    // perhitungan jarak dilakukan sebanyak 3 kali untuk masing-masing kelas
    // setelah itu, dilakukan pengecekan data jarak antar kelas pada suatu individu
    // nilai jarak terkecil dari 3 kelas yang berbeda menentukan cluster individu tersebut
    // perulangan ini berulang hingga besarnya data diabetes yaitu 768

    // dari data kluster masing-masing individu
    // kita dapat menghitung ulang centroid
    // nilai centroid baru berasal dari
    // penjumlahan masing-masing parameter yang dibagi dengan besarnya data pada kluster tertentu

    // misalnya
    // ada 10 data
    // dimana 2 data kluster 1, 5 data kluster 2, 3 data kluster 3
    // parameter pregnancies, glucose, age, blood_presure akan dijumlahkan berdasarkan klusternya
    // lalu dicari meansnya dengan membagi nya dengan panjang data masing-masing kluster
    // contoh: pregnancies pada kluster 1 akan dijumlah dan dibagi dengan 2
    // setelah itu, didapatkan centroid baru
    // data centroid dari masing-masing kluster ini lalu akan diupdate ke variabel array centroids

    // update centroid akan dilakukan selama belum konvergen, dimana
    // konvergen ditentukan ketika isi dari oldClusterData sama dengan newClusterData

    val centroidData = readCentroid()
    println(centroidData)

    for (i in 0 until centroidData!!.size) {
        val centroid = arrayListOf(
            centroidData[i].pregnancies,
            centroidData[i].glucose,
            centroidData[i].age,
            centroidData[i].blood_pressure
        )
        centroids.add(
            arrayListOf(
                centroid[0].toDouble(),
                centroid[1].toDouble(),
                centroid[2].toDouble(),
                centroid[3].toDouble()
            )
        )
    }

    println("c: $centroids")

    val diabetesData = readDiabetes()
    for (i in 0 until diabetesData!!.size) {
        val diabetes = arrayListOf(
            diabetesData[i].pregnancies,
            diabetesData[i].glucose,
            diabetesData[i].age,
            diabetesData[i].blood_pressure
        )
        diabeteses.add(
            arrayListOf(
                diabetes[0].toDouble(),
                diabetes[1].toDouble(),
                diabetes[2].toDouble(),
                diabetes[3].toDouble()
            )
        )
    }

    var counter = 0

    do {
        val clusterData = ArrayList<Int>()

        println()
        oldClusterData = newClusterData
        println("OCD: $oldClusterData")

        for (j in 0 until diabeteses.size) {
            val distances = euclideanDistance(diabeteses[j])
            println("Dis: $distances")
            clusterData.add(findCluster(distances))
        }
        newClusterData = clusterData
        println(" CD: $newClusterData")
        renewCentroid(clusterData)
        println(isNotConvergen())
        println("epoch: ${counter++}")
    } while (!isNotConvergen())

    println()

    val reader = Scanner(System.`in`)
    print("Pregnancies: ")
    val pregnancies = reader.nextDouble()
    print("Glucose: ")
    val glucose = reader.nextDouble()
    print("Age: ")
    val age = reader.nextDouble()
    print("Blood Presure: ")
    val blood_presure = reader.nextDouble()

    val data = arrayListOf(pregnancies, glucose, age, blood_presure)
    val mDistances = euclideanDistance(data)
    println(mDistances)
    val mCluster = findCluster(mDistances)
    println("This data belongs to cluster ${mCluster+1}")
}