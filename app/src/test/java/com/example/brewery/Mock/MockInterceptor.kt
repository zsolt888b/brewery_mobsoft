package com.example.brewery.DI.Mock

import android.net.Uri
import com.example.brewery.DI.NetworkConfig
import okhttp3.*
import okio.BufferedSource
import okio.Okio
import java.io.ByteArrayInputStream

class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return processRequest(chain.request())
    }

    private fun processRequest(request: Request): Response {
        val uri = Uri.parse(request.url().toString())
        val headers = request.headers()
        val path = uri.path

        return when {
            path == null -> createResponse(request, headers, 404, "Unknown")
            path.startsWith(NetworkConfig.ENDPOINT_PREFIX) -> MockApi.process(request)
            else -> createResponse(request, headers, 404, "Unknown")
        }
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