fun calculateSuitValue(gen: String): Int {
    var suitValue = 0
    for (i in 0 until targetLength) {
        if (gen[i] == target[i]) {
            suitValue++
        }
    }
    return suitValue
}