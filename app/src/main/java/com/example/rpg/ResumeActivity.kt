package com.example.rpg

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import org.example.entities.Modifiers as md


class ResumeActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resume_layout)

        val character = CharacterHolder.character


        if (character != null) {

            val finalStrength = character.skills.strength + character.breed.strength()
            val finalDexterity = character.skills.dexterity + character.breed.dexterity()
            val finalConstitution = character.skills.constitution + character.breed.constitution()
            val finalWisdom = character.skills.wisdom + character.breed.wisdom()
            val finalIntelligence = character.skills.intelligence + character.breed.intelligence()
            val finalCharisma = character.skills.charisma + character.breed.charisma()




            val inputDoNome = findViewById<TextView>(R.id.tv_characterName)
            inputDoNome.text = character.name

            val inputDaRaca = findViewById<TextView>(R.id.tv_characterBreed)
            inputDaRaca.text = character.breed::class.simpleName

            val inputDaVida = findViewById<TextView>(R.id.tv_lifespan)
            (character.life + character.skills.constitution).toString().also {
                inputDaVida.text = it
            }

            val inputDaClasse = findViewById<TextView>(R.id.tv_class)
            inputDaClasse.text = intent.getStringExtra("characterClass")

            //input de forca
            val inputDaForca = findViewById<TextView>(R.id.tv_strength_value)
            inputDaForca.text = finalStrength.toString()
            val inputDaForcaModifier = findViewById<TextView>(R.id.tv_strength_modifier)
            inputDaForcaModifier.text = md.modifierAttribute(finalStrength).toString()

            //input de destreza
            val inputDaDestreza = findViewById<TextView>(R.id.tv_dexterity_value)
            inputDaDestreza.text = finalDexterity.toString()
            val inputDaDestrezaModifier = findViewById<TextView>(R.id.tv_dexterity_modifier)
            inputDaDestrezaModifier.text = md.modifierAttribute(finalDexterity).toString()

            // input de constituição
            val inputDaConstituicao = findViewById<TextView>(R.id.tv_constitution_value)
            inputDaConstituicao.text = finalConstitution.toString()
            val inputDaConstituicaoModifier = findViewById<TextView>(R.id.tv_constitution_modifier)
            inputDaConstituicaoModifier.text = md.modifierAttribute(finalConstitution).toString()

            //input de sabedoria
            val inputDaSabedoria = findViewById<TextView>(R.id.tv_wisdom_value)
            inputDaSabedoria.text = finalWisdom.toString()
            val inputDaSabedoriaModifier = findViewById<TextView>(R.id.tv_wisdom_modifier)
            inputDaSabedoriaModifier.text = md.modifierAttribute(finalWisdom).toString()

            //input de carisma
            val inputDaCarisma = findViewById<TextView>(R.id.tv_charisma_value)
            inputDaCarisma.text = finalCharisma.toString()
            val inputDaCarismaModifier = findViewById<TextView>(R.id.tv_charisma_modifier)
            inputDaCarismaModifier.text = md.modifierAttribute(finalCharisma).toString()

            //input de inteligência
            val inputDaInteligencia = findViewById<TextView>(R.id.tv_intelligence_value)
            inputDaInteligencia.text = finalIntelligence.toString()
            val inputDaInteligenciaModifier = findViewById<TextView>(R.id.tv_intelligence_modifier)
            inputDaInteligenciaModifier.text = md.modifierAttribute(finalIntelligence).toString()

            val btnFinish = findViewById<Button>(R.id.btn_finish)
            btnFinish.setOnClickListener {
                showToast("Seu personagem foi criado com sucesso!")
            }

        }


    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
