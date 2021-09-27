package com.apps.mypsilat

import java.util.*

object Constants{

    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answer"

    fun getQuestion(): ArrayList<Question>{
        val questionList = arrayListOf<Question>()

        val que1 = Question(1,"Pencak silat adalah salah satu cabang olahraga beladiri asli dari negara ...","Singapura","Indonesia","Thailand","Amerika","Jepang",2)

        questionList.add(que1)

        val que2 = Question(2,"Berikut yang bukan termasuk para ahli yang berpendapat mengenai pengertian Pencak silat ...","Agung Nugroho M","Muhajir","Abdul Syukur","Soetardjonegoro","Rahmat Setyo",5)

        questionList.add(que2)

        val que3 = Question(3,
            "Induk pencak silat di Indonesia adalah ...",
            "IBSI",
            "IPSI",
            "FIFA",
            "PBVSI",
            "PSSI",
            2)

        questionList.add(que3)

        val que4 = Question(4,"Pada tahun berapa Persatuan Silat Antarbangsa (Persilat) didirikan..",
            "1980",
            "1981",
            "1985",
            "1990",
            "1991",
            1)

        questionList.add(que4)

        val que5 = Question(5,"Bagaimana pengertian Pencak Silat menurut  Abdul Syukur ...",
            "Pencak silat adalah gerakan langkah keindahan dengan menhindar, yang disertakan gerakan berunsur komedi ",
            "Pencak silat adalah beladiri asli Indonesia yang telah berumur berabad – abad",
            "Pencak silat adalah suatu model beladiri yang diciptakan untuk mempertahankan diri dari bahaya yang dapat mengancam keselamatan dan kelangsungan hidup",
            "Pencak silat adalah suatu olahraga beladiri warisan nenek moyang",
            "Pencak silat yaitu bela-serang yang diatur menurut sistem, waktu dan tempat",
            1)

        questionList.add(que5)

        val que6 = Question(6,"Gelanggang pencak silat berbentuk ...",
            "Lingkaran","Trapesium","Persegi panjang","Segi empat bujur sangkar ",
            "Segi lima bujur sangkar",
            4)

        questionList.add(que6)

        val que7 = Question(7,"Berapakah ukuran  gelanggang pencak silat ...","10m x 10m ","15m x 15m ","20m x 20m ","18m x 18m ","10m x 20m ",1)

        questionList.add(que7)

        val que8 = Question(8,"Berapakah ukuran lingkaran luar dan lingkaran dalam pada gelanggang pencak silat ...",
            "8 m dan 4 m",
            "8 m dan 5 m",
            "8 m dan 6 m",
            "8 m dan 10 m",
            "8 m dan 3 m",5)

        questionList.add(que8)

        val que9 = Question(9,"Pelindung badan yang digunakan oleh pesilat pada waktu pertandingan yaitu ... ",
            "Body language","Body protector","Body proyektor","Body countac","Body defense",2)

        questionList.add(que9)

        val que10 = Question(10,
            "Berikut yang termasuk negara pendiri Persatuan Silat Antarbangsa (Persilat) ...",
            "Brunei Darussalam ",
            "Belanda","China",
            "Timor Leste","Thailand",1)

        questionList.add(que10)

        val que11 = Question(11,
            "Berikut yang bukan termasuk perlengkapan dalam gelanggang pencak silat...",
            "Meja dan kursi wasit",
            "Lampu babak",
            "Gong dan bel",
            "Formulir pertandingan",
            "Pelindung badan",5)

        questionList.add(que11)

        val que12 = Question(12,"Posisi kaki yang digunakan sebagai dasar tumpuan untuk  melakukan sikap pasang, teknik – teknik serangan dan teknik pembelaan dalam pencak silat disebut ...",
            "Pukulan",
            "Hindaran",
            "Elakan",
            "Kuda – kuda",
            "Tendangan",4)

        questionList.add(que12)

        val que13 = Question(13,
            "Pergerakan kaki yang digunakan untuk mengatur posisi dengan mengubah posisi tubuh disebut ... ",
            "Langkah kaki","Sikap kaki","Pola langkah ",
            "Pergerakan","Sikap pasang",3)

        questionList.add(que13)

        val que14 = Question(14,
            "Berikut yang bukan termasuk jenis pola langkah dalam pencak silat yaitu ..."
            ,"Pola langkah zig – zag","Pola langkah lurus","Pola langkah serong","Pola langkah U","Pola langkah segitiga",3)

        questionList.add(que14)

        val que15 = Question(15,
            "Posisi kedua tangan saat melakukan gerakkan kuda – kuda depan yaitu berada di ...",
            "Mengepal di samping pinggang ",
            "Mengepal di samping dada",
            "Terbuka di depan dada",
            "Terbuka di samping pinggang",
            "Tegak lurus di samping pinggang",1)

        questionList.add(que15)

        val que16 = Question(16,"Berikut yang bukan termasuk tahapan dalam kuda – kuda belakang ...",
            "Kaki kiri di belakang kaki kanan atau sebaliknya ",
            "Keduanya berada dalam satu garis ",
            "Kedua kaki ditekuk ",
            "Posisi kedua tangan mengepal disamping pinggang",
            "Dapat dilakukan lurus ataupun serong",3)

        questionList.add(que16)

        val que17 = Question(17,
            "Apa saja unsur – unsur dalam pencak silat?",
            "Olahraga, seni budaya, beladiri dan juara",
            "Olahraga, seni budaya, persatuan dan juara",
            "Olahraga, kesenian, pendidikan dan seni budaya",
            "Olahraga, kesenian, beladiri, pendidikan mental kerohanian, dan persaudaraan menuju persatuan ",
            "Olahraga, seni budaya, persatuan dan sehat",4)

        questionList.add(que17)

        val que18 = Question(18,
            "Posisi awal saat melakukan gerakan pola langkah U yaitu ... ",
            "Kuda – kuda tengah ",
            "Kuda – kuda samping kanan",
            "Kuda – kuda depan",
            "Kuda – kuda belakang",
            "Kuda – kuda samping kiri",1)

        questionList.add(que18)

        val que19 = Question(19,"Dalam pencak silat sasaran saat melakukan pukulan depan yaitu ... ",
            "Pinggang",
            "Dada",
            "Punggung",
            "Perut",
            "Leher",
            2)

        questionList.add(que19)

        val que20 = Question(20,
            "Tendangan yang menggunakan ujung kaki dengan tungkai lurus disebut juga dengan ... ","" +
                    "Tendangan T","Tendangan sabit","Tendangan lurus "
            ,"Tendangan menyilang","Tendangan memutar",3)

        questionList.add(que20)

        val que21 = Question(21,"Sikap tangan saat melakukan gerakkan tendangan sabit yaitu ... ",
                "Mengepal disamping pinggang",
                "Mengepal disamping dada",
                "Lurus sejajar dengan pinggang",
                "Waspada berada didepan dada ",
                "Lurus kesamping kanan dan kiri",4)

        questionList.add(que21)

        val que22 = Question(22,
                "Tendangan dengan lintasan lurus ke samping membentuk huruf T disebut juga dengan ... ",
                "Tendangan lurus","Tendangan T",
                "Tendangan sabit","Tendangan belakango",
                "Tendangan samping",2)

        questionList.add(que22)

        val que23 = Question(23,
                "Lintasan saat melakukkan tendangan sabit yaitu ... ",
                "Lurus ke depan",
                "Setengah lingkaran dari samping melengkung ",
                "Lurus ke samping kanan",
                "Lurus ke belakang",
                "Lurus ke samping kiri",2)

        questionList.add(que23)

        val que24 = Question(24,
                "Teknik membela dengan posisi kaki tidak berpindah tempat tetapi dengan menggeser badan atau tubuh yaitu ... ",
                "Hindaran",
                "Pukulan",
                "Mengelak","Tangkisan",
                "Kuda - kuda",3)

        questionList.add(que24)

        val que25 = Question(25,
                "Tangkisan dengan menggerakkan tangan dari bawah depan badan ke atas depan kepala yaitu ... ",
                "Tangkisan dalam",
                "Tangkisan luar",
                "Tangkisan atas ",
                "Tangkisan bawah","Tangkisan samping",3)

        questionList.add(que25)

        val que26 = Question(26,
                "Pukulan dengan tangan mengepal mengayun ke arah sasaran dengan kepalan menghadap ke atas disebut dengan ... ",
                "Pukulan sangkal atau bandul ",
                "Pukulan depan",
                "Pukulan lingkar",
                "Pukulan samping kanan","Pukulan samping kiri",
                1)

        questionList.add(que26)

        val que27 = Question(27,"Lintasan tangan saat melakukan gerakkan pukulan lingkar yaitu ... ",
                "Dari dalam ke luar","Dari atas ke bawah",
                "Dari luar ke dalam",
                "Dari bawah ke atas","Dari samping ke bawah",3)

        questionList.add(que27)

        val que28 = Question(28,
                "Posisi tangan yang digunakan untuk memukul lurus ke depan dengan sasaran dada dan posisi tangan yang tidak digunakan untuk memukul berada mengepal disamping pinggang, disebut juga dengan pukulan ... ",
                "Pukulan lingkar","Pukulan samping kanan",
                "Pukulan samping kiri","Pukulan sangkal atau bandul",
                "Pukulan depan",5)

        questionList.add(que28)

        val que29 = Question(29,"Sasaran saat melakukan gerakkan pukulan lingkar dalam pencak silat yaitu ... ",
                "Dada","Perut",
                "Rahang dan rusuk",
                "Pinggang","Leher",3)

        questionList.add(que29)

        val que30 = Question(30,"Sikap awal yang digunakan saat melakukan gerakkan tangkisan dalam yaitu ... ",
                "Pola langkah lurus",
                "Kuda – kuda samping","Pola langkah U",
                "Kuda – kuda tengah",
                "Kuda – kuda depan",4)

        questionList.add(que30)



        val que31 = Question(31,
                "Suatu gerakkan belaan dengan mengelak dari serangan musuh pada bagian badan sebelah atas adalah ...",
                "Elakan samping kanan",
                "Elakan samping kiri",
                "Elakan bawah ",
                "Elakan atas",
                "Elakan depan",
                3)

        questionList.add(que31)

        val que32 = Question(32,"Bagaimana titik berat badan saat melakukan gerakkan elakan samping?",
                "Dipindahkan ke depan kanan atau kiri",
                "Tetap diposisi semula tanpa berpindah",
                "Dipindahkan ke samping kanan atau kiri dari kuda – kuda tengah dengan memindahkan letak telapak kaki",
                "Dipindahkan ke samping kanan atau kiri dari kuda – kuda tengah tanpa memindahkan letak telapak kaki ",
                "Dipindahkan ke belakang kanan atau kiri",
                4)

        questionList.add(que32)

        val que33 = Question(33,"Kuda – kuda tengah digunakan dalam gerakkan elakan ... ",
                "Elakan samping ",
                "Elakan atas",
                "Elakan depan",
                "Elakan belakang",
                "Elakan bawah",
                1)

        questionList.add(que33)

        val que34 = Question(34,"Berikut yang bukan termasuk tahapan melakukan elakan atas dalam pencak silat yaitu ...",
                "Posisi awal menggunakan kuda – kuda depan",
                "Sikap kedua tangan waspada",
                "Posisi akhir kembali menggunakan kuda – kuda depan",
                "Merendahkan tubuh dengan sikap tungkai tanpa memindahkan letak kaki",
                "Mengangkat kaki bagian depan ",
                5)

        questionList.add(que34)

        val que35 = Question(35,"Suatu teknik memindahkan tubuh atau anggota tubuh yang menjadi sasaran serangan lawan dengan cara melangkah atau mengangkat kaki disebut dengan ... ",
                "Kuda – kuda",
                "Pukulan",
                "Elakan",
                "Hindaran",
                "Pola langkah",
                4)

        questionList.add(que35)

        val que36 = Question(36,"Berikut yang merupakan jenis – jenis hindaran dalam pencak silat yaitu ...",
                "Hindaran atas",
                "Hindaran bawah",
                "Hindaran depan",
                "Hindaran belakang",
                "Hindaran angkat kaki ",
                5)

        questionList.add(que36)

        val que37 = Question(37,"Bagaimana posisi awal badan saat melakukan gerakkan hindaran sisi ...",
                "Menggunakan kuda – kuda tengah",
                "Menggunakan kuda – kuda depan ",
                "Menggunakan kuda – kuda samping kanan",
                "Menggunakan kuda – kuda belakang",
                "Menggunakan kuda – kuda samping kiri",
                2)

        questionList.add(que37)

        val que38 = Question(38,"Hindaran angkat kaki digunakan untuk menghindari serangan yang mengarah ke anggota tubuh bagian ... ",
                "Kaki",
                "Dada",
                "Punggung",
                "Perut",
                "Tangan",
                1)

        questionList.add(que38)

        val que39 = Question(39,"Bagaimana sikap kedua tangan saat melakukan gerakkan hindaran kaki silang ... ",
                "Berada di samping pinggang",
                "Berada di depan dada",
                "Berada di samping dada",
                "Berada di depan Perut",
                "Berada di belakang badan",
                2)

        questionList.add(que39)

        val que40 = Question(40,"Sikap akhir yang digunakan saat melakukan gerakkan hindaran sisi yaitu ...",
                "Kuda – kuda depan dengan tangan mengepal di samping pinggang",
                "Kuda – kuda samping dengan tangan mengepal di samping pinggang",
                "Kuda - kuda depan dengan sikap tangan waspada ",
                "Kuda – kuda tengah dengan sikap tangan waspada",
                "Kuda – kuda belakang dengan sikap tangan waspada",
                3)

        questionList.add(que40)

        return questionList
    }
}