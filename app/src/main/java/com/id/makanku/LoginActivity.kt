package com.id.makanku

import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources

class LoginActivity : AppCompatActivity() {

    private var isPasswordVisible = false  // default: password tertutup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val btnMahasiswa = findViewById<TextView>(R.id.btnMahasiswa)
        val btnUmkm = findViewById<TextView>(R.id.btnUmkm)

        // ============================
        // 1. SET ICON MATA DEFAULT
        // ============================
        password.setCompoundDrawablesWithIntrinsicBounds(
            null, null,
            AppCompatResources.getDrawable(this, R.drawable.baseline_visibility_24),
            null
        )

        // =================================
        // 2. TOGGLE SHOW/HIDE PASSWORD
        // =================================
        password.setOnTouchListener { _, event ->
            val drawableEnd = 2  // posisi drawable kanan

            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (password.right - password.compoundDrawables[drawableEnd].bounds.width())) {

                    isPasswordVisible = !isPasswordVisible

                    if (isPasswordVisible) {
                        // Tampilkan password
                        password.inputType =
                            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

                        // Ganti ke icon mata tertutup
                        password.setCompoundDrawablesWithIntrinsicBounds(
                            null, null,
                            AppCompatResources.getDrawable(this, R.drawable.baseline_visibility_off_24),
                            null
                        )

                    } else {
                        // Sembunyikan password
                        password.inputType =
                            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                        // Ganti icon jadi mata terbuka
                        password.setCompoundDrawablesWithIntrinsicBounds(
                            null, null,
                            AppCompatResources.getDrawable(this, R.drawable.baseline_visibility_24),
                            null
                        )
                    }

                    // Biar cursor tetap di akhir
                    password.setSelection(password.text.length)

                    return@setOnTouchListener true
                }
            }
            false
        }

        // =================================
        // 3. SEGMENT BUTTON MAHASISWA / UMKM
        // =================================
        btnMahasiswa.setOnClickListener {
            btnMahasiswa.setBackgroundResource(R.drawable.bg_segment_selected)
            btnMahasiswa.setTextColor(resources.getColor(android.R.color.black))

            btnUmkm.setBackgroundResource(android.R.color.transparent)
            btnUmkm.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        btnUmkm.setOnClickListener {
            btnUmkm.setBackgroundResource(R.drawable.bg_segment_selected)
            btnUmkm.setTextColor(resources.getColor(android.R.color.black))

            btnMahasiswa.setBackgroundResource(android.R.color.transparent)
            btnMahasiswa.setTextColor(resources.getColor(android.R.color.darker_gray))
        }
    }
}
