package com.example.formulirskripsi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import data.DataFrm
import data.com.example.formulirskripsi.Source
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SkripsiViewModel : ViewModel() {
    var nama : String by mutableStateOf( "")
        private set
    var nim : String by mutableStateOf( "")
        private set
    var judul : String by mutableStateOf( "")
        private set
    private val _uiState = MutableStateFlow(DataFrm())
    val uiState: StateFlow<DataFrm> = _uiState.asStateFlow()

    fun BacaData(nm:String,ni:String, jd:String){
        nama=nm;
        nim=ni;
        judul=jd;
    }
}
