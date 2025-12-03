# AndroidStudio - Kotlin

Este repositorio contiene ejemplos prácticos y teoría sobre desarrollo de aplicaciones Android con Kotlin.

## 📚 Contenido

- [Fundamentos de Kotlin](#fundamentos-de-kotlin)
- [Desarrollo Android](#desarrollo-android)
- [Proyectos de Ejemplo](#proyectos-de-ejemplo)
- [Nuevas adiciones](#nuevas-adiciones)
- [Guía rápida para estudiar](#guía-rápida-para-estudiar)

---

## Fundamentos de Kotlin

### Variables y Tipos de Datos

Kotlin distingue entre variables mutables e inmutables:

```kotlin
var nombre: String          // Variable mutable
val intNum = 10            // Variable inmutable (recomendada)
val doubleNum = 10.0       // Double
val longNum = 10L          // Long
val floatNum = 10.0F       // Float
```

### Clases y Objetos

Kotlin permite crear clases de forma concisa:

```kotlin
class Persona(val name: String = "", val age: Int = 0) {
    override fun toString(): String {
        return "Nombre persona: $name tiene $age años."
    }
    
    fun saludar(vecino: Persona) {
        println("Hola ${vecino.name} soy, ${this.name}")
    }
}

// Uso
val pedro = Persona("Pedro", 33)
val paco = Persona("Paco", 30)
pedro.saludar(paco)
```

### Data Classes

Para clases que solo contienen datos, Kotlin ofrece `data class`:

```kotlin
data class Usuario(
    val nombre: String,
    val edad: Int,
    var email: String
)
```

Las data classes generan automáticamente: `equals()`, `hashCode()`, `toString()`, `copy()`

---

## Desarrollo Android

### View Binding

View Binding proporciona acceso seguro a las vistas sin usar `findViewById`:

```kotlin
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // Acceso directo a las vistas
        binding.textView.text = "Hola Mundo"
    }
}
```

### Listeners y Eventos

Kotlin ofrece tres formas de implementar listeners:

#### 1. Clase Anónima
```kotlin
var pulsacion = object : View.OnClickListener {
    override fun onClick(v: View?) {
        Log.d("depurando", "Pulsado")
    }
}
```

#### 2. Lambda con Parámetro
```kotlin
var pulsacion = View.OnClickListener { boton ->
    Log.d("depurando", "Pulsado")
    // Acceso al View pulsado mediante 'boton'
}
```

#### 3. Lambda sin Parámetro (Más Concisa)
```kotlin
var pulsacion = View.OnClickListener {
    Log.d("depurando", "Pulsado")
}

binding.button.setOnClickListener(pulsacion)
```

### Touch Listeners

Manejo de eventos táctiles para gestos personalizados:

```kotlin
binding.llFondo.setOnTouchListener { view, evento ->
    when (evento.action) {
        MotionEvent.ACTION_DOWN -> {
            valorXInicial = evento.x
        }
        MotionEvent.ACTION_UP -> {
            valorXFinal = evento.x
            val diferencia = valorXFinal - valorXInicial
            Toast.makeText(this, "Swipe: $diferencia px", Toast.LENGTH_SHORT).show()
        }
    }
    true  // true = consume el evento, false = propaga al padre
}
```

### Toast y Snackbar

Mensajes al usuario:

```kotlin
// Toast - mensaje simple
Toast.makeText(this, "Actividad creada", Toast.LENGTH_SHORT).show()

// Snackbar - con opciones de acción
Snackbar.make(binding.llFondo, "Actividad creada", Snackbar.LENGTH_SHORT).show()
```

### ArrayAdapter y ListView

Mostrar listas de datos:

```kotlin
// Lista mutable de datos
val listaDatos = mutableListOf<String>("Elemento 1", "Elemento 2", "Elemento 3")

// Crear adaptador
var adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos)
binding.lvNombres.adapter = adaptador

// Añadir elementos
(binding.lvNombres.adapter as ArrayAdapter<String>).add("Nuevo elemento")
```

### Logging

Depuración con Logcat:

```kotlin
Log.d("depurando", "Mensaje de depuración")
Log.e("error", "Mensaje de error")
Log.i("info", "Mensaje informativo")
```

---

## Proyectos de Ejemplo

### 📁 Ejem02_ConstraintLayout
- Uso de ConstraintLayout
- Implementación de múltiples tipos de listeners
- ArrayAdapter y ListView
- View Binding

### 📁 ejem03_TouchListener
- Manejo de eventos táctiles (OnTouchListener)
- Detección de gestos swipe
- Propagación de eventos entre vistas
- Toast y Snackbar

### 📁 Ejem04_VistasEnEjecucion
- Creación dinámica de vistas
- GridLayout y TableLayout
- Manipulación de layouts en tiempo de ejecución

### 📁 Ejem05_RecyclerView
- RecyclerView para listas eficientes
- Data classes (Usuario)
- Adaptadores personalizados

### 📁 Ejer1_Calculadora
- App calculadora completa
- Manejo de estado (operador, números)
- Event handlers para múltiples botones
- Uso de `when` para operaciones

---

## Nuevas adiciones (detectadas en el repositorio)

- Kotlin_Cheat_Sheet.pdf  
  Hoja de referencia rápida con sintaxis y ejemplos comunes de Kotlin. Útil para consultas rápidas mientras programas.

- Ejercicios 2025-26.pdf  
  Colección de ejercicios y prácticas para reforzar los temas vistos en clase. Recomendado imprimir o abrir en paralelo.

- EnunciadoEjercicioDelEjemplo6.txt  
  Enunciado concreto del ejercicio 6: abrir este archivo para ver los requisitos, pasos y criterios de entrega del ejercicio.

- Carpeta protyectos/  
  Contiene proyectos adicionales o material complementario. Observa que el nombre tiene un posible error tipográfico ("protyectos") — no cambiar el nombre sin confirmar, pero revisa su contenido para más ejemplos.

- .gitignore y .idea (configuración)  
  Archivos de configuración/IDE; no contienen código didáctico, puedes ignorarlos al estudiar.

---

## Guía rápida para estudiar

Orden recomendado para revisar el material (rápido y práctico):

1. Lee el apartado "Fundamentos de Kotlin" para repasar tipos, clases y data classes.
2. Abre Kotlin_Cheat_Sheet.pdf para tener una referencia rápida mientras practicas.
3. Revisa "Desarrollo Android" (View Binding, listeners, touch) y prueba los snippets en Android Studio.
4. Abre los proyectos de ejemplo en la carpeta raíz (Ejem02_ConstraintLayout, ejem03_TouchListener, etc.) en el orden listado:
   - Ejecuta cada proyecto en emulador/dispositivo y prueba las funcionalidades.
5. Lee EnunciadoEjercicioDelEjemplo6.txt cuando llegues al ejercicio 6 para conocer los requisitos exactos.
6. Trabaja los ejercicios de Ejercicios 2025-26.pdf; intenta implementarlos y compara con los ejemplos del repositorio.
7. Explora protyectos/ para material adicional o proyectos de apoyo.

Sugerencia práctica: crea una copia del proyecto de ejemplo, modifica pequeñas cosas (colores, textos, listeners) y observa cómo cambian las respuestas en la app. Eso ayuda a entender qué hace cada bloque de código.

---

## 🚀 Cómo Empezar

1. Clona este repositorio
2. Abre los proyectos en Android Studio
3. Sincroniza Gradle
4. Ejecuta en emulador o dispositivo físico

## 📖 Recursos Adicionales

- [Kotlin Cheat Sheet](Kotlin_Cheat_Sheet.pdf)
- [Ejercicios 2025-26](Ejercicios%202025-26.pdf)
- [Documentación oficial de Kotlin](https://kotlinlang.org/docs/home.html)
- [Guía de desarrollo Android](https://developer.android.com/kotlin)

---

## Ejemplo Básico Inicial

```kotlin
fun main() {
    println("Hello, world!!!")
    var nombre: String
    
    val intNum = 10
    val doubleNum = 10.0
    val longNum = 10L
    val floatNum = 10.0F
    
    println(intNum)
    
    val pedro = Persona("Pedro", 33)
    val paco = Persona("Paco", 30)
    println(pedro)
    pedro.saludar(paco)
}

class Persona(val name: String = "", val age: Int = 0) {
    override fun toString(): String {
        return "Nombre persona: $name tiene $age años."
    }
    
    fun saludar(vecino: Persona) {
        println("Hola ${vecino.name} soy, ${this.name}")
    }
}
```
