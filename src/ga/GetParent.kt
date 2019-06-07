package ga

fun getParent(): IntArray {

    val fitnessData = ArrayList<Double>()
    val parentIndex = IntArray(2)

    for (i in 0 until numberOfPopulation){
        fitnessData.add(0.toDouble())
    }

    for (i in 0 until numberOfPopulation) {
        val mData = population[i] as ArrayList<Any>
        fitnessData[i] = mData[4] as Double
    }

    // parent diambil dari fitness terbaik
    // dimana individu dengan fitness terbaik adalah yang memiliki
    // nilai terkecil dari nilai fitness individu lain
    for (i in 0 until 2) {
        val minValue = fitnessData.min()!!
        val minIndex = fitnessData.indexOf(minValue)
        parentIndex[i] = minIndex
        // nilai 9999 diberikan untuk mengubah nilai terkecil agar tidak kembali masuk pada perulangan selanjutnya
        fitnessData[minIndex] = 9999.0
    }

    return parentIndex
}