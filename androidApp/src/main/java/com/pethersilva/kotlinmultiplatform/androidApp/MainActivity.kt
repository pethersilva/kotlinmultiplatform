package com.pethersilva.kotlinmultiplatform.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pethersilva.kotlinmultiplatform.shared.Greeting
import android.widget.TextView
import android.widget.Toast
import com.pethersilva.kotlinmultiplatform.shared.sdk.TFVSdk
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

	private val sdk = TFVSdk()
	private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

		showTFV()
    }

	override fun onDestroy() {
		super.onDestroy()
		mainScope.cancel()
	}

	private fun showTFV() {
		mainScope.launch {

			kotlin.runCatching {
				sdk.getAll()
			}.onSuccess {
				print(it)
			}.onFailure {
				//print("ERRO: ========= ${it.message}  ==========")
				print("=============================================")
				Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
			}
		}
	}
}
