package com.gnova.hotels.ui

import org.junit.Assert.*
import org.junit.Test

class NumberExtensionFunctionsKtTest {

    @Test
    fun `GIVEN one decimal place double WHEN toPriceAmount THEN return string with 2 decimal places`() {
        //GIVEN
        val number: Double = 19.5

        // WHEN
        val result = number.toPriceAmount()

        //THEN
        assertEquals(result, "19.50")
    }

    @Test
    fun `GIVEN two decimal place double WHEN toPriceAmount THEN return string with 2 decimal places`() {
        //GIVEN
        val number: Double = 19.50

        // WHEN
        val result = number.toPriceAmount()

        //THEN
        assertEquals(result, "19.50")
    }

    @Test
    fun `GIVEN string with two zeros after decimal place WHEN noZeros() THEN return string with no decimal places`() {
        //GIVEN
        val number: String = "19.00"

        // WHEN
        val result = number.noZeros()

        //THEN
        assertEquals(result, "19")
    }


}


