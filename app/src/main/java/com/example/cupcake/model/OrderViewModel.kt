package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>(0)
    val quantity : LiveData<Int> get() =_quantity

    private val _flavor = MutableLiveData<String>()
    val flavor : LiveData<String> get() =_flavor

    private val _date = MutableLiveData<String>()
    val date : LiveData<String> get() = _date

    private val _price = MutableLiveData<Double>(0.0)
    val price : LiveData<Double> get() =_price

    fun setQuantity(noOfCupcakes : Int){
        _quantity.value = noOfCupcakes
    }

    fun setFlavor(flavorDeatils : String){
        _flavor.value = flavorDeatils
    }
    fun setDate(pickUpDate : String){
        _date.value = pickUpDate
    }

    fun hasNoFlavorSet() : Boolean{
        return _flavor.value.isNullOrEmpty()
    }

}