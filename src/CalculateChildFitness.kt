import kotlin.math.sqrt

fun calcuateChildFitness(child: ArrayList<Int>, classParameterIndex: Int): Double {

    val fitness = sqrt(
        Math.pow((child[0] - classParameter[classParameterIndex][0]).toDouble(), 2.0) +
                Math.pow((child[1] - classParameter[classParameterIndex][1]).toDouble(), 2.0) +
                Math.pow((child[2] - classParameter[classParameterIndex][2]).toDouble(), 2.0) +
                Math.pow((child[3] - classParameter[classParameterIndex][3]).toDouble(), 2.0)
    )

    return fitness
}
