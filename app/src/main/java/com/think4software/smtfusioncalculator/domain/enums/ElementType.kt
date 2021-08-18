package com.think4software.smtfusioncalculator.domain.enums

import com.think4software.smtfusioncalculator.R

enum class ElementType(val id: Int, val description: String, val drawable: Int) {
    NONE(0, "None", R.drawable.pas),
    PHYSICAL(1, "Physical", R.drawable.phy),
    FIRE(2, "Fire", R.drawable.fir),
    ICE(3, "Ice", R.drawable.ice),
    THUNDER(4, "Thunder", R.drawable.ele),
    WIND(5, "Wind", R.drawable.force),
    EXPEL(6, "Expel", R.drawable.exp),
    DEATH(7, "Death", R.drawable.cur),
    MIND(8, "Mind", R.drawable.panic),
    NERVE(9, "Nerve", R.drawable.bind),
    CURSE(10, "Curse", R.drawable.poison),
    PASSIVE(11, "Passive", R.drawable.pas),
    ALMIGHTY(12, "Almighty", R.drawable.alm),
    REC(13, "Rec", R.drawable.rec),
    SUP(14, "Support", R.drawable.sup),
    SPECIAL(15, "Special", R.drawable.spe),
    TALK(16, "Talk", R.drawable.spe);

    companion object {
        private val map = values().associateBy(ElementType::id)

        fun fromId(id: Int) = map[id] ?: NONE
    }
}