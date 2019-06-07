package ga
fun crossOver(parent1: ArrayList<Any>, parent2: ArrayList<Any>): Array<Any> {

    // crossover one point pada index 2
    // isi index 2 dan 3 saling ditukarkan antar 2 parent
    // index 4 bukan gen, melainkan menampung nilai fitness dari parent
    val newChild1 = arrayListOf(parent1[0], parent1[1], parent2[2], parent2[3], parent1[4])
    val newChild2 = arrayListOf(parent2[0], parent2[1], parent1[2], parent1[3], parent2[4])

    return arrayOf(newChild1, newChild2)
}
