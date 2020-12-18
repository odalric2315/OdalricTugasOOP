import kotlin.math.PI
import kotlin.math.sqrt

abstract class Shape {
    abstract fun calculateArea() : Double
    abstract fun calculatePerimeter() : Double
}

open class Rectangle(val width: Double, val length: Double) : Shape() {

    override fun calculateArea(): Double {
        return width*length
    }

    override fun calculatePerimeter(): Double {
        return 2 * (width + length)
    }
}

class Square(side: Double) : Rectangle(side, side)

class Triangle(private val s1 : Double, private val s2 : Double, private val s3 : Double) : Shape() {

    private var height : Double = 0.0

    constructor(base : Double, height: Double) : this(base, 0.0, 0.0) {
        this.height = height
    }

    override fun calculateArea() : Double {
        return if(s1 > 0 && s2 > 0 && s3 > 0) {
            val s = calculatePerimeter()/2
            sqrt(s * (s - s1) * (s - s2) * (s - s3))
        }
        else {
            1.0/2 * s1 * height
        }
    }

    override fun calculatePerimeter(): Double {
        return s1 + s2 + s3
    }
}

class Circle(var radius : Double) : Shape() {

    override fun calculateArea(): Double {
        return PI*radius*radius
    }
    override fun calculatePerimeter(): Double {
        return 2*PI*radius
    }
}

fun main() {
    //contoh persegi panjang
    print("Masukkan nilai panjang : ")
    val panjang: Double = readLine()?.toDouble()!!
    print("Masukkan nilai lebar : ")
    val lebar: Double = readLine()?.toDouble()!!
    val persegipanjang = Rectangle(panjang, lebar)
    println("Luas persegi panjang = ${persegipanjang.calculateArea()}")

    //contoh persegi
    print("Masukkan nilai sisi : ")
    val sisi: Double = readLine()?.toDouble()!!
    val persegi = Square(sisi)
    println("Luas persegi = ${persegi.calculateArea()}")

    //contoh segitiga 1
    print("Masukkan nilai s1 : ")
    val s1: Double = readLine()?.toDouble()!!
    print("Masukkan nilai s2 : ")
    val s2: Double = readLine()?.toDouble()!!
    print("Masukkan nilai s3 : ")
    val s3: Double = readLine()?.toDouble()!!
    val segitiga1 = Triangle(s1, s2, s3)
    println("Luas Segitiga = ${segitiga1.calculateArea()}")

    //contoh segitiga 2
    print("Masukkan nilai alas : ")
    val alas: Double = readLine()?.toDouble()!!
    print("Masukkan nilai tinggi : ")
    val tinggi: Double = readLine()?.toDouble()!!
    val segitiga2 = Triangle(alas, tinggi)
    println("Luas Segitiga = ${segitiga2.calculateArea()}")

    //contoh lingkaran 1
    print("Masukkan nilai r : ")
    val r: Double = readLine()?.toDouble()!!
    val lingkaran = Circle(r)
    println("Luas lingkaran = ${lingkaran.calculateArea()}")

}