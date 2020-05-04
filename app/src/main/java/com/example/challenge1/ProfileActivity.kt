package com.example.challenge1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class
ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ambilData()
    }

    private fun ambilData() {
        val bundle = intent.extras

        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")

        txtName.text = nama
        txtGender.text = gender
        txtEmail.text = email
        txtTelp.text = telp
        txtAddress.text = alamat
    }
}

