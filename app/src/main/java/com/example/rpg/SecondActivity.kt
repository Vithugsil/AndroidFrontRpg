package com.example.rpg


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.rpg.data.CharacterEntity
import org.example.builder.Characterbuilder
import org.example.enums.Attributes
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
        val characterClass = intent.getStringExtra("characterClass") ?: "Unknown"

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

        // Botões de Força
        btnStrengthPlus.setOnClickListener {
            if (strength + 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(strength + 1)
            } else {
                if (dp.totalPoints == 0){
                    showToast("You don't have any points to distribute")
                    return@setOnClickListener
                }
                strength++
                txtStrength.text = strength.toString()
                dp.distributePoints(character, Attributes.STRENGTH, strength)
                updateRemainingPoints()
            }
        }

        btnStrengthMinus.setOnClickListener {
            if (strength - 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(strength - 1)
            } else {
                dp.refundPoints(character, Attributes.STRENGTH, strength)
                strength--
                txtStrength.text = strength.toString()
                updateRemainingPoints()
            }
        }

        // Botões de Destreza
        btnDexterityPlus.setOnClickListener {
            if (dexterity + 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(dexterity + 1)
            } else {
                if (dp.totalPoints == 0){
                    showToast("You don't have any points to distribute")
                    return@setOnClickListener
                }
                dexterity++
                txtDexterity.text = dexterity.toString()
                dp.distributePoints(character, Attributes.DEXTERITY, dexterity)
                updateRemainingPoints()
            }
        }

        btnDexterityMinus.setOnClickListener {
            if (dexterity - 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(dexterity - 1)
            } else {
                dp.refundPoints(character, Attributes.DEXTERITY, dexterity)
                dexterity--
                txtDexterity.text = dexterity.toString()
                updateRemainingPoints()
            }
        }

        //botões de constituição
        btnConstitutionPlus.setOnClickListener {
            if (constitution + 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(constitution + 1)
            } else {
                if (dp.totalPoints == 0){
                    showToast("You don't have any points to distribute")
                    return@setOnClickListener
                }
                constitution++
                txtConstitution.text = constitution.toString()
                dp.distributePoints(character, Attributes.CONSTITUTION, constitution)
                updateRemainingPoints()
            }
        }

        btnConstitutionMinus.setOnClickListener {
            if (constitution - 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(constitution - 1)
            } else {
                dp.refundPoints(character, Attributes.CONSTITUTION, constitution)
                constitution--
                txtConstitution.text = constitution.toString()
                updateRemainingPoints()
            }
        }

        //Botões de inteligência
        btnIntelligencePlus.setOnClickListener {
            if (intelligence + 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(intelligence + 1)
            } else {
                if (dp.totalPoints == 0){
                    showToast("You don't have any points to distribute")
                    return@setOnClickListener
                }
                intelligence++
                txtIntelligence.text = intelligence.toString()
                dp.distributePoints(character, Attributes.INTELLIGENCE, intelligence)
                updateRemainingPoints()
            }
        }

        btnIntelligenceMinus.setOnClickListener {
            if (intelligence - 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(intelligence - 1)
            }else{
                dp.refundPoints(character, Attributes.INTELLIGENCE, intelligence)
                intelligence--
                txtIntelligence.text = intelligence.toString()
                updateRemainingPoints()
            }
        }

        //Botões de sabedoria
        btnWisdomPlus.setOnClickListener {
            if (wisdom + 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(wisdom + 1)
            } else {
                if (dp.totalPoints == 0){
                    showToast("You don't have any points to distribute")
                    return@setOnClickListener
                }
                wisdom++
                txtWisdom.text = wisdom.toString()
                dp.distributePoints(character, Attributes.WISDOM, wisdom)
                updateRemainingPoints()
            }
        }

        btnWisdomMinus.setOnClickListener {
            if (wisdom - 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(wisdom - 1)
            } else {
                dp.refundPoints(character, Attributes.WISDOM, wisdom)
                wisdom--
                txtWisdom.text = wisdom.toString()
                updateRemainingPoints()
            }
        }

        //Botões de carisma
        btnCharismaPlus.setOnClickListener {
            if (charisma + 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(charisma + 1)
            } else {
                if (dp.totalPoints == 0){
                    showToast("You don't have any points to distribute")
                    return@setOnClickListener
                }
                charisma++
                txtCharisma.text = charisma.toString()
                dp.distributePoints(character, Attributes.CHARISMA, charisma)
                updateRemainingPoints()
            }
        }

        btnCharismaMinus.setOnClickListener {
            if (charisma - 1 !in 8..15) {
                verifyIfValueIsLowerThanEight(charisma - 1)
            }else{
                dp.refundPoints(character, Attributes.CHARISMA, charisma)
                charisma--
                txtCharisma.text = charisma.toString()
                updateRemainingPoints()
            }
        }



        // Botão de finalizar
        val btnFinish = findViewById<Button>(R.id.createMyCharacter)
        btnFinish.setOnClickListener {
            if (dp.totalPoints != 0) {
                showToast("You still have points to distribute")
                return@setOnClickListener
            }

            val characterEntity = CharacterEntity(
                id = null,
                name = character.name,
                breed = character.breed::class.simpleName ?: "Unknown",
                classCharacter = characterClass,
                strength = character.skills.strength,
                dexterity = character.skills.dexterity,
                constitution = character.skills.constitution,
                intelligence = character.skills.intelligence,
                wisdom = character.skills.wisdom,
                charisma = character.skills.charisma,
            )

            (application as AppApplication).db.characterDao().insert(characterEntity)
            CharacterHolder.character = character
            val intent = Intent(this, ResumeActivity::class.java)
            intent.putExtra("characterClass", characterClass)
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

    private fun verifyIfValueIsLowerThanEight(value: Int) {
        if (value < 8) {
            Toast.makeText(this, "Value cannot be lower than 8", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Value cannot be higher than 15", Toast.LENGTH_SHORT).show()
        }
    }
}
