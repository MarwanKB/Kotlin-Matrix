import com.example.myapplication.R

fun main() {
    var m = IntMatrix(3,3);
    m[0,0] = 10
    m[0,1] = 10
    m[0,2] = 10
    m[1,0] = 10
    m[1,1] = 10
    m[1,2] = 10
    m[2,0] = 10
    m[2,1] = 10
    m[2,2] = 10

    var m2 = IntMatrix(3,3);
    m2[0,0] = 1
    m2[0,1] = 1
    m2[0,2] = 1
    m2[1,0] = 5
    m2[1,1] = 5
    m2[1,2] = 5
    m2[2,0] = 1
    m2[2,1] = 1
    m2[2,2] = 1
    print(m2);

    m.times(m2);
}

fun foo(name: String? = "", number: Int? = 0, toUpperCase: Boolean? = true) =
    (if (toUpperCase == true) name?.uppercase() else name) + number;

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

fun tva(price : Int) : Unit{
    var price2 : Double = price + price * 0.021
    print("TVA 2,1% : $price2 \n")
    var price5 : Double = price + price * 0.055
    print("TVA 5,5% : $price5 \n")
    var price10 : Double = price + price * 0.1
    print("TVA 10% : $price10 \n")
    var price20 : Double = price + price * 0.2
    print("TVA 20% : $price20 \n")
}

class IntMatrix(var x: Int, var y : Int) : Matrix<Int>(x, y){
    operator fun times(m2 : IntMatrix): IntMatrix{
        if (this.col != m2.x){
            throw Exception("Incompatible times between theses matrix")
        }
        var result = IntMatrix(this.x, m2.col)
        for (i in 0 until this.x) {
            for (j in 0 until m2.col) {
                var sum = 0
                for (k in 0 until m2.x) {
                    sum += this.matrix[i][k]?.times(m2.matrix[i][j]!!) ?: 0
                }
                result.matrix[i][j] = sum
            }
        }
        println(result)
        return result
    }


}
class BooleanMatrix(var x : Int, var y : Int) : Matrix<Boolean>(x,y)
class SquaredMatrix<T>( var taille : Int) : Matrix<T>(taille, taille)

abstract class Matrix<T>(var ligne : Int, var col : Int){
    var matrix : List<MutableList<Int?>> = List(ligne) { MutableList(col){ null } }

    override fun toString(): String {
        var str = "";
        for (i in matrix){
            for (j in i){
                if (j == null){
                   str+="- "
                }
                else {
                    str += j
                }
            }
            str+= "\n"
        }
        return str
    }

    fun getMatrice() : List<MutableList<Int?>> {
        return matrix;
    }
    fun isSquared() : Boolean{
        return this.col == this.ligne
    }

    operator fun set(row: Int, column: Int, value: Int){
        matrix[row][column] = value
    }
}
