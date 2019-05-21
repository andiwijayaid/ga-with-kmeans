import utils.readFromFile

fun createPopulation(): HashMap<Int, ArrayList<Any>> {

    val diabetesData = readFromFile()

    val population = HashMap<Int, ArrayList<Any>>()

    for (i in 0 until diabetesData!!.size) {
        val gen = arrayListOf(
            diabetesData[i].pregnancies,
            diabetesData[i].glucose,
            diabetesData[i].age,
            diabetesData[i].blood_pressure
        )
        val fitness = calculateFitness(gen)
        population.put(i, arrayListOf(gen, fitness[0], fitness[1], fitness[2]))
    }
    return population
}