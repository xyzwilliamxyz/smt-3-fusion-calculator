package com.think4software.smtfusioncalculator.dao.mapper

import com.think4software.smtfusioncalculator.dao.entity.DemonEntity
import com.think4software.smtfusioncalculator.dao.join.DemonAndDemonSkillsAndDemonFusionsJoin
import com.think4software.smtfusioncalculator.domain.model.Demon

class DemonMapper(
    private val demonEvolutionMapper: DemonEvolutionMapper,
    private val skillMapper: SkillMapper,
    private val demonResistancesMapper: DemonResistancesMapper,
    private val demonInheritancesMapper: DemonInheritancesMapper,
    private val reverseFusionMapper: ReverseFusionMapper,
    private val forwardFusionMapper: ForwardFusionMapper,
) {

    fun toDomain(demonJoin: DemonAndDemonSkillsAndDemonFusionsJoin): Demon {
        val demonEntity = demonJoin.demon

        return toDomain(demonEntity).also {
            it.evolvesFrom = demonEvolutionMapper.toDomain(demonJoin.evolvesFrom, demonEntity.evolvesFromLevel)
            it.evolvesTo = demonEvolutionMapper.toDomain(demonJoin.evolvesTo, demonEntity.evolvesTo)
            it.skills = skillMapper.toDomain(demonJoin.demonSkills)
            it.reverseFusions = reverseFusionMapper.toDomain(demonJoin.reverseFusions)
            it.forwardFusions = forwardFusionMapper.toDomain(demonJoin.forwardFusions)
        }
    }

    fun toDomain(demonEntity: DemonEntity): Demon {
        return Demon(
            demonId = demonEntity.demonId,
            name = demonEntity.name,
            level = demonEntity.level,
            race = demonEntity.race,
            price = demonEntity.price,
            hp = demonEntity.hp,
            mp = demonEntity.mp,
            strength = demonEntity.strength,
            magic = demonEntity.magic,
            vitality = demonEntity.vitality,
            agility = demonEntity.agility,
            luck = demonEntity.luck,
            specialFusionCondition = demonEntity.specialFusionCondition,
            specialFusionIngredient = null,
            resistances = demonResistancesMapper.toDomain(demonEntity),
            inheritances = demonInheritancesMapper.toDomain(demonEntity),
        )
    }

    fun toDomain(demonEntities: List<DemonEntity>): List<Demon> {
        return demonEntities.map {
            toDomain(it)
        }
    }
}