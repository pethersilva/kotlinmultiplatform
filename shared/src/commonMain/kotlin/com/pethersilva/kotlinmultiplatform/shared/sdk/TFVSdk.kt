package com.pethersilva.kotlinmultiplatform.shared.sdk

import com.pethersilva.kotlinmultiplatform.shared.entity.Results
import com.pethersilva.kotlinmultiplatform.shared.network.TFVApi

class TFVSdk {
	private val api = TFVApi()

	@Throws(Exception::class) suspend fun getAll(): Results {
		return api.getAll()
	}
}
