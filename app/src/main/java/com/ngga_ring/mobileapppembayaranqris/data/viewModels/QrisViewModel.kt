package com.ngga_ring.mobileapppembayaranqris.data.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngga_ring.mobileapppembayaranqris.data.models.QrisScanModels
import com.ngga_ring.mobileapppembayaranqris.data.models.Resource
import com.ngga_ring.mobileapppembayaranqris.data.repository.QrisRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QrisViewModel @Inject constructor(private val userRepository: QrisRepository) : ViewModel() {


    fun saveData(data: QrisScanModels): MutableLiveData<Resource<List<QrisScanModels>>> {
        val dataResult = MutableLiveData<Resource<List<QrisScanModels>>>()
        viewModelScope.launch {
            try {
                userRepository.insertTras(data)
                val result =userRepository.getData()
                dataResult.value = Resource.success(result)
            } catch (e: Exception) {
                val errorMessage = e.localizedMessage ?: "Unknown error occurred"
                dataResult.value = Resource.error(errorMessage)
            }
        }
        return dataResult
    }

     fun getData(): MutableLiveData<Resource<List<QrisScanModels>>> {
        val dataResult = MutableLiveData<Resource<List<QrisScanModels>>>()
        viewModelScope.launch {
            try {
                val result =userRepository.getData()
                dataResult.value = Resource.success(result)
            } catch (e: Exception) {
                val errorMessage = e.localizedMessage ?: "Unknown error occurred"
                dataResult.value = Resource.error(errorMessage)
            }
        }
        return dataResult
    }



}