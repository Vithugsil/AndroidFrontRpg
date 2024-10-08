package com.example.rpg

import MyCharacter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import org.example.builder.Characterbuilder
import org.example.entities.Modifiers
import org.example.entities.DistributionPoints as dp

class SecondActivity : ComponentActivity() {

    // Habilidades do personagem
    private var strength: Int = 8
    private var dexterity: Int = 8
    private var constitution: Int = 8
    private var intelligence: Int = 8
    private var wisdom: Int = 8
    private var charisma: Int = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen_layout)

        // Recebe o nome e a raça do personagem da atividade anterior
        val characterName = intent.getStringExtra("characterName") ?: "Unknown"
        val characterBreed = intent.getIntExtra("characterBreed", 0)

        // Cria o personagem
        val character = Characterbuilder.build(characterName, characterBreed)

        // Exibe o nome do personagem na tela
        val characterNameTextView = findViewById<TextView>(R.id.characterName)
        characterNameTextView.text = characterName

        // Exibe os pontos restantes na tela
        updateRemainingPoints()

        // Botões de mais e menos
        val btnStrengthPlus = findViewById<Button>(R.id.btnPlusStrength)
        val btnStrengthMinus = findViewById<Button>(R.id.btnMinusStrength)
        val btnDexterityPlus = findViewById<Button>(R.id.btnPlusDexterity)
        val btnDexterityMinus = findViewById<Button>(R.id.btnMinusDexterity)
        val btnConstitutionPlus = findViewById<Button>(R.id.btnPlusConstitution)
        val btnConstitutionMinus = findViewById<Button>(R.id.btnMinusConstitution)
        val btnIntelligencePlus = findViewById<Button>(R.id.btnPlusIntelligence)
        val btnIntelligenceMinus = findViewById<Button>(R.id.btnMinusIntelligence)
        val btnWisdomPlus = findViewById<Button>(R.id.btnPlusWisdom)
        val btnWisdomMinus = findViewById<Button>(R.id.btnMinusWisdom)
        val btnCharismaPlus = findViewById<Button>(R.id.btnPlusCharisma)
        val btnCharismaMinus = findViewById<Button>(R.id.btnMinusCharisma)

        // TextViews para exibir os valores das habilidades
        val txtStrength = findViewById<TextView>(R.id.txtStrength)
        txtStrength.text = strength.toString()
        val txtDexterity = findViewById<TextView>(R.id.txtDexterity)
        txtDexterity.text = dexterity.toString()
        val txtConstitution = findViewById<TextView>(R.id.txtConstitution)
        txtConstitution.text = constitution.toString()
        val txtIntelligence = findViewById<TextView>(R.id.txtIntelligence)
        txtIntelligence.text = intelligence.toString()
        val txtWisdom = findViewById<TextView>(R.id.txtWisdom)
        txtWisdom.text = wisdom.toString()
        val txtCharisma = findViewById<TextView>(R.id.txtCharisma)
        txtCharisma.text = charisma.toString()

        // Botões de mais
        btnStrengthPlus.setOnClickListener {
            if (strength in 8..15) {
                val cost = Modifiers.modifierCost(strength)
                if (dp.totalPoints - cost >= 0) {
                    strength++
                    txtStrength.text = strength.toString()
                    dp.distributePoints(character, dp.verifyChoice(0), strength)
                    dp.totalPoints -= cost
                    updateRemainingPoints()
                } else {
                    showToast("not enough point")
                }
            } else {
                showToast("The value cannot be higher than 15")
            }
        }

        btnDexterityPlus.setOnClickListener {
            if (dexterity in 8..15) {
                val cost = Modifiers.modifierCost(dexterity)
                if (dp.totalPoints - cost >= 0) {
                    dexterity++
                    txtDexterity.text = dexterity.toString()
                    dp.distributePoints(character, dp.verifyChoice(1), dexterity)
                    dp.totalPoints -= cost
                    updateRemainingPoints()
                } else {
                    showToast("not enough point")
                }
            } else {
                showToast("The value cannot be higher than 15")
            }
        }

        btnConstitutionPlus.setOnClickListener {
            if (constitution in 8..15) {
                val cost = Modifiers.modifierCost(constitution)
                if (dp.totalPoints - cost >= 0) {
                    constitution++
                    txtConstitution.text = constitution.toString()
                    dp.distributePoints(character, dp.verifyChoice(2), constitution)
                    dp.totalPoints -= cost
                    updateRemainingPoints()
                } else {
                    showToast("not enough point")
                }
            } else {
                showToast("The value cannot be higher than 15")
            }
        }

        btnIntelligencePlus.setOnClickListener {
            if (intelligence in 8..15) {
                val cost = Modifiers.modifierCost(intelligence)
                if (dp.totalPoints - cost >= 0) {
                    intelligence++
                    txtIntelligence.text = intelligence.toString()
                    dp.distributePoints(character, dp.verifyChoice(3), intelligence)
                    dp.totalPoints -= cost
                    updateRemainingPoints()
                } else {
                    showToast("not enough point")
                }
            } else {
                showToast("The value cannot be higher than 15")
            }
        }

        btnWisdomPlus.setOnClickListener {
            if (wisdom in 8..15) {
                val cost = Modifiers.modifierCost(wisdom)
                if (dp.totalPoints - cost >= 0) {
                    wisdom++
                    txtWisdom.text = wisdom.toString()
                    dp.distributePoints(character, dp.verifyChoice(4), wisdom)
                    dp.totalPoints -= cost
                    updateRemainingPoints()
                } else {
                    showToast("not enough point")
                }
            } else {
                showToast("The value cannot be higher than 15")
            }
        }

        btnCharismaPlus.setOnClickListener {
            if (charisma in 8..15) {
                val cost = Modifiers.modifierCost(charisma)
                if (dp.totalPoints - cost >= 0) {
                    charisma++
                    txtCharisma.text = charisma.toString()
                    dp.distributePoints(character, dp.verifyChoice(5), charisma)
                    dp.totalPoints -= cost
                    updateRemainingPoints()
                } else {
                    showToast("not enough point")
                }
            } else {
                showToast("The value cannot be higher than 15")
            }
        }

        // Botões de menos
        btnStrengthMinus.setOnClickListener {
            if (strength in 8..15) {
                if (strength - 1 < 8) {
                    showToast("The value cannot be lower than 8")
                } else {
                    val refund = Modifiers.modifierCost(strength)
                    strength--
                    txtStrength.text = strength.toString()
                    dp.distributePoints(character, dp.verifyChoice(0), strength)
                    dp.totalPoints += refund
                    updateRemainingPoints()
                }
            } else {
                showToast("The value cannot be lower than 8")
            }
        }

        btnDexterityMinus.setOnClickListener {
            if (dexterity in 8..15) {
                if (dexterity - 1 < 8) {
                    showToast("The value cannot be lower than 8")
                } else {
                    val refund = Modifiers.modifierCost(dexterity)
                    dexterity--
                    txtDexterity.text = dexterity.toString()
                    dp.distributePoints(character, dp.verifyChoice(1), dexterity)
                    dp.totalPoints += refund
                    updateRemainingPoints()
                }
            } else {
                showToast("The value cannot be lower than 8")
            }
        }

        btnConstitutionMinus.setOnClickListener {
            if (constitution in 8..15) {
                if (constitution - 1 < 8) {
                    showToast("The value cannot be lower than 8")
                } else {
                    val refund = Modifiers.modifierCost(constitution)
                    constitution--
                    txtConstitution.text = constitution.toString()
                    dp.distributePoints(character, dp.verifyChoice(2), constitution)
                    dp.totalPoints += refund
                    updateRemainingPoints()
                }
            } else {
                showToast("The value cannot be lower than 8")
            }
        }

        btnIntelligenceMinus.setOnClickListener {
            if (intelligence in 8..15) {
                if (intelligence - 1 < 8) {
                    showToast("The value cannot be lower than 8")
                } else {
                    val refund = Modifiers.modifierCost(intelligence)
                    intelligence--
                    txtIntelligence.text = intelligence.toString()
                    dp.distributePoints(character, dp.verifyChoice(3), intelligence)
                    dp.totalPoints += refund
                    updateRemainingPoints()
                }

            } else {
                showToast("The value cannot be lower than 8")
            }
        }

        btnWisdomMinus.setOnClickListener {
            if (wisdom in 8..15) {
                if (wisdom - 1 < 8) {
                    showToast("The value cannot be lower than 8")
                }else{
                    val refund = Modifiers.modifierCost(wisdom)
                    wisdom--
                    txtWisdom.text = wisdom.toString()
                    dp.distributePoints(character, dp.verifyChoice(4), wisdom)
                    dp.totalPoints += refund
                    updateRemainingPoints()
                }
            } else {
                showToast("The value cannot be lower than 8")
            }
        }

        btnCharismaMinus.setOnClickListener {
            if (charisma in 8..15) {
                if (charisma - 1 < 8) {
                    showToast("The value cannot be lower than 8")
                }
                else{
                    val refund = Modifiers.modifierCost(charisma)
                    charisma--
                    txtCharisma.text = charisma.toString()
                    dp.distributePoints(character, dp.verifyChoice(5), charisma)
                    dp.totalPoints += refund
                    updateRemainingPoints()
                }
            } else {
                showToast("The value cannot be lower than 8")
            }
        }

        // Botão de finalizar
        val btnFinish = findViewById<Button>(R.id.createMyCharacter)
        btnFinish.setOnClickListener {
            val intent = Intent(this, ResumeActivity::class.java)
            intent.putExtra("character", MyCharacter(character))
            startActivity(intent)
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun updateRemainingPoints() {
        val remainingPointsTextView = findViewById<TextView>(R.id.remainingPoints)
        remainingPointsTextView.text = "Remaining points: ${dp.totalPoints}"
    }
}
