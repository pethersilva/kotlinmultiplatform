package com.pethersilva.kotlinmultiplatform.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pethersilva.kotlinmultiplatform.shared.Greeting
import android.widget.TextView
import android.widget.Toast
import com.pethersilva.kotlinmultiplatform.shared.sdk.SpaceXSdk
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

	private val sdk = SpaceXSdk()
	private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
		showRocket()
    }

	override fun onDestroy() {
		super.onDestroy()
		mainScope.cancel()
	}

	private fun showRocket() {
		mainScope.launch {
			kotlin.runCatching {
				sdk.getAll()
			}.onSuccess {
				print(it)
			}.onFailure {
				Log.d("PJS", "ERRO: ========= ${it.message}  ==========", it)
				print("=============================================")
				Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
			}
		}
	}
}
