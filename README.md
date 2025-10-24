# AndroidStudio

## Ejemplos 1 dia 

``` Kotlin
/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
        println("Hello, world!!!")
    var nombre:String
    
    val intNum = 10
    val doubleNum = 10.0
    val longNum = 10L
    val floatNum = 10.0F
    
    println(intNum)
    
        
    val pedro = Persona ("Pedro",33)
    val paco = Persona ("Paco",30)
    println(pedro)
    pedro.saludar(paco)
    
}
class Persona (val name: String = "", val age: Int = 0){
    override fun toString():String{
        return "Nombre persona: "+ name +" tiene "+ age +" años."
    }
    
    fun saludar (vecino: Persona){
        println("Hola " + vecino.name + " soy, "+ this.name)
    }
    
}


```