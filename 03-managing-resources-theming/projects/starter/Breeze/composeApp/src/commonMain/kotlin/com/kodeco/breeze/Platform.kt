package com.kodeco.breeze

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform