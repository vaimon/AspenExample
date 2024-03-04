package me.vaimon.aspenexample.data.datasource

import me.vaimon.aspenexample.data.models.retrofit.StateRequestBody
import me.vaimon.aspenexample.data.models.retrofit.StateRequestResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LocationDataSource {
    companion object{
        const val BASE_URL = "https://countriesnow.space/api/v0.1/"
    }

    @POST("countries/states")
    suspend fun getStates(@Body requestBody: StateRequestBody): StateRequestResponse
}