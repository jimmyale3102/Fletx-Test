package dev.alejo.fletxtest.app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alejo.fletxtest.app.model.VehicleResponse
import dev.alejo.fletxtest.app.network.VehicleService
import kotlinx.coroutines.launch

class VehicleViewModel: ViewModel() {

    val responseModel = MutableLiveData<VehicleResponse>()
    val isLoading = MutableLiveData<Boolean>()

    var vehicleService = VehicleService()

    fun onCreate() {
        viewModelScope.launch {
            val result = vehicleService.getVehicles()

            responseModel.postValue(result)
            //isLoading.postValue(false)
        }
    }

    /*fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }*/

}