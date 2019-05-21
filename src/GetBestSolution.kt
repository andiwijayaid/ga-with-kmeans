fun getBestSolution(): java.util.ArrayList<Any>? {
    val fitnessData = ArrayList<Float>()

    for (i in 0 until numberOfPopulation)
        fitnessData.add(0f)

    for (i in 0 until numberOfPopulation) {
        fitnessData[i] = population[i]?.get(1) as Float
    }

    val maxValue = fitnessData.min()
    val maxIndex = fitnessData.indexOf(maxValue)

    return population[maxIndex]
}