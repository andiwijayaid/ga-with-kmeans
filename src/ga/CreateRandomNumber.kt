package ga

fun createRandomNumber(lowerLimit: Int, upperLimit: Int): Int {
    return (lowerLimit..upperLimit).random()
}