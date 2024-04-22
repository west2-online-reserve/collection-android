package com.example.work5

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import dataclass.ChartData
import kotlin.random.Random


class CustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var chartData: ChartData = (ChartData(listOf(listOf(0f), listOf(0f))))
    private var barColor = Color.BLUE // 条形颜色
    private val barPadding = dpToPx(10f)// 条形间距离
    private val animatorDurationMs = 800L // 动画持续时间
    private var animator: ValueAnimator? = null
    private var animationProgress = 0f // 动画进度

    fun setData(data: ChartData) {
        chartData = data
        // 随机生成颜色
        val randomAlpha = Random.nextInt(256)
        val randomRed = Random.nextInt(256)
        val randomGreen = Random.nextInt(256)
        val randomBlue = Random.nextInt(256)
        barColor = Color.argb(randomAlpha, randomRed, randomGreen, randomBlue)
        startAnimation()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val desiredWidth = MeasureSpec.getSize(widthMeasureSpec)
        val maxHeight = 1000
        setMeasuredDimension(desiredWidth, maxHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.TRANSPARENT)
        //排序后的y值
        var sortedListY = sortData(chartData)
        // 根据动画进度计算当前显示的数据
        val interpolatedList = interpolateData(sortedListY)
        //动态设置条形的宽度
        val barWidth = (width - barPadding * (chartData.values[0].size + 1)) / chartData.values[0].size
        //根据y的大小设置条形图的高度
        for ((index, value) in interpolatedList.withIndex()) {
            val left = (index * (barWidth + barPadding) + barPadding)
            val top = height - value * 100f
            val right = left + barWidth
            val bottom = height.toFloat()
            canvas.drawRect(left, top, right, bottom, Paint().apply {
                color = barColor
            })
        }
    }

    //插值计算
    private fun interpolateData(originalData: List<Float>): List<Float> {
        return originalData.map { it * animationProgress }
    }

    //创建动画
    private fun startAnimation() {
        animator?.cancel()
        animator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = animatorDurationMs
            repeatCount = 0
            interpolator = AccelerateDecelerateInterpolator()
            addUpdateListener { animation ->
                animationProgress = animation.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    //将dp转为px
    private fun dpToPx(dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    //对传入的数据的x值进行排序
    private fun sortData(data: ChartData): List<Float> {
        //设数组第一行值为x，第二行值为y，将x进行升序排序，y与之对应
        val pairedValues = chartData.values.zipWithNext().flatMap { (list1, list2) ->
            list1.zip(list2)
        }
        val sortedPairedValues = pairedValues.sortedBy { it.first }
        //得到排序后y的数值
        return sortedPairedValues.map { it.second }
    }
}

