package org.wharagaradoo.dndbro.character;

import java.util.List;
import java.util.Map;

import org.wharagaradoo.dndbro.enums.Skills;
import org.wharagaradoo.dndbro.enums.Stats;

public class CharacterSkeleton {
        // Get from database
        private int totalLevel;

        
        private Map<Stats, Integer> characteristics = Map.ofEntries(
                entry(Stats.STR, 10),
                entry(Stats.DEX, 10),
                entry(Stats.CON, 10),
                entry(Stats.INT, 10),
                entry(Stats.WIS, 10),
                entry(Stats.CHA, 10)
        );


        // calculate on your own
        private Map<Stats, Integer> mods = Map.ofEntries(
                entry(Stats.STR, 0),
                entry(Stats.DEX, 0),
                entry(Stats.CON, 0),
                entry(Stats.INT, 0),
                entry(Stats.WIS, 0),
                entry(Stats.CHA, 0)
        );

        private int profBonus;
        private int initiativeBonus;

        private Map<Skills, Integer> skillBonus = Map.ofEntries(
                entry(Skills.acrobatics, 0),
                entry(Skills.animal_handling, 0),
                entry(Skills.arcana, 0),
                entry(Skills.athletics, 0),
                entry(Skills.deception, 0),
                entry(Skills.history, 0),
                entry(Skills.insight, 0),
                entry(Skills.intimidation, 0),
                entry(Skills.investigation, 0),
                entry(Skills.medicine, 0), 
                entry(Skills.nature, 0),
                entry(Skills.perception, 0),
                entry(Skills.performance, 0),
                entry(Skills.persuation, 0),
                entry(Skills.religion, 0),
                entry(Skills.sleight_of_hand, 0),
                entry(Skills.stealth, 0),
                entry(Skills.survival, 0)
        );

        public void setCharsAndMods(List<Integer> vals)
        {
                int i = 0;
                for (Map.Entry<Stats, Integer> entry : map.entrySet())
                {
                      characteristics.put(entry.getKey(), vals[i]);
                      mods.put(entry.getKey(), (vals[i] - 10) / 2);
                      i++;
                }
        }

        public void setSkillBonus(List<Integer> prof)
        {
                i = 0;
                for (Map.Entry<String, Integer> entry : map.entrySet())
                {
                        int bonus = 0;
                        bonus = prof[0] * profBonus;
                        bouns += mods.get(skillToMod.get(entry.getKey()));
                        skillBonus.put(entry.getKey(), bonus);
                }
        }

        public void getChar(String mod, bool mod)
        {
                if mod
                {
                        return mods.get(mod, 0);
                }
                else
                {
                        return characteristics.get(mod, 0);
                }
        }

        public CharacterSkeleton(int level, List<Integer> chars, List<Integer> prof)
        {
                this.totalLevel = level;
                profBonus = 2 + ((level-1) / 4);
                setCharsAndMods(chars);
                initiativeBonus = mods.get(Skills.DEX);
                setSkillBonus(prof);   
        }
}