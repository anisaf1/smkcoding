package com.example.challenge1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")

        editNamaProfil.setText(namaUser)
        btnEditSimpan.setOnClickListener { simpanData() }
    }

    private fun simpanData() {
        val namaEdit = editNamaProfil.text.toString()
        if (!namaEdit.isEmpty()) {
            val result = Intent()

            result.putExtra("nama", namaEdit)

            setResult(Activity.RESULT_OK, result)

        }else {
            setResult(Activity.RESULT_CANCELED)
        }

        finish()
    }
}
