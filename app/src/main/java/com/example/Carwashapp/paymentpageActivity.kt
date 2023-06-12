package com.example.Carwashapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class paymentpageActivity : AppCompatActivity() {

    private lateinit var paymentMethodSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paymentpage)

        paymentMethodSpinner = findViewById(R.id.paymentMethodSpinner)

        // Spinner için veri kaynağı oluşturma
        val paymentMethods = arrayOf("Kredi Kartı", "Banka Kartı")

        // ArrayAdapter kullanarak spinner'a veri kaynağını bağlama
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, paymentMethods)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        paymentMethodSpinner.adapter = adapter

        // Spinner'da seçim değiştiğinde çalışacak işlemi belirleme
        paymentMethodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Seçilen ödeme yöntemini al
                val selectedPaymentMethod = parent.getItemAtPosition(position).toString()

                // Seçilen ödeme yöntemini işleme geçirme
                // Örneğin, seçilen ödeme yöntemine göre ilgili işlemleri gerçekleştirme
                // Bu kısımda istediğiniz işlemleri yapabilirsiniz
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Hiçbir öğe seçilmediğinde yapılacak işlemleri buraya yazabilirsiniz
            }
        }

        // Ödeme tamamla butonuna tıklama işlemi
        val payButton: Button = findViewById(R.id.payButton)
        payButton.setOnClickListener {
            // Öğelerin değerlerini al
            val selectedPaymentMethod = paymentMethodSpinner.selectedItem.toString()
            val username = findViewById<EditText>(R.id.cardHolderNameEditText).text.toString()
            val cardNumber = findViewById<EditText>(R.id.cardNumberEditText).text.toString()
            val expirationDate = findViewById<EditText>(R.id.expiryDateEditText).text.toString()
            val cvv = findViewById<EditText>(R.id.cvvEditText).text.toString()

            // Boş alan kontrolü
            if (selectedPaymentMethod.isEmpty() || username.isEmpty() || cardNumber.isEmpty() ||
                expirationDate.isEmpty() || cvv.isEmpty()) {
                Toast.makeText(this, "Lütfen boş alanları doldurunuz.", Toast.LENGTH_SHORT).show()
            } else {
                // Tüm alanlar dolu ise anasayfaya yönlendirme işlemi
                val intent = Intent(this, Homepage::class.java)
                startActivity(intent)
            }
        }
    }

}