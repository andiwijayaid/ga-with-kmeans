package ga

import utils.readDiabetes

fun createPopulation(typeClassIndex: Int): ArrayList<Any> {

    val diabetesData = readDiabetes()

    val population = ArrayList<Any>()

    for (i in 0 until diabetesData!!.size) {
        val gen = arrayListOf(
            diabetesData[i].pregnancies,
            diabetesData[i].glucose,
            diabetesData[i].age,
            diabetesData[i].blood_pressure
        )
        val fitness = calculateFitness(gen, typeClassIndex)
        population.add(arrayListOf(gen[0], gen[1], gen[2], gen[3], fitness))
    }
    return population
}