package com.kodeco.breeze.model

data class City(
  val id: String,
  val name: String,
  val country: String,
  val countryCode: String,
  val lastUpdated: String,
  val aqi: Int = 0
)