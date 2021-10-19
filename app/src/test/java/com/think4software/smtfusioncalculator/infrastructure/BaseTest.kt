package com.think4software.smtfusioncalculator.infrastructure

import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.dao.entity.DemonSkillEntity
import com.think4software.smtfusioncalculator.dao.entity.ForwardFusionEntity
import com.think4software.smtfusioncalculator.dao.entity.ReverseFusionEntity
import com.think4software.smtfusioncalculator.dao.entity.SkillEntity
import com.think4software.smtfusioncalculator.dao.join.DemonAndDemonSkillsAndDemonFusionsJoin
import com.think4software.smtfusioncalculator.dao.join.DemonSkillAndSkillJoin
import com.think4software.smtfusioncalculator.dao.join.ForwardFusionJoin
import com.think4software.smtfusioncalculator.dao.join.ReverseFusionJoin

abstract class BaseTest {

    fun getDemonEntity(
        demonId: Int = 1,
        name: String = "Jack Frost",
        race: String = "Fairy",
        level: Int = 7,
    ): DemonEntity {
        return DemonEntity(
            demonId = demonId,
            name = name,
            level = level,
            race = race,
            price = 3600,
            hp = 78,
            mp = 45,
            strength = 5,
            magic = 8,
            vitality = 6,
            agility = 4,
            luck = 4,
            evolvesFrom = 0,
            evolvesFromLevel = 0,
            evolvesTo = 2,
            evolvesToLevel = 20,
            specialFusionCondition = "",
            resPhysical = 0,
            resFire = 2,
            resIce = 5,
            resThunder = 0,
            resWind = 0,
            resExpel = 0,
            resDeath = 0,
            resMind = 0,
            resNerve = 0,
            resCurse = 0,
            inheritThrust = true,
            inheritClaw = false,
            inheritBite = false,
            inheritWeapon = false,
            inheritMouth = true,
            inheritWings = false,
            inheritEye = true,
            inheritTalk = true,
            inheritMaiden = false,
        )
    }

    fun getDemonAndDemonSkillsAndDemonFusionsJoin(): DemonAndDemonSkillsAndDemonFusionsJoin {
        return DemonAndDemonSkillsAndDemonFusionsJoin(
            demon = getDemonEntity(),
            demonSkills = listOf(getDemonSkillAndSkillJoin()),
            reverseFusions = listOf(getReverseFusionJoin()),
            forwardFusions = listOf(getForwardFusionJoin()),
            evolvesFrom = getDemonEntity(demonId = 20),
            evolvesTo = getDemonEntity(demonId = 30)
        )
    }

    fun getForwardFusionJoin(): ForwardFusionJoin {
        return ForwardFusionJoin(
            ForwardFusionEntity(
                fusionId = 100,
                demonId = 1,
                ingredientTwo = 10,
                result = 15
            ),
            ingredientTwo = getDemonEntity(
                demonId = 10,
                name = "Pixie",
                level = 2
            ),
            result = getDemonEntity(
                demonId = 15,
                name = "Aeros",
                race = "Element",
                level = 11
            )
        )
    }

    fun getReverseFusionJoin(): ReverseFusionJoin {
        return ReverseFusionJoin(
            ReverseFusionEntity(
                demonFusionId = 100,
                demonId = 1,
                ingredientOne = 3,
                ingredientTwo = 10,
            ),
            ingredientOne = getDemonEntity(
                demonId = 3,
                name = "Zhen",
                race = "Brute",
                level = 6
            ),
            ingredientTwo = getDemonEntity(
                demonId = 10,
                name = "Shikigami",
                race = "Brute",
                level = 4
            )
        )
    }

    fun getSkillEntity(
        cost: String = "3MP"
    ): SkillEntity {
        return SkillEntity(
            skillId = 10,
            name = "Bufu",
            element = 3,
            cost = cost,
            effect = "Weak (30) ice damage",
            target = "Single",
            rank = 1,
            inherit = 0,
            unique = false,
        )
    }

    fun getDemonSkillAndSkillJoin(
        level: Int = 10
    ): DemonSkillAndSkillJoin {
        return DemonSkillAndSkillJoin(
            demonSkill = DemonSkillEntity(
                demonSkillId = 120,
                skillId = 50,
                level = level,
                demonId = 1
            ),
            skill = getSkillEntity()
        )
    }
}
