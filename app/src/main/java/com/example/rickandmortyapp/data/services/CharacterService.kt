package com.example.rickandmortyapp.data.services

import com.example.rickandmortyapp.data.data_classes.retrofit_data_classes.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Interface, gjør http-kall mot Web API'et

interface CharacterService {
    @GET("character/")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): Response<CharacterList>

    @GET("character/")
    suspend fun getCharacterByName(
        @Query("name")name: String,  // Angir at det er name som skal erstatte placeholder i @GET.
        @Query("page") page: Int
    ) : Response<CharacterList>


}