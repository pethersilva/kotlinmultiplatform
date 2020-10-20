package com.pethersilva.kotlinmultiplatform.shared.sdk

import com.pethersilva.kotlinmultiplatform.shared.entity.RocketLaunch
import com.pethersilva.kotlinmultiplatform.shared.network.SpaceXApi

class SpaceXSdk {
	private val api = SpaceXApi()

	@Throws(Exception::class) suspend fun getAll(): List<RocketLaunch> {
		return api.getAll()
	}
}
