
fun crossOver(parent1: ArrayList<Int>, parent2: ArrayList<Int>): Array<ArrayList<Int>> {

    val child1 = parent1
    val child2 = parent2

    child1.set(2, parent2[2])
    child1.set(3, parent2[3])

    child2.set(2, parent1[2])
    child2.set(3, parent1[3])

    return arrayOf(child1, child2)
}
