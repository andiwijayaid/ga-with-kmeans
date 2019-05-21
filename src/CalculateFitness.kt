import kotlin.math.sqrt

fun calculateFitness(gen: ArrayList<Int>): ArrayList<Float> {

    val prediabetesClass = sqrt(
        Math.pow((gen[0] - classParameter[0][0]).toDouble(), 2.0) +
                Math.pow((gen[1] - classParameter[0][1]).toDouble(), 2.0) +
                Math.pow((gen[2] - classParameter[0][2]).toDouble(), 2.0) +
                Math.pow((gen[3] - classParameter[0][3]).toDouble(), 2.0)
    )

    val typeOneClass = sqrt(
        Math.pow((gen[0] - classParameter[1][0]).toDouble(), 2.0) +
                Math.pow((gen[1] - classParameter[1][1]).toDouble(), 2.0) +
                Math.pow((gen[2] - classParameter[1][2]).toDouble(), 2.0) +
                Math.pow((gen[3] - classParameter[1][3]).toDouble(), 2.0)
    )

    val typeTwoClass = sqrt(
        Math.pow((gen[0] - classParameter[2][0]).toDouble(), 2.0) +
                Math.pow((gen[1] - classParameter[2][1]).toDouble(), 2.0) +
                Math.pow((gen[2] - classParameter[2][2]).toDouble(), 2.0) +
                Math.pow((gen[3] - classParameter[2][3]).toDouble(), 2.0)
    )

    return arrayListOf(prediabetesClass.toFloat(), typeOneClass.toFloat(), typeTwoClass.toFloat())
}


fun calculateFitness(gen: ArrayList<Int>, classParameterIndex: Int): ArrayList<Float> {

    val prediabetesClass = sqrt(
        Math.pow((gen[0] - classParameter[0][0]).toDouble(), 2.0) +
                Math.pow((gen[1] - classParameter[0][1]).toDouble(), 2.0) +
                Math.pow((gen[2] - classParameter[0][2]).toDouble(), 2.0) +
                Math.pow((gen[3] - classParameter[0][3]).toDouble(), 2.0)
    )

    val typeOneClass = sqrt(
        Math.pow((gen[0] - classParameter[1][0]).toDouble(), 2.0) +
                Math.pow((gen[1] - classParameter[1][1]).toDouble(), 2.0) +
                Math.pow((gen[2] - classParameter[1][2]).toDouble(), 2.0) +
                Math.pow((gen[3] - classParameter[1][3]).toDouble(), 2.0)
    )

    val typeTwoClass = sqrt(
        Math.pow((gen[0] - classParameter[2][0]).toDouble(), 2.0) +
                Math.pow((gen[1] - classParameter[2][1]).toDouble(), 2.0) +
                Math.pow((gen[2] - classParameter[2][2]).toDouble(), 2.0) +
                Math.pow((gen[3] - classParameter[2][3]).toDouble(), 2.0)
    )

    return arrayListOf(prediabetesClass.toFloat(), typeOneClass.toFloat(), typeTwoClass.toFloat())
}