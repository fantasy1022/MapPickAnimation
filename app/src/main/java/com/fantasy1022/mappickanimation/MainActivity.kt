package com.fantasy1022.mappickanimation

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.graphics.drawable.Animatable2Compat
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val avd = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_endless_pin_jump)
        val iv = (findViewById(R.id.pin) as ImageView).apply {
            setImageDrawable(avd)
        }
        avd?.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                iv.post { avd.start() }
            }
        })
        avd?.start()
    }
}
