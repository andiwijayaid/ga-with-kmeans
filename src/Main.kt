const val target = "Kyushu"
const val targetLength = target.length
var numberOfPopulation = 0

val classParameter = arrayOf(
    arrayOf(1, 125, 20, 120),
    arrayOf(4, 130, 30, 130),
    arrayOf(6, 135, 40, 140)
)

lateinit var population: HashMap<Int, ArrayList<Any>>

fun createRandomNumber(lowerLimit: Int, upperLimit: Int): Int {
    return (lowerLimit..upperLimit).random()
}

val solution = ArrayList<ArrayList<Any>?>()
val solutionIndex = ArrayList<ArrayList<Any>?>()

fun main() {
    population = createPopulation()
    numberOfPopulation = population.size
    val mutationRate = 0.01

    for (i in 0 until 3) {

        for (j in 0 until 1000) {
            val parentIndex = getParent(i)
            val parent1 = population[parentIndex[0]]
            val parent2 = population[parentIndex[1]]
//            println("$parent1, $parent2")

            val crossOver = crossOver(parent1?.get(0) as ArrayList<Int>, parent2?.get(0) as ArrayList<Int>)
//            println("${crossOver[0]}, ${crossOver[1]}")

            val child1 = crossOver[0]
            val mutatedChild1 = mutation(child1, mutationRate)
            val child1Fitness = calculateFitness(mutatedChild1, i)
//            println("$child1, $mutatedChild1, $child1Fitness")

            val child2 = crossOver[1]
            val mutatedChild2 = mutation(child2, mutationRate)
            val child2Fitness = calculateFitness(mutatedChild2, i)
//            println("$child2, $mutatedChild2, $child2Fitness")

            regeneration(mutatedChild1, child1Fitness, mutatedChild2, child2Fitness, i)
        }
        val bestSolution = getBestSolution()
        println("Best Solution for $i: $bestSolution")
//        solution.add(bestSolution)
//        solutionIndex.add(arrayListOf(i))
    }
}

