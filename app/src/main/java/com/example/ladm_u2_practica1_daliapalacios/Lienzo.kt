package com.example.ladm_u2_practica1_daliapalacios

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo(li:MainActivity) : View(li)  {
    var li=li
    var nieves = Array<Nieve>(10,{ Nieve(this) })


    val corutina = GlobalScope.launch {
        while (true){
            li.runOnUiThread{
                invalidate()
            }
            delay(20L)

        }
    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        //Paint
        var p = Paint()


        li.setTitle("Una noche nevada")


        //fondo
        c.drawColor(Color.rgb(1,1,1))


        //montañas
        p.color = Color.rgb(112, 146, 190)
        c.drawCircle(200F,600F,300F,p)
        c.drawCircle(600F,600F,260F,p)
        c.drawCircle(1000F,600F,300F,p)

        //campo
        p.color = Color.rgb(84,41,41)
        c.drawRect(1f, 800f, 1080f, 2000f, p)

        //casa
        p.color = Color.rgb(255,174,200)
        c.drawRect(1080F,950F,600F,700F,p)
        p.color = Color.rgb(255,180,250)
        c.drawRect(500F,950F,600F,800F,p)
        p.color = Color.rgb(1,1,2)
        c.drawRect(1000F,950F,800F,850F,p)

        //lago
        p.color =Color.rgb(195,195,195)
        c.drawCircle(100F,1500F,200F,p)
        c.drawCircle(400F,1500F,200F,p)
        c.drawCircle(700F,1500F,200F,p)
        c.drawCircle(1000F,1500F,200F,p)
        p.color = Color.rgb(153,217,234)
        c.drawRect(1F,1580F,1080F,1450F,p)

        //arbol
        p.color = Color.rgb(60,30,30)
        c.drawRect(1F,1100F,150F,1000F,p)
        p.color = Color.rgb(0,81,0)
        c.drawCircle(50F,850F,150F,p)

        for(circ in nieves){
            circ.mover()
            circ.pintar(c)
        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        event.x //el x del toque, donde tocaste de forma horizontal
        event.y //el y del toque, donde tocaste de forma vertical

        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                //oprimir
                var ran = Random.nextInt(250)
                nieves = Array<Nieve>(ran,{ Nieve(this) })
            }
        }
        return true
    }
}