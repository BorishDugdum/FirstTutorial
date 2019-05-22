package com.example.firsttutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslation = text_view_progress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                text_view_progress.text = progress.toString()

                //Create resource (R.dimen) under res/values/dimensions
                val distanceTranslation = initialTextViewTranslation + progress * resources.getDimension(R.dimen.text_anim_step) * -1

                text_view_progress.animate().translationY(distanceTranslation)

                if(!fromUser)
                    text_view_progress.animate().setDuration(500).translationY(initialTextViewTranslation).rotationBy(360f).
                        translationY(initialTextViewTranslation)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        button_reset.setOnClickListener{v ->
            seekBar.progress = 0

        }
    }
}
