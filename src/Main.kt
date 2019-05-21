var numberOfPopulation = 0

// (pregnancies, glucose, age, blood_presure)
// centroid awal untuk setiap kelas
// array 0: kelas prediabetes
// array 1: kelas type 1
// array 2: kelas type 2
val classParameter = arrayOf(
    arrayOf(1, 125, 20, 120),
    arrayOf(4, 130, 30, 130),
    arrayOf(6, 135, 40, 140)
)

lateinit var population: HashMap<Int, ArrayList<Any>>

fun createRandomNumber(lowerLimit: Int, upperLimit: Int): Int {
    return (lowerLimit..upperLimit).random()
}

fun main() {
    // Read from CSV
    // Hitung fitness untuk semua individu awal
    // Nilai fitness menggunakan euclidean distance berdasarkan konstanta parameter awal berdasarkan kelasnya
    // Nilai fitness ditampung dalam array, dimana
    // Nilai fitness terdiri dari fitness untuk kelas prediabetes, type 1, type 2
    population = createPopulation() // Read from CSV
    numberOfPopulation = population.size
    val mutationRate = 0.01

    // Tahapan seleksi:
    // Iterasi 0 untuk kelas prediabetes
    // Iterasi 1 untuk kelas type1
    // Iterasi 2 untuk kelas type2
    // Untuk mencari individu terbaik, perulangan dibatasi hingga 1000 epoch
    // Seleksi 2 individu untuk menjadi parent
    // 2 individu yang terpilih merupakan individu dengan nilai fitness terkecil
    // selanjutnya adalah crossover
    // crossover yang digunakan adalah one point crossover
    // nilai yang ditukar adalah nilai age, blood_presure
    // dihasilkan 2 individu baru (child1, child2)
    // masing-masing child akan masuk pada proses mutasi
    // untuk nilai mutasi, digunakan nilai batas atas dan batas bawah dari populasi awal untuk masing-masing parameter
    // untuk menentukan alel yang mengalami proses mutasi,
    // dibuat sebuah random number dari 0 hingga 1
    // dimana mutation_ratenya adalah 0.01

    // --- contoh kasus ---
    // sebuah child masuk kedalam proses mutasi
    // akan jalankan sebuah perulangan sebesar array child
    // dalam perulangan akan dibuat sebuah pengecekan status
    // apakah random 0 hingga 1 lebih kecil sama dengan 0.01
    // misalnya
    // perulangan pertama randomNumber = 0.05, maka tidak terjadi mutasi untuk parameter pregnancies
    // perulangan kedua randomNumber = 0.001 maka terjadi mutasi untuk parameter glukosa
    //      nilai mutasi terbentuk dari random number dari range batas atas dan batas bawah parameter glukosa
    //      yang dalam hal ini adalah 0 -199
    // perulanga ketiga randomNumber = 0.006 maka tidak terjadi mutasi untuk parameter age
    // perulangan keempat randomNumber = 0.1 maka tidak terjadi mutasi untuk parameter blood_presure
    // --- end of Contoh Kasus ---

    // setelah dilakukan mutasi, child1 dan child2 lalu akan kembali dihitung fitnessnya
    // perhitungan fitness tetap menggunakan euclidean distance berdasarkan klasifikasi kelasnya masing-masing

    // selanjutnya akan dilakukan proses regenerasi
    // proses ini akan mengambil nilai fitness terbesar dari populasi
    // yang berarti nilainya jauh dari centroid yang diharapkan
    // input child yang telah dibuat digenerate sebelumnya
    // proses ini dilakukan 2 kali untuk 2 child yang berbeda

    for (i in 0 until 3) {

        for (j in 0 until 1000) {
            val parentIndex = getParent(i)
            val parent1 = population[parentIndex[0]]
            val parent2 = population[parentIndex[1]]

            val crossOver = crossOver(parent1?.get(0) as ArrayList<Int>, parent2?.get(0) as ArrayList<Int>)

            val child1 = crossOver[0]
            val mutatedChild1 = mutation(child1, mutationRate)
            val child1Fitness = calculateFitness(mutatedChild1, i)

            val child2 = crossOver[1]
            val mutatedChild2 = mutation(child2, mutationRate)
            val child2Fitness = calculateFitness(mutatedChild2, i)

            regeneration(mutatedChild1, child1Fitness, mutatedChild2, child2Fitness, i)
        }
        val bestSolution = getBestSolution()
        println("Best Solution for $i: $bestSolution")
    }
}

