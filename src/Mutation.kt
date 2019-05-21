import java.lang.StringBuilder

fun mutation(child: ArrayList<Int>, mutationRate: Double): ArrayList<Int> {

    val mutationValues = arrayOf(
        arrayOf(0, 17),
        arrayOf(0, 199),
        arrayOf(21, 81),
        arrayOf(0, 122)
    )

    for (i in 0 until child.size) {
        if (createRandomNumber(0, 1) <= mutationRate) {
            child[i] = createRandomNumber(mutationValues[i][0], mutationValues[i][1])
        }
    }

    return child
}