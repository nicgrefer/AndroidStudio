package com.example.ejem10_fragmentconparametro

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun fragmentConParametro_newInstance_createsFragmentWithCorrectParameters() {
        val fragment = FragmentConParametro.newInstance("test1", "test2")
        
        assertNotNull(fragment)
        assertNotNull(fragment.arguments)
        assertEquals("test1", fragment.arguments?.getString("param1"))
        assertEquals("test2", fragment.arguments?.getString("param2"))
    }

    @Test
    fun fragmentConParametro_parametersAreSetCorrectly() {
        val fragment = FragmentConParametro.newInstance("parametro1", "parametro2")
        
        fragment.onCreate(null)
        
        assertEquals("parametro1", fragment.param1)
        assertEquals("parametro2", fragment.param2)
    }
}