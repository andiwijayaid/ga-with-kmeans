import utils.writeCentroid

var numberOfPopulation = 0

val classParameter = arrayOf(
    arrayOf(1, 125, 20, 120),
    arrayOf(4, 130, 30, 130),
    arrayOf(6, 135, 40, 140)
)

lateinit var population: ArrayList<Any>
var bestByItsClass = arrayListOf<Any>()

fun main() {
    var bestSolution = arrayListOf<Any>()


    // Read from CSV
    // Parameter tersimpan dalam file dengan ekstensi csv
    // Proses ini dilakukan sebanyak 3 kali untuk masing-masing kelas, dimana:
    // Iterasi 0 untuk kelas prediabetes
    // Iterasi 1 untuk kelas type1
    // Iterasi 2 untuk kelas type2

    // Setelah dilakukan pembacaan data,
    // Akan dihitung fitness untuk semua individu awal
    // Nilai fitness menggunakan euclidean distance berdasarkan konstanta parameter awal berdasarkan kelasnya
    // Nilai fitness ditampung dalam array, dimana
    // Nilai fitness terdiri dari fitness untuk kelas prediabetes, type 1, type 2
    // Nilai pregnancies, glucose, age, blood_presure, dan fitnessnya disimpan dalam sebuah array
    // contoh, pregnancies: 9, glucose: 125, age: 35, blood_presure: 120, dan fitnessnya: 10 (untuk kelas 1)
    // maka Diabetes = [9, 125, 35, 120, 10]

    // Tahapan seleksi:
    // Untuk mencari individu terbaik, perulangan dibatasi hingga nilai fitness untuk masing2 kelas > 18
    // Selanjutnya dilakukan seleksi 2 individu untuk menjadi parent
    // 2 individu yang terpilih merupakan individu dengan nilai fitness terkecil
    // selanjutnya adalah crossover
    // crossover yang digunakan adalah one point crossover
    // nilai yang ditukar adalah nilai age dan blood_presure untuk masing2 parent
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
    // setelah dilakukan mutasi, child1 dan child2 lalu akan kembali dihitung fitnessnya
    // perhitungan fitness tetap menggunakan euclidean distance berdasarkan klasifikasi kelasnya masing-masing
    // --- end of Contoh Kasus ---

    // Hasil dari 2 child yang mengalami mutasi lalu ditambahkan kedalam populasi
    // dengan begitu, besarnya populasi saat ini adalah
    // populasi  = 768 + 2 individu baru = 770

    // selanjutnya akan dilakukan proses regenerasi
    // proses ini akan mengambil nilai fitness terbesar dari populasi
    // yang berarti data tersebut relatif lebih jauh dari intial centroidnya
    // individu dengan nilai terbesar tersebut lalu dihapus dari populasi
    // proses diatas dilakukan sebanyak 2 kali
    // sehingga populasi kembali ke ukuran awal sebanyak 768 individu

    // setelah itu dilakukan proses pemilihan individu dengan nilai fitness terbaik
    // nilai tersebut disimpan dalam variabel fitness
    // perulangan diatas akan terus berulang untuk memilih parent baru jika
    // nilai fitness lebih besar dari 18.0
    // jika nilai fitness sudah lebih kecil dari 18.0 maka,
    // individu dengan fitness terbaik tersebut akan ditambahkan kedalam sebuah array
    // array bestByIts class dimana indexnya menandakan kelasnya (3 kelas berbeda)

    // perulangan diatas akan dilakukan sebanyak 3 kali untuk 3 kelas yang berbeda
    // ketika selesai, nilai yang ditampung dalam bestByItsClass akan
    // ditulis/disimpan dalam sebuah file csv
    // CSV ini lalu akan digunakan untuk centroid awal dalam algoritma kmeans
    for (i in 0 until 3) {
        population = createPopulation(i)
        numberOfPopulation = population.size
        val mutationRate = 0.01

        var fitness = 999.0

        while (fitness > 18.0) {
            val parentIndex = getParent()
            val parent1 = population[parentIndex[0]]
            val parent2 = population[parentIndex[1]]

            val crossOver = crossOver(parent1 as ArrayList<Any>, parent2 as ArrayList<Any>)

            val child1 = crossOver[0]
            val mutatedChild1 = mutation(child1 as ArrayList<Any>, mutationRate, i)

            val child2 = crossOver[1]
            val mutatedChild2 = mutation(child2 as ArrayList<Any>, mutationRate, i)

            population.add(mutatedChild1)
            population.add(mutatedChild2)

            regeneration()

            bestSolution = getBestSolution()
            fitness = bestSolution[4] as Double
            println("Best Solution for $i: $bestSolution")
        }
        bestByItsClass.add(bestSolution)
    }
    println(bestByItsClass)

    writeCentroid(
        bestByItsClass[0] as ArrayList<Any>,
        bestByItsClass[1] as ArrayList<Any>,
        bestByItsClass[2] as ArrayList<Any>
    )
}

