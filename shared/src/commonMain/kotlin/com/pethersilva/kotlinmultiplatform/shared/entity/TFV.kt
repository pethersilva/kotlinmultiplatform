package com.pethersilva.kotlinmultiplatform.shared.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Results(@SerialName("results")
				   val results: List<TFV>,
				   @SerialName("tfvcount")
				   val count: String)

@Serializable
data class TFV(@SerialName("tfvname")
			   val name: String,
			   @SerialName("botname")
			   val botanicalName: String,
			   @SerialName("othname")
			   val otherName: String,
			   @SerialName("imageurl")
			   val imageUrl: String)
