package com.example.brewery.DI.Mock

import android.net.Uri
import com.example.brewery.DI.NetworkConfig
import com.example.brewery.Model.Brewery
import com.google.gson.Gson
import okhttp3.*
import okio.BufferedSource
import okio.Okio
import java.io.ByteArrayInputStream

object MockApi {
    fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        val responseString: String
        val responseCode: Int
        val headers = request.headers()

        if (uri.path == NetworkConfig.ENDPOINT_PREFIX && request.method() == "GET") {
            val returnList = listOf(
                Brewery(name = "brewery_1"),
                Brewery(name = "brewery_2"),
                Brewery(name = "brewery_3")
            )
            responseString = Gson().toJson(returnList)
            responseCode = 200
        } else {
            responseString = "error"
            responseCode = 500
        }

        return createResponse(request, headers, responseCode, responseString)
    }

    private fun createResponse(request: Request, headers: Headers, code: Int, content: String): Response {
        val responseBody = object : ResponseBody() {
            override fun contentType(): MediaType? = MediaType.parse("application/json")

            override fun contentLength(): Long = content.toByteArray().size.toLong()

            override fun source(): BufferedSource = Okio.buffer(Okio.source(ByteArrayInputStream(content.toByteArray())))
        }

        return Response.Builder()
            .protocol(Protocol.HTTP_2)
            .code(code)
            .request(request)
            .headers(headers)
            .message("")
            .body(responseBody)
            .build()
    }
}