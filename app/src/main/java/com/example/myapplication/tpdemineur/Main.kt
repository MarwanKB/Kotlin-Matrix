package com.example.myapplication.tpdemineur

fun main() {
    val minesweperBoard = MinesweperBoard(10, 10)
    println(minesweperBoard)
    println(minesweperBoard.getBoardHint().toString())
}