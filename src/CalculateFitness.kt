import kotlin.math.sqrt

fun calculateFitness(gen: ArrayList<Int>, classParameterIndex: Int): Double {

    val fitness = sqrt(
        Math.pow((gen[0] - classParameter[classParameterIndex][0]).toDouble(), 2.0) +
                Math.pow((gen[1] - classParameter[classParameterIndex][1]).toDouble(), 2.0) +
                Math.pow((gen[2] - classParameter[classParameterIndex][2]).toDouble(), 2.0) +
                Math.pow((gen[3] - classParameter[classParameterIndex][3]).toDouble(), 2.0)
    )

    return fitness
}