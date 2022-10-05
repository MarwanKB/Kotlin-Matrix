package com.example.myapplication.tpdemineur
abstract class Matrix<T> (val lignes: Int, val colonnes: Int) {

    private val matrix : List<MutableList<T?>> = List(lignes) {MutableList(colonnes) {null} }

    operator fun get(row: Int, column: Int): T? {
        return matrix[row][column]
    }
    operator fun get(row: Int): MutableList<T?> {
        return matrix[row]
    }

    operator fun set(row: Int, column: Int, value: T){
        matrix[row][column] = value
    }

    open fun isSquare() : Boolean{
        return lignes == colonnes
    }

    fun typeOfString(value: T?): String {
        if( value == 9) {
            return "* "
        } else if (value != null) {
            return value.toString()
        }
        else {
            return "- "
        }
    }

    override fun toString(): String {
        val string = StringBuilder()
        matrix.forEach() {
            string.append("[")
            val listIterator = it.listIterator()
            while (listIterator.hasNext()){
                string.append(typeOfString(listIterator.next()))
            }
            string.append("]\n")
        }
        return string.toString()
    }

    open operator fun times(matrix2: Matrix<Int>): Matrix<Int> {
        // TODO
        return IntMatrix(0, 0)
    }
}