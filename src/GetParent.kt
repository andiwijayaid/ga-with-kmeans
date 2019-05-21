fun getParent(typeClassIndex: Int): IntArray {

    val fitnessData = ArrayList<Float>()
    val parentIndex = IntArray(2)

    for (i in 0 until numberOfPopulation)
        fitnessData.add(0f)

    for (i in 0 until numberOfPopulation) {
        fitnessData[i] = population[i]?.get(typeClassIndex + 1) as Float
    }

//    println()

    for (i in 0 until 2) {

        val minValue = fitnessData.min()!!
        val minIndex = fitnessData.indexOf(minValue)
        parentIndex[i] = minIndex
        fitnessData[minIndex] = 9999F

    }

    return parentIndex
}