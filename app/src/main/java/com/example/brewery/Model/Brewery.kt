package com.example.brewery.Model

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity
data class Brewery(
    var brewery_type: String? = null,
    var street: String? = null,
    var address_2: String? = null,
    var address_3: String? = null,
    var city: String? = null,
    var state: String? = null,
    var county_province: String? = null,
    var postal_code: String? = null,
    var country: String? = null,
    var longitude: String? = null,
    var latitude: String? = null,
    var content: String? = null,
    var phone: String? = null,
    var website_url: String? = null,
    var updated_at: String? = null,
    var created_at: String? = null,

    @PrimaryKey(autoGenerate = false)
    var name: String = ""
) {}