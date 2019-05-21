fun regeneration(
    mutatedChild1: ArrayList<Int>,
    child1Fitness: ArrayList<Float>,
    mutatedChild2: ArrayList<Int>,
    child2Fitness: ArrayList<Float>,
    typeClassIndex: Int
) {
    val fitnessData = ArrayList<Float>()

    for (i in 0 until numberOfPopulation)
        fitnessData.add(0f)

    for (i in 0 until numberOfPopulation) {
        fitnessData[i] = population[i]?.get(typeClassIndex + 1) as Float
    }

    for (i in 0 until 2) {

        val maxValue = fitnessData.max()
        val maxIndex = fitnessData.indexOf(maxValue)

        population.remove(maxIndex)

        val newGen = ArrayList<Any>()

        if (i == 0) {
            newGen.add(mutatedChild1)
            newGen.add(child1Fitness[0])
            newGen.add(child1Fitness[1])
            newGen.add(child1Fitness[2])
            population.put(maxIndex, newGen)
        } else {
            newGen.add(mutatedChild2)
            newGen.add(child2Fitness[0])
            newGen.add(child2Fitness[1])
            newGen.add(child2Fitness[2])
            population.put(maxIndex, newGen)
        }
    }
}