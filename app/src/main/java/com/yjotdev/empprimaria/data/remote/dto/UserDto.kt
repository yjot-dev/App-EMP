package com.yjotdev.empprimaria.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("nombre") val name: String = "",
    @SerializedName("correo") val email: String = "",
    @SerializedName("clave") val password: String = "",
    @SerializedName("foto") val photo: String = "",
    @SerializedName("es_invitado") val isInvited: Boolean = false,
    @SerializedName("esta_en_lista_blanca") val isInWhiteList: Boolean = false
)