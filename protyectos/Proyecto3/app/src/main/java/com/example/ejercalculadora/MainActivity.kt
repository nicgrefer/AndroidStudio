package com.example.ejercalculadora

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.ejercalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    // Variables para gestionar el estado de la calculadora
    private var firstNumber: Double = 0.0
    private var currentNumber: String = ""
    private var operation: String = ""
    // Nueva variable para controlar si la siguiente entrada de número debe iniciar un nuevo número
    private var isNewOperation: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCalculator()
    }

    private fun setupCalculator() {
        // Inicializa la pantalla
        binding.tvSoluciones.text = "0"
        isNewOperation = true // Al inicio, cualquier número inicia una nueva entrada

        // --- Configuración de los Listeners para los botones ---

        // Números

        binding.btt1.setOnClickListener { appendNumber("1") }
        binding.btt2.setOnClickListener { appendNumber("2") }
        binding.btt3.setOnClickListener { appendNumber("3") }
        binding.btt4.setOnClickListener { appendNumber("4") }
        binding.btt5.setOnClickListener { appendNumber("5") }
        binding.btt6.setOnClickListener { appendNumber("6") }
        binding.btt7.setOnClickListener { appendNumber("7") }
        binding.btt8.setOnClickListener { appendNumber("8") }
        binding.btt9.setOnClickListener { appendNumber("9") }

        // Operaciones
        binding.bttSum.setOnClickListener { setOperation("+") }
        binding.bttMin.setOnClickListener { setOperation("-") }

        // Calcular
        binding.bttCalc.setOnClickListener { calculate() }

        // Borrar
        binding.bttEliminar.setOnClickListener { clear() }
    }

    private fun appendNumber(number: String) {
        // Si es una nueva operación, el número actual se reinicia
        if (isNewOperation) {
            currentNumber = ""
            isNewOperation = false
        }

        // Evita empezar con múltiples ceros, pero permite un solo cero inicial
        if (currentNumber == "0" && number == "0") return
        if (currentNumber == "0" && number != "0") {
            currentNumber = ""
        }

        currentNumber += number
        binding.tvSoluciones.text = currentNumber
    }

    private fun setOperation(op: String) {
        // Si hay un número en pantalla, lo usamos para la operación
        // CAMBIO: Se comprueba que currentNumber no esté vacío para evitar errores
        if (currentNumber.isNotEmpty()) {
            // Si ya hay una operación pendiente, la resolvemos primero
            if (!isNewOperation) {
                calculate()
            }

            firstNumber = binding.tvSoluciones.text.toString().toDoubleOrNull() ?: 0.0
            operation = op
            isNewOperation = true // Prepara para que el siguiente número sea una nueva entrada
        }
    }

    private fun calculate() {
        // Solo calcula si hay una operación, un número previo y un número nuevo
        if (operation.isNotEmpty() && !isNewOperation && currentNumber.isNotEmpty()) {
            val secondNumber = currentNumber.toDouble()
            val result = when (operation) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                else -> secondNumber // Caso por defecto, aunque no debería ocurrir
            }

            // Usamos formatResult para mostrar enteros sin ".0"
            binding.tvSoluciones.text = formatResult(result)
            firstNumber = result // Guarda el resultado para operaciones encadenadas
            isNewOperation = true
            operation = "" // Limpia la operación después de pulsar '='
        }
    }

    private fun clear() {
        firstNumber = 0.0
        currentNumber = ""
        operation = ""
        binding.tvSoluciones.text = "0"
        isNewOperation = true
    }

    // Función auxiliar para mostrar números enteros sin decimales
    private fun formatResult(result: Double): String {
        // Comprueba si el número es esencialmente un entero
        return if (result % 1.0 == 0.0) {
            result.toLong().toString() // Si es un entero, muestra como Long (ej: "8")
        } else {
            result.toString() // Si tiene decimales, muestra como Double (ej: "8.5")
        }
    }
}
