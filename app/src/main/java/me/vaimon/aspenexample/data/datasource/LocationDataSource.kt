package me.vaimon.aspenexample.data.datasource

import me.vaimon.aspenexample.data.models.retrofit.CitiesRequestBody
import me.vaimon.aspenexample.data.models.retrofit.CitiesRequestResponse
import me.vaimon.aspenexample.data.models.retrofit.StatesRequestBody
import me.vaimon.aspenexample.data.models.retrofit.StatesRequestResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LocationDataSource {
    companion object{
        const val BASE_URL = "https://countriesnow.space/api/v0.1/"
    }

    @POST("countries/states")
    suspend fun getStates(@Body requestBody: StatesRequestBody): StatesRequestResponse

    @POST("countries/state/cities")
    suspend fun getCitiesOfState(@Body requestBody: CitiesRequestBody): CitiesRequestResponse
}