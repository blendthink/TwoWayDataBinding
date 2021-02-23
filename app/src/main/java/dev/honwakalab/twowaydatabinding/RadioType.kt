package dev.honwakalab.twowaydatabinding

import androidx.annotation.IdRes
import androidx.annotation.IntDef
import androidx.databinding.InverseMethod

enum class RadioType {
    Upper,
    Under,
}

@IntDef(
    RADIO_BUTTON_ID_UPPER,
    RADIO_BUTTON_ID_UNDER,
)
annotation class RadioButtonId

@IdRes
private const val RADIO_BUTTON_ID_UPPER = R.id.radioButtonUpper

@IdRes
private const val RADIO_BUTTON_ID_UNDER = R.id.radioButtonUnder

object RadioTypeConverter {

    @RadioButtonId
    @InverseMethod("toType")
    @JvmStatic
    fun toButtonId(radioType: RadioType?): Int {
        return when (radioType) {
            RadioType.Upper, null -> RADIO_BUTTON_ID_UPPER
            RadioType.Under -> RADIO_BUTTON_ID_UNDER
        }
    }

    @JvmStatic
    fun toType(@RadioButtonId selectedButtonId: Int): RadioType {
        return when (selectedButtonId) {
            RADIO_BUTTON_ID_UPPER -> RadioType.Upper
            RADIO_BUTTON_ID_UNDER -> RadioType.Under
            else -> throw IllegalArgumentException()
        }
    }
}

