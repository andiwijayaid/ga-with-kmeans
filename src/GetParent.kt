fun getParent(): IntArray {

    val fitnessData = ArrayList<Double>()
    val parentIndex = IntArray(2)

    for (i in 0 until numberOfPopulation){
        fitnessData.add(0.toDouble())
    }

//    println("b: $population")

    for (i in 0 until numberOfPopulation) {
        val mData = population[i] as ArrayList<Any>
        fitnessData[i] = mData[4] as Double
    }

    for (i in 0 until 2) {

        val minValue = fitnessData.min()!!
        val minIndex = fitnessData.indexOf(minValue)
        parentIndex[i] = minIndex
        fitnessData[minIndex] = 9999.0

    }

    return parentIndex
}