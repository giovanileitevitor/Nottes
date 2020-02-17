package com.example.nottes.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Total de colunas: 9

@Entity(tableName = "apontamento_table")
data class Registro(
    @PrimaryKey @ColumnInfo(name = "descricao")
    val descricao: String,

    @ColumnInfo(name = "valorPago")
    val valorPago: Float,

    @ColumnInfo(name = "kmAtual")
    val kmAtual: Int,

    @ColumnInfo(name = "valorGasolina")
    val valorGasolina: Float,

    @ColumnInfo(name = "valorAlcool")
    val valorAlcool: Float,

    @ColumnInfo(name = "tipoCombustivel")
    val tipoCombustivel: Boolean,

    @ColumnInfo(name = "localizacaoPostoLat")
    val localizcaoPostoLat: Float,

    @ColumnInfo(name = "localizacaoPostoLong")
    val localizcaoPostoLong: Float,

    @ColumnInfo(name = "timeStamp")
    val timeStamp: String

)