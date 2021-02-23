package dev.honwakalab.twowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dev.honwakalab.twowaydatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = MainViewModel()

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).also { binding ->
            binding.lifecycleOwner = this
            binding.model = viewModel
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.selectedRadioType.value = RadioType.Under
    }
}
