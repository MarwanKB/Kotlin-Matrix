package com.example.myapplication.tpdemineur
class IntMatrix(ligne: Int, col: Int): Matrix<Int>(ligne, col) {

    fun stringSymbol(value: Int?): String {
        if( value == 9) {
            return "*"
        } else if (value != null) {
            return value.toString()
        }
        else {
            return "-"
        }
    }

    override operator fun times(matrix2: Matrix<Int>): Matrix<Int> {
        // TODO
        return IntMatrix(0, 0)
    }

    operator fun timesAssign(matrix: Matrix<Int>) {
        // TODO
    }

    override fun toString(): String {
        val string = StringBuilder()
        for(i in 0 until lignes){
            string.append("[")
            val listIterator = this[i].listIterator()
            while (listIterator.hasNext()){
                string.append(stringSymbol(listIterator.next()))
            }
            string.append("]\n")
        }
        return string.toString()
    }
}