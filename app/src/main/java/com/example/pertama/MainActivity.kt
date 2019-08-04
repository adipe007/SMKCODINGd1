package com.example.pertama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var edtname : EditText? = null
    var kelamin : Spinner? = null
    var edtemail : EditText? = null
    var edttelfon : EditText? = null
    var edtalamat : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtname = findViewById(R.id.nama)
        kelamin = findViewById(R.id.spinner)
        edtemail = findViewById(R.id.email)
        edttelfon = findViewById(R.id.telfon)
        edtalamat = findViewById(R.id.alamat)

        setDateSpinner()
        buttonsave.setOnClickListener {
            validasiInput()
        }
    }

    fun setDateSpinner(){
        val adapter  = ArrayAdapter.createFromResource(this, R.array.apapun,android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = adapter
    }


    fun validasiInput() {
        val namaInput: String = edtname?.text.toString()
        val emailInput: String = edtemail?.text.toString()
        val telfonInput: String = edttelfon?.text.toString()
        val alamatInput: String = edtalamat?.text.toString()
        val iyalahInput: String = kelamin?.selectedItem.toString()

        when {

        iyalahInput.equals("Pilih jenis kelamin") ->
            Toast.makeText(this, "DI ISI DULU DONG", Toast.LENGTH_SHORT)
                .show()

        namaInput.isEmpty() -> edtname?.error = "Tidak Boleh Di kosongi"
        emailInput.isEmpty() -> edtemail?.error = "Tidak Boleh Di kosongi"
        telfonInput.isEmpty() -> edttelfon?.error = "Tidak Boleh Di kosongi"
        alamatInput.isEmpty() -> edtalamat?.error = "Tidak Boleh Di kosongi"

        else -> {
            Toast.makeText(this, "BERHASIL DONG", Toast.LENGTH_SHORT)
                .show()
        }

    }

    }


}
