package com.example.myapplication.tpdemineur

class SquareMatrix<T>(val taille: Int) : Matrix<T>(taille, taille) {
    override fun isSquare(): Boolean{
        return true
    }
}