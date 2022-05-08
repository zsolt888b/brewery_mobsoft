package com.example.brewery.Model

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity
data class Brewery(
    val brewery_type: String? = null,
    val street: String? = null,
    val address_2: String? = null,
    val address_3: String? = null,
    val city: String? = null,
    val state: String? = null,
    val county_province: String? = null,
    val postal_code: String? = null,
    val country: String? = null,
    val longitude: String? = null,
    val latitude: String? = null,
    val content: String? = null,
    val phone: String? = null,
    val website_url: String? = null,
    val updated_at: String? = null,
    val created_at: String? = null,

    @PrimaryKey(autoGenerate = false)
    val name: String = ""
) {}