package com.pethersilva.kotlinmultiplatform.shared.network

import com.pethersilva.kotlinmultiplatform.shared.entity.RocketLaunch
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class SpaceXApi {

	private val httpClient = HttpClient {
		install(JsonFeature) {
			val json = Json { ignoreUnknownKeys = true
				isLenient = false
				allowSpecialFloatingPointValues = false
			}
			serializer = KotlinxSerializer(json)
		}
	}

	suspend fun getAll(): List<RocketLaunch> {
		return httpClient.get(LAUNCHES_ENDPOINT)
	}

	companion object {
		private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
	}
}
