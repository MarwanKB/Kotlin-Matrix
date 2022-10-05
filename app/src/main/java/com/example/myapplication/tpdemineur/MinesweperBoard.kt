package com.example.myapplication.tpdemineur

import kotlin.math.roundToInt

class MinesweperBoard(lignes: Int, colonnes: Int): BooleanMatrix(lignes, colonnes) {

    init {

        val mines = ((lignes * colonnes)* 0.08).roundToInt()
        for(i in 0..mines) {
            var randLigne: Int
            var randCol: Int
            do {
                randLigne = (0 until lignes).random()
                randCol = (0 until colonnes).random()
            } while (this[randLigne, randCol] == true)
            this[randLigne, randCol] = true
        }
    }

    fun getBoardHint(): IntMatrix{
        val hintMatrix = IntMatrix(lignes, colonnes)
        for(ligne in 0 until lignes){
            for(col in 0 until colonnes){
                if(this[ligne, col] != true) {
                    val mines: Int? = countMines(ligne, col)
                    if(mines != null) {
                        hintMatrix[ligne, col] = mines
                    }
                }
                else {
                    hintMatrix[ligne, col] = 9
                }
            }
        }
        return hintMatrix
    }


    fun countMines(ligne: Int, col: Int): Int? {
        var mines = 0
        if(ligne > 0) {
            if(this[ligne-1, col] == true) mines++
        }
        if(col > 0 ){
            if(this[ligne, col - 1] == true) mines++
        }
        if(ligne < lignes-1) {
            if(this[ligne + 1, col] == true) mines++
        }
        if(col < colonnes-1) {
            if(this[ligne, col + 1] == true) mines++
        }
        if(ligne > 0 && col > 0){
            if(this[ligne-1, col-1] == true) mines++
        }
        if(ligne > 0 && col < colonnes -1){
            if(this[ligne-1, col+1] == true) mines++
        }
        if(ligne < colonnes-1 && col > 0){
            if(this[ligne + 1, col - 1] == true) mines++
        }
        if(ligne < lignes-1 && col < colonnes - 1){
            if(this[ligne+1, col+1] == true) mines++
        }
        return if(mines == 0) null else mines
    }

}