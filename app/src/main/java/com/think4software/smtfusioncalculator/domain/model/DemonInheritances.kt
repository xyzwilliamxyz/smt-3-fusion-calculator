package com.think4software.smtfusioncalculator.domain.model

import kotlin.reflect.full.memberProperties

data class DemonInheritances(
    val thrust: Boolean,
    val claw: Boolean,
    val bite: Boolean,
    val weapon: Boolean,
    val mouth: Boolean,
    val wings: Boolean,
    val eye: Boolean,
    val talk: Boolean,
    val maiden: Boolean,
) {
    fun asTokenizedString(): String {
        val sb = StringBuilder()

        this::class.memberProperties.forEach {
            if (it.getter.call(this) == true) {
                if (sb.isNotEmpty()) {
                    sb.append(SEPARATOR)
                }
                sb.append(it.name.replaceFirstChar { char -> char.titlecase() })
            }
        }

        return sb.toString()
    }

    companion object {
        private const val SEPARATOR = " | "
    }
}
