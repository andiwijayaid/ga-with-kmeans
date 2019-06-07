package ga
fun mutation(child: ArrayList<Any>, mutationRate: Double, typeClassIndex: Int): ArrayList<Any> {

    // nilai batas atas dan batas bawah untuk masing-masing
    // parameter pregnancies, glucose, age, blood_presure secara berurutan
    // nilai ini digunakna untuk membuat rentang nilai random untuk masing-masing parameter
    val mutationValues = arrayOf(
        arrayOf(0, 17),
        arrayOf(0, 199),
        arrayOf(21, 81),
        arrayOf(0, 122)
    )

    for (i in 0 until child.size - 1) {
        if (createRandomNumber(0, 1) <= mutationRate) {
            child[i] = createRandomNumber(mutationValues[i][0], mutationValues[i][1])
        }
    }

    val gen = arrayListOf(child[0] as Int, child[1] as Int, child[2] as Int, child[3] as Int)

    val mutatedFitness = calculateFitness(gen, typeClassIndex)

    child[4] = mutatedFitness

    return child
}