package ga

fun regeneration() {
    val fitnessData = ArrayList<Double>()

    for (i in 0 until numberOfPopulation + 2)
        fitnessData.add(0.toDouble())

//    println("c : $ga.getPopulation")

    for (i in 0 until numberOfPopulation + 2) {
        val mData = population[i] as ArrayList<Any>
        fitnessData[i] = mData[4] as Double
    }

    for (i in 0 until 2) {

        val maxValue = fitnessData.max()
        val maxIndex = fitnessData.indexOf(maxValue)

        fitnessData.removeAt(maxIndex)
        population.removeAt(maxIndex)
    }
}