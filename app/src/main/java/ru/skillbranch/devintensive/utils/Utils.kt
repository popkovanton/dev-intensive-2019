package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder


object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.trim()?.split(" ")

        val firstName = parts?.getOrNull(0)?.ifEmpty { null }
        val lastName = parts?.getOrNull(1)?.ifEmpty { null }

        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstCharacter = firstName?.trim()?.getOrNull(0)?.toUpperCase()?.toString() ?: ""
        val secondCharacter = lastName?.trim()?.getOrNull(0)?.toUpperCase()?.toString() ?: ""
        return "$firstCharacter$secondCharacter".ifEmpty { null }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val builder = StringBuilder()
        for (ch in payload.trim()) {
            builder.append(getTransl(ch))
        }
        return builder.toString().replace(" ", divider)
    }

    private fun getTransl(char: Char): String {
        val finalChar = cyrillicToLatinMap(char.toLowerCase())
        return if (char.isUpperCase())
            finalChar.capitalize()
        else finalChar
    }

    private fun cyrillicToLatinMap(character: Char): String {
        return when (character) {
            'а' -> "a"
            'б' -> "b"
            'в' -> "v"
            'г' -> "g"
            'д' -> "d"
            'е' -> "e"
            'ё' -> "e"
            'ж' -> "zh"
            'з' -> "z"
            'и' -> "i"
            'й' -> "i"
            'к' -> "k"
            'л' -> "l"
            'м' -> "m"
            'н' -> "n"
            'о' -> "o"
            'п' -> "p"
            'р' -> "r"
            'с' -> "s"
            'т' -> "t"
            'у' -> "u"
            'ф' -> "f"
            'х' -> "h"
            'ц' -> "c"
            'ч' -> "ch"
            'ш' -> "sh"
            'щ' -> "sh'"
            'ъ' -> ""
            'ы' -> "i"
            'ь' -> ""
            'э' -> "e"
            'ю' -> "yu"
            'я' -> "ya"
            else -> character.toString()
        }
    }

    fun mathGitHubAccount(adress:String):Boolean = adress.matches(
            Regex("^(http(s){0,1}:\\/\\/){0,1}(www.){0,1}github.com\\/[A-z\\d](?:[A-z\\d]|-(?=[A-z\\d])){0,38}\$",RegexOption.IGNORE_CASE)) &&
            !adress.matches(Regex("^.*(" +
                    "\\/enterprise|" +
                    "\\/features|" +
                    "\\/topics|" +
                    "\\/collections|" +
                    "\\/trending|" +
                    "\\/events|" +
                    "\\/marketplace" +
                    "|\\/pricing|" +
                    "\\/nonprofit|" +
                    "\\/customer-stories|" +
                    "\\/security|" +
                    "\\/login|" +
                    "\\/join)\$",RegexOption.IGNORE_CASE))
}