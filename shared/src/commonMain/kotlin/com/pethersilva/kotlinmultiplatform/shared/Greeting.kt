package com.pethersilva.kotlinmultiplatform.shared


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
