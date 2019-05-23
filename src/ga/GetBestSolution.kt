package ga

fun getBestSolution(): ArrayList<Any> {
    val fitnessData = ArrayList<Double>()

    for (i in 0 until numberOfPopulation)
        fitnessData.add(0.toDouble())

    for (i in 0 until numberOfPopulation) {
        val mData = population[i] as ArrayList<Any>
        fitnessData[i] = mData[4] as Double
    }

    val maxValue = fitnessData.min()
    val maxIndex = fitnessData.indexOf(maxValue)

    return population[maxIndex] as ArrayList<Any>
}