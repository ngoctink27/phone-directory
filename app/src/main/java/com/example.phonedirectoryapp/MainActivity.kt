package com.example.phonedirectoryapp

import User
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail_recycle.MyAdapter
import com.example.phonedirectoryapp.ui.theme.PhoneBookTheme
import java.util.*
import android.view.*

val userList = listOf(
    User(1, "The Ngoc", "8334339001", "ntnk27@gmail.com"),
    User(2, "Linh Linh", "2843874002", "linh.nl@gmail.com"),
    User(3, "Nhat Thien", "12942724878", "thiennhat@gmail.com"),
    User(4, "Tien Tung", "2982897424", "tungnt@gmail.com"),
    User(5, "Nam Duong", "187131818", "duongtn@gmail.com"),
    User(6, "Quoc Khanh", "013119191", "khanhq@gmail.com"),
    User(7, "Khanh Linh", "13113818", "khanhlinh@gmail.com"),
    User(8, "Tuan Ah", "48292982", "anhtuann@gmail.com"),
    User(9, "Duy", "924299892", "duydh@gmail.com"),
    User(10, "Linh", "24292829", "linhhoang@gmail.com"),
    User(11, "Hoang", "249282898", "hoangnt@gmail.com"),
    User(12, "Tuyen", "24227827", "justify@gmail.com"),
    User(13, "Huyen", "22727272", "nnh0402@gmail.com"),
    User(14, "Nam", "227827278", "namcao@gmail.com"),
    User(15, "Chi", "292922292", "ninhchi@gmail.com"),
    User(16, "Ngoc A", "9829829", "ngocpro22@gmail.com"),
    User(17, "The Anh", "022992224", "theanh96@gmail.com"),
    User(18, "Do mixi", "202042202", "mixi@gmail.com"),
    User(19, "Nam Hai", "1000239292", "hai0101@gmail.com"),
    User(20, "PaPa", "022229222", "ntn@gmail.com")
)

class MainActivity : ComponentActivity() {

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter(userList)
        rv.adapter = myAdapter
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val clickedUser = myAdapter.getClickedUser()
        Log.d("TAG", clickedUser.toString())
        return when (item.itemId) {
            R.id.action_call -> {
                Log.d("TAG", "Call " + clickedUser?.getUserPhone())
                Toast.makeText(this@MainActivity, "Call " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_message -> {
                Log.v("TAG", "Send message to " + clickedUser?.getUserPhone())
                Toast.makeText(this, "Send message to " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_email -> {
                Log.v("TAG", "Send email to " + clickedUser?.getUserEmail())
                Toast.makeText(this, "Send email to " + clickedUser?.getUserEmail(), Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}

