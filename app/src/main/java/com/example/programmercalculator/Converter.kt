package com.example.programmercalculator

class Converter(){

    fun convertDecimalToBinary(value:String):String = value.toInt().toString(2)
    //    -------------------------------------------------
    fun convertDecimalToHexa(value:String):String =
        value.toInt().toString(16)
    //    -------------------------------------------------
    fun convertDecimalToOcta(value:String):String = value.toInt().toString(8)
    //    -------------------------------------------------
    fun convertBinaryToDecimal(value:String):String = value.toInt(2).toString()
    //    -------------------------------------------------
    fun convertBinaryToOcta(value:String):String =
        Integer.parseInt(value, 2).toString(8)
    //    -------------------------------------------------
    fun convertBinaryToHexa(value:String):String =
        Integer.parseInt(value, 2).toString(16)
    //    -------------------------------------------------
    fun convertOctaToBinary(value:String):String =
        Integer.parseInt(value, 8).toString(2)
    //    -------------------------------------------------
    fun convertOctaToDecimal(value:String):String =
        Integer.parseInt(value, 8).toString()
    //    -------------------------------------------------
    fun convertOctaToHexa(value:String):String =
        Integer.parseInt(value, 8).toString(16)
    //    -------------------------------------------------
    fun convertHexaToDecimal(value:String):String =
        Integer.parseInt(value, 16).toString()
    //    -------------------------------------------------
    fun convertHexaToBinary(value:String):String =
        Integer.parseInt(value.toString(), 16).toString(2)
    //    -------------------------------------------------
    fun convertHexaToOcta(value:String):String =
        Integer.parseInt(value, 16).toString(8)
}