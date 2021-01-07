package com.glureau.motionlayoutbacktotop

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlin.random.Random

class CustomBehaviour(context: Context?, attrs: AttributeSet?) :
    CoordinatorLayout.Behavior<TextView>(context, attrs) {

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: TextView,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return true // Always listen scrolling
    }

    val r = Random(2)
    fun randomColor() = Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255))

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: TextView,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        child.setBackgroundColor(randomColor())
        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            consumed
        )
    }
}