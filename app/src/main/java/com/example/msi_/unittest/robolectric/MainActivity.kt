package com.example.msi_.unittest.robolectric

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.msi_.unittest.R

class MainActivity : AppCompatActivity() {

    var lifecycleState:String? = null
    private lateinit var cbTest:CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleState = "onCreate"
        setContentView(R.layout.activity_main)
        cbTest = findViewById(R.id.cb_test)
    }

    override fun onStart() {
        super.onStart()
        lifecycleState = "onStart"
    }

    override fun onResume() {
        super.onResume()
        lifecycleState = "onResume"
    }

    override fun onPause() {
        super.onPause()
        lifecycleState = "onPause"
    }

    override fun onStop() {
        super.onStop()
        lifecycleState = "onStop"
    }

    override fun onRestart() {
        super.onRestart()
        lifecycleState = "onRestart"
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleState = "onDestroy"
    }

    fun jump(view:View){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    fun showToast(view:View){
        Toast.makeText(this,"Toast test",Toast.LENGTH_SHORT).show()
    }

    fun showDialog(view:View){
        val dialog = android.app.AlertDialog.Builder(this)
                .setMessage("Hello World")
                .setTitle("提示")
                .create()
        dialog.show()
    }

    fun inverse(view:View){
        cbTest.isChecked = !cbTest.isChecked
    }
}
