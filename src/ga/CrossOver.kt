package ga
fun crossOver(parent1: ArrayList<Any>, parent2: ArrayList<Any>): Array<Any> {

    val newChild1 = arrayListOf(parent1[0], parent1[1], parent2[2], parent2[3], parent1[4])
    val newChild2 = arrayListOf(parent2[0], parent2[1], parent1[2], parent1[3], parent2[4])

    return arrayOf(newChild1, newChild2)
}
