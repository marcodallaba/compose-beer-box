package it.marcodallaba.composebeerbox.data.source.remote

import it.marcodallaba.composebeerbox.data.Beer
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkService {

    @GET("beers")
    suspend fun getBeers(@Query("page") page: Int, @Query("per_page") perPage: Int): List<Beer>

}