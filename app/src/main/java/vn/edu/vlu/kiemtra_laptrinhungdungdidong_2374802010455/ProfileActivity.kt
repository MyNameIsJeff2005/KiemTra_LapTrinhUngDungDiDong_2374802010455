package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2374802010455

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
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

        // Ánh xạ View bằng findViewById (KHÔNG dùng ViewBinding)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        // 3.2 Ánh xạ ListView
        val lvSubjects = findViewById<ListView>(R.id.lvSubjects)

        // Trích xuất Email được truyền từ LoginActivity và hiển thị
        val email = intent.getStringExtra(EXTRA_EMAIL) ?: ""
        tvEmail.text = "Email: $email"

        // Đăng xuất: đóng màn hình hiện tại, quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }

        // 3.3 Dữ liệu mẫu: danh sách môn học/kỹ năng (>= 5 phần tử)
        val subjects = listOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // 3.4 Gắn ArrayAdapter với layout mẫu simple_list_item_1 để đổ dữ liệu lên ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // 3.5 Bắt sự kiện click: hiển thị Toast đúng tên phần tử được chọn
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, subjects[position], Toast.LENGTH_SHORT).show()
        }
    }
}