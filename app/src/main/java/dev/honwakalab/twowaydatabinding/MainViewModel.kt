package dev.honwakalab.twowaydatabinding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel : ViewModel() {

    val selectedRadioType = MutableLiveData<RadioType>()

    private val _text = selectedRadioType.map {
        val text = when (it) {
            RadioType.Upper -> RadioType.Upper.name
            RadioType.Under -> RadioType.Under.name
            null -> throw IllegalArgumentException()
        }
        Log.d("Selected", text)
        return@map text
    }
    val text: LiveData<String> = _text
}
