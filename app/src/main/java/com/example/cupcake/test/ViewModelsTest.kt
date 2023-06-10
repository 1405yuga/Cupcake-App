package com.example.cupcake.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class ViewModelsTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_tweleve_cup(){
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {}
        viewModel.setQuantity(12)
        assertEquals(12,viewModel.quantity.value)

    }


}