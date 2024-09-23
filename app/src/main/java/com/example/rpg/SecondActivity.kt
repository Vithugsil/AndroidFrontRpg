package com.example.rpg

import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen_layout)

        val tvPoints = findViewById<TextView>(R.id.tv_points)
        tvPoints.text = "27"

        val sbStrength = findViewById<SeekBar>(R.id.sb_strength)
        val sbDexterity = findViewById<SeekBar>(R.id.sb_dexterity)
        val sbWisdom = findViewById<SeekBar>(R.id.sb_wisdom)

        val strengthBox = findViewById<TextView>(R.id.tv_strength_box)
        val dexterityBox = findViewById<TextView>(R.id.tv_dexterity_box)
        val wisdomBox = findViewById<TextView>(R.id.tv_wisdom_box)
        val constitutionBox = findViewById<TextView>(R.id.tv_constitution_box)
        val intelligenceBox = findViewById<TextView>(R.id.tv_intelligence_box)
        val charismaBox = findViewById<TextView>(R.id.tv_charisma_box)

        // Atualizar os valores iniciais formatados
        val initialNum = "08"
        val format = getString(R.string.box, initialNum)
        strengthBox.text = format
        dexterityBox.text = format
        wisdomBox.text = format
        constitutionBox.text = format
        intelligenceBox.text = format
        charismaBox.text = format

        // Listener para as SeekBars
        sbStrength.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                strengthBox.text = String.format(getString(R.string.box), String.format("%02d", p1))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        sbDexterity.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                dexterityBox.text = getString(R.string.box, String.format("%02d", p1))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        sbWisdom.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                wisdomBox.text = getString(R.string.box, String.format("%02d", p1))
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        // Repita para as demais SeekBars...
    }
}
