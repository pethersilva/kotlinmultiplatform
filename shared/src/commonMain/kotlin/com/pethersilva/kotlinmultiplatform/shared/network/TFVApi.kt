package com.pethersilva.kotlinmultiplatform.shared.network

import com.pethersilva.kotlinmultiplatform.shared.entity.Results
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class TFVApi {

	private val httpClient = HttpClient {
		install(JsonFeature) {
			val json = Json { ignoreUnknownKeys = true }
			serializer = KotlinxSerializer(json)
		}
	}

	suspend fun getAll(): Results {
		return httpClient.get(LAUNCHES_ENDPOINT)
	}

	companion object {
		private const val LAUNCHES_ENDPOINT = "https://api.tropicalfruitandveg.com/tfvjsonapi.php?search=all"
		//private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
	}
}
