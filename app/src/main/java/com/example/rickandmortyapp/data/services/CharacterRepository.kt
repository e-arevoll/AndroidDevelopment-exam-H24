package com.example.rickandmortyapp.data.services

import com.example.rickandmortyapp.data.data_classes.retrofit_data_classes.Character
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterRepository {

    // Http-klienten
    private val _httpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        ).build()

    // Retrofit2-objekt
    private val _retrofit = Retrofit.Builder()
        .client(_httpClient)
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build()

    // Objekt av service interface
    private val _characterService = _retrofit.create(CharacterService::class.java)

    // Funksjon for å utføre og behandle http-kall
    suspend fun fetchAllCharacters() : List<Character> {
        var page = 1
        var hasMorePages = true
        val allCharacters = mutableListOf<Character>()
        try {
            do {
                val response = _characterService.getAllCharacters(page)
                if(response.isSuccessful){
                    val characterList = response.body()
                    if (characterList != null){
                        allCharacters.addAll(characterList.results)
                        hasMorePages = characterList.info.next != null
                        page++
                    } else {
                        hasMorePages = false
                    }
            } else {
                return emptyList()
            }
            } while (hasMorePages)
        } catch (e: Exception) {
            return emptyList()
        }
            return allCharacters
    }

    suspend fun getCharacterByName(name: String) : List<Character> {
        var page = 1
        var hasMorePages = true
        val allCharacters = mutableListOf<Character>()
         try {
            do{
                val response = _characterService.getCharacterByName(name, page)
                if(response.isSuccessful){
                    val characterList = response.body()
                    if (characterList!=null) {
                        allCharacters.addAll(characterList.results)
                        hasMorePages = characterList.info.next != null
                        page++
                    } else {
                        return emptyList()
                    }
                } else {
                    null
                }
            } while (hasMorePages)
        } catch (e: Exception) {
            return  emptyList()
        }
        return allCharacters
    }
}