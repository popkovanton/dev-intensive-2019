package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils

data class Profile(
        var firstName :String = "",
        var lastName :String = "",
        var about :String = "",
        var repository :String = "",
        val rating: Int = 0,
        val respect: Int = 0
) {
    private val nickName: String = Utils.transliteration("$firstName $lastName", "_") //TODO
    private val rank: String = "Android Software Engineer"

    fun toMap(): Map<String, Any> = mapOf(
            "nickName" to nickName,
            "rank" to rank,
            "firstName" to firstName,
            "lastName" to lastName,
            "about" to about,
            "repository" to repository,
            "rating" to rating,
            "respect" to respect
    )
}