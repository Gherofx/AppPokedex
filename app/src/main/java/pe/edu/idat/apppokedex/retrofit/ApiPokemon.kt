package pe.edu.idat.apppokedex.retrofit

import pe.edu.idat.apppokedex.retrofit.response.PokemonResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiPokemon {

    @GET("pokemon")
    fun  listarPokemones(@Query("limit") limit: Int,
                         @Query("offset") offset: Int):Call<PokemonResult>
}