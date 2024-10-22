package com.example.androidautomatedtesting

import Counter
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CounterTest {

    private lateinit var counter: Counter

    @Before
    fun setUp() {
        counter = Counter()
    }

    @Test
    fun testInitialCounterValue() {
        assertEquals(0, counter.getCounter())
    }

    @Test
    fun testIncrement() {
        counter.increment()
        assertEquals(1, counter.getCounter())
    }

    @Test
    fun testDecrement() {
        counter.increment() // counter starts from 0, so we increment first
        counter.decrement()
        assertEquals(0, counter.getCounter())
    }

    @Test
    fun testMultipleIncrements() {
        counter.increment()
        counter.increment()
        counter.increment()
        assertEquals(3, counter.getCounter())
    }

    @Test
    fun testMultipleDecrements() {
        counter.increment() // increment first to avoid negative results
        counter.increment()
        counter.decrement()
        counter.decrement()
        assertEquals(0, counter.getCounter())
    }

    @Test
    fun testDecrementAfterInitialValue() {
        counter.decrement()
        assertEquals(-1, counter.getCounter())
    }
}
