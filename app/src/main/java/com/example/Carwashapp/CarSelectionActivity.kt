package com.example.Carwashapp

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.Carwashapp.databinding.ActivityCarselectBinding // Import the generated binding class
import com.example.Carwashapp.Datetimeselect

class CarSelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarselectBinding // Declare a binding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarselectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectDateTimeButton.setOnClickListener {
            if (isCarSelected()) {
                val intent = Intent(this, Datetimeselect::class.java)
                startActivity(intent)
            } else {
                showError("Lütfen bir araç seçin.")
            }
        }
    }

    private fun isCarSelected(): Boolean {
        val carCheckBox1: CheckBox = findViewById(R.id.checkBox1)
        val carCheckBox2: CheckBox = findViewById(R.id.checkBox2)

        // CheckBox'ların durumunu kontrol edin
        val isCar1Selected = carCheckBox1.isChecked
        val isCar2Selected = carCheckBox2.isChecked

        // En az bir araç seçildiyse true döndürün
        return isCar1Selected || isCar2Selected
    }

    private fun showError(message: String) {
        // Hata mesajını kullanıcıya göstermek için burada bir mekanizma kullanın.
        // Örneğin, bir AlertDialog, Toast veya Snackbar kullanabilirsiniz.
        // showMessageDialog(message) şeklinde bir örnek kullanıyorum.
        showMessageDialog(message)
    }

    private fun showMessageDialog(message: String) {
        // Hata mesajını AlertDialog ile göstermek için burada bir kod ekleyin.
        // Örnek olarak aşağıdaki gibi bir AlertDialog kullanıyorum.
        val dialog = AlertDialog.Builder(this)
            .setTitle("Hata")
            .setMessage(message)
            .setPositiveButton("Tamam", null)
            .create()

        dialog.show()
    }
}
