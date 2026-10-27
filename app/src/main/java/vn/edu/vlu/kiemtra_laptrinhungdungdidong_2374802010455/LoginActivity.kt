package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2374802010455

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Áp dụng lề để không bị thanh trạng thái che phủ
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginRoot)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ánh xạ View bằng findViewById truyền thống (KHÔNG dùng ViewBinding)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        // Bắt sự kiện click nút Đăng nhập
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // Mặc định hiển thị màu đỏ cho thông báo lỗi
            tvStatus.setTextColor(Color.RED)

            // 1. Bỏ trống Email hoặc Mật khẩu
            if (email.isEmpty() && password.isEmpty()) {
                tvStatus.text = "LỖI: Email và Mật khẩu không được để trống!"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                tvStatus.text = "LỖI: Email không được để trống!"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                tvStatus.text = "LỖI: Mật khẩu không được để trống!"
                return@setOnClickListener
            }

            // 2. Email sai định dạng
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.text = "LỖI: Email sai định dạng (vd: ten@gmail.com)!"
                return@setOnClickListener
            }

            // 3. Mật khẩu dưới 6 ký tự
            if (password.length < 6) {
                tvStatus.text = "LỖI: Mật khẩu phải có ít nhất 6 ký tự!"
                return@setOnClickListener
            }

            // 4. Dữ liệu hoàn toàn hợp lệ
            tvStatus.setTextColor(Color.parseColor("#2E7D32"))
            tvStatus.text = "Xác thực thành công!"
        }
    }
}