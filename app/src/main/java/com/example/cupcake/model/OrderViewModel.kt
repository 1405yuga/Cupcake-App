package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private const val PRICE_PER_CAKE = 2.0
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.0

class OrderViewModel : ViewModel() {

    private val _quantity = MutableLiveData<Int>()
    val quantity : LiveData<Int> get() =_quantity

    private val _flavor = MutableLiveData<String>()
    val flavor : LiveData<String> get() =_flavor

    private val _date = MutableLiveData<String>()
    val date : LiveData<String> get() = _date

    private val _price = MutableLiveData<Double>()
    val price : LiveData<Double> get() =_price

    fun setQuantity(noOfCupcakes : Int){
        _quantity.value = noOfCupcakes
        updatePrice()
    }

    fun setFlavor(flavorDeatils : String){
        _flavor.value = flavorDeatils
    }
    fun setDate(pickUpDate : String){
        _date.value = pickUpDate
        updatePrice()
    }

    fun hasNoFlavorSet() : Boolean{
        return _flavor.value.isNullOrEmpty()
    }

    private fun getPickUpDates() : List<String>{
        var datesList = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d",Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4){
            datesList.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE,1)
        }
        return datesList
    }
    val dateOptions = getPickUpDates()
    fun resetOrder(){
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }
    init {
        resetOrder()
    }
    private fun updatePrice(){
        var calculatedPrice= (quantity.value ?: 0)*PRICE_PER_CAKE
        if(_date.value.equals(dateOptions[0])){
            calculatedPrice+= PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = calculatedPrice

    }

}