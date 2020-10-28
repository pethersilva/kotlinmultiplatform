package com.pethersilva.kotlinmultiplatform.androidApp

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.pethersilva.kotlinmultiplatform.androidApp.adapter.LaunchesRvAdapter
import com.pethersilva.kotlinmultiplatform.shared.Greeting
import com.pethersilva.kotlinmultiplatform.shared.sdk.SpaceXSdk
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

	private val sdk = SpaceXSdk()
	private val mainScope = MainScope()
	private lateinit var launchesRecyclerView: RecyclerView
	private lateinit var progressBarView: FrameLayout
	private lateinit var swipeRefreshLayout: SwipeRefreshLayout
	private val launchesRvAdapter = LaunchesRvAdapter(listOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
		title = "SpaceX Launches"
        setContentView(R.layout.activity_main)

		launchesRecyclerView = findViewById(R.id.launchesListRv)
		progressBarView = findViewById(R.id.progressBar)
		swipeRefreshLayout = findViewById(R.id.swipeContainer)

		launchesRecyclerView.adapter = launchesRvAdapter
		launchesRecyclerView.layoutManager = LinearLayoutManager(this)

		swipeRefreshLayout.setOnRefreshListener {
			swipeRefreshLayout.isRefreshing = false
			displayLaunches(true)
		}
		displayLaunches(false)
    }

	override fun onDestroy() {
		super.onDestroy()
		mainScope.cancel()
	}

	private fun displayLaunches(needReload: Boolean) {
		progressBarView.isVisible = true
		mainScope.launch {
			kotlin.runCatching {
				sdk.getAll()
			}.onSuccess {
				launchesRvAdapter.launches = it
				launchesRvAdapter.notifyDataSetChanged()
			}.onFailure {
				Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
			}
			progressBarView.isVisible = false
		}
	}
}
