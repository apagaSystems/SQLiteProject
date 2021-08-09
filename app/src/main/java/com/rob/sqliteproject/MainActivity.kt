package com.rob.sqliteproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rob.sqliteproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val dbManager = SQLManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val views = binding.root
        setContentView(views)
    }

    fun onClickSave(view: View) {
        binding.textView2.text=""
        dbManager.openDB()
        dbManager.insertDB(binding.edName.text.toString(), binding.edSurname.text.toString())
        val datalist = dbManager.selectDB()
        for (item in datalist){
            binding.textView2.append(item)
            binding.textView2.append("\n")
        }
    }
}