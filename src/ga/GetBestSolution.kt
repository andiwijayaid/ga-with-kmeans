package ga

fun getBestSolution(): ArrayList<Any> {
    val fitnessData = ArrayList<Double>()

    for (i in 0 until numberOfPopulation)
        fitnessData.add(0.toDouble())

    for (i in 0 until numberOfPopulation) {
        val mData = population[i] as ArrayList<Any>
        fitnessData[i] = mData[4] as Double
    }

    // mencari individu terbaik
    // dimana pada kasus ini fitness terkecil merupakan indivudu terbaik
    val minValue = fitnessData.min()
    val minIndex = fitnessData.indexOf(minValue)

    return population[minIndex] as ArrayList<Any>
}