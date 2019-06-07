package ga

fun regeneration() {
    val fitnessData = ArrayList<Double>()

    for (i in 0 until numberOfPopulation + 2)
        fitnessData.add(0.toDouble())

    for (i in 0 until numberOfPopulation + 2) {
        val mData = population[i] as ArrayList<Any>
        fitnessData[i] = mData[4] as Double
    }

    // Menghapus 2 individu dengan nilai fitness terbesar
    // dimana dalam kasus ini, nilai terbesar merupakan individu dengan fitness terburuk
    for (i in 0 until 2) {

        val maxValue = fitnessData.max()
        val maxIndex = fitnessData.indexOf(maxValue)

        fitnessData.removeAt(maxIndex)
        population.removeAt(maxIndex)
    }
}