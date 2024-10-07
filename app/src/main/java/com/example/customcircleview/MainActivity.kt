package com.example.customcircleview
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random
class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint().apply {
        color = Color.RED
        isAntiAlias = true
    }
    private var circleColor: Int = Color.RED
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, height / 2f, width / 3f, paint)
    }
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            // Thay đổi màu sắc ngẫu nhiên
            circleColor = getRandomColor()
            paint.color = circleColor
            invalidate() // Yêu cầu vẽ lại view
            return true
        }
        return super.onTouchEvent(event)
    }
    private fun getRandomColor(): Int {
        return Color.rgb(Random.nextInt(256), Random.nextInt(256),
            Random.nextInt(256))
    }
}