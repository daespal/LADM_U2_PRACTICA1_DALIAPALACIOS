package com.example.ladm_u2_practica1_daliapalacios

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Nieve (l:Lienzo){
    val l = l
    var x = 0f
    var y = 0f
    var movX = 0f
    var movY = 0f
    var color = Color.BLACK

    init {
        x = rand(1000)
        y = rand(1900)

        movY = rand(4)+2

        if(rand(100)<50f){
            movY += 1
        }
        color = Color.WHITE
    }

    private fun rand(hasta:Int) : Float{
        return Random.nextInt(hasta).toFloat()
    }

    fun mover(){
        if(y <0 || y>l.height){
           y=0F
        }
        y += movY

    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = color
        canvas.drawCircle(x,y,50f,p)
    }

}