package com.example.rpg

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import org.example.builder.Characterbuilder
import org.example.entities.Character

class MainActivity : ComponentActivity() {

    // Declaração de variáveis para componentes da interface do usuário.
    private lateinit var name: EditText  // Campo de entrada para o nome do personagem
    private lateinit var spClass: Spinner  // Spinner para seleção de classe do personagem
    private lateinit var spBreed: Spinner  // Spinner para seleção de raça do personagem
    private lateinit var btnStart: Button  // Botão para iniciar a próxima atividade

    //Variavel que armazena a posição de cada raça no spinner
    private var breedPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)  // Define o layout da atividade

        // Método para inicializar componentes da interface
        initializeUI()

        // Configuração dos spinners com dados e comportamentos
        setupSpinner(spClass, R.array.sp_class_options)  // Configura spinner de classes
        setupSpinner(spBreed, R.array.sp_breed_options)  // Configura spinner de raças

        // Método para configurar o botão de início
        setupStartButton()

    }

    // Inicializa componentes da UI, vinculando-os com seus IDs no layout XML
    private fun initializeUI() {
        name = findViewById(R.id.et_name)
        spClass = findViewById(R.id.sp_class)
        spBreed = findViewById(R.id.sp_breed)
        btnStart = findViewById(R.id.btn_start)
    }

    // Configura um spinner específico com um array de recursos e comportamento de seleção
    private fun setupSpinner(spinner: Spinner, arrayResourceId: Int) {
        ArrayAdapter.createFromResource(
            this,
            arrayResourceId,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter  // Define o adaptador do spinner
        }

        // Define o comportamento quando um item do spinner é selecionado
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                breedPosition = position
                Toast.makeText(this@MainActivity, selectedItem, Toast.LENGTH_SHORT)
                    .show()  // Exibe um Toast com o item selecionado
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Este método é chamado quando a seleção é removida de um item. Não há ação definida aqui.
            }
        }
    }

    // Configura o botão de início para iniciar a segunda atividade ao ser clicado
    private fun setupStartButton() {
        btnStart.setOnClickListener {
            val selectedClass = spClass.selectedItemPosition
            if (name.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    "You must input a name to proceed",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (spBreed.selectedItemPosition == 0) {

                Toast.makeText(
                    this,
                    "You must select a breed and class to proceed",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }


            // Cria um intent para a segunda atividade
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("characterName", name.text.toString())
            intent.putExtra("characterBreed", breedPosition)
            intent.putExtra("characterClass", Characterbuilder.selectClass(selectedClass))
            startActivity(intent)  // Inicia a segunda atividade
        }
    }

}
