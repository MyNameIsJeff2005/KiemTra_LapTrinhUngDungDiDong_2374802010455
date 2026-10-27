package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2374802010455

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    companion object {
        // Khóa dùng chung để truyền/nhận Email qua Intent
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        // Áp dụng lề để không bị thanh trạng thái che phủ
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profileRoot)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2.2 Ánh xạ View bằng findViewById (KHÔNG dùng ViewBinding)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // 2.4 Trích xuất Email được truyền từ LoginActivity và hiển thị lên TextView
        val email = intent.getStringExtra(EXTRA_EMAIL) ?: ""
        tvEmail.text = "Email: $email"

        // 2.5 Đăng xuất: đóng màn hình hiện tại, quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}