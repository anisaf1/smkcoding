package com.example.challenge1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var namaInput : String = ""
    private var emailInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""
    private var genderInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()
        btnSave.setOnClickListener { validasiInput() }

    }

    private fun goToProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)

        val bundle = Bundle()
        bundle.putString("nama", namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)

        intent.putExtras(bundle)

        startActivity(intent)
    }

    private fun validasiInput() {
        namaInput = editNama.text.toString()
        emailInput = editEmail.text.toString()
        telpInput = editTelp.text.toString()
        alamatInput = editAddress.text.toString()
        genderInput = spinnerGender.selectedItem.toString()

        when {
            namaInput.isEmpty() -> editNama.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin", ignoreCase = true) ->
                tampilToast("Jenis kelamin harus dipilih")
            emailInput.isEmpty() -> editEmail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> editTelp.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> editAddress.error = "Alamat tidak boleh kosong"

            else -> {
                tampilToast("Navigasi ke halaman profile")
                goToProfileActivity()
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast .makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }
}
