package org.wharagaradoo.dndbro.character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wharagaradoo.dndbro.enums.Skills;
import org.wharagaradoo.dndbro.enums.Stats;
import org.wharagaradoo.dndbro.enums.SkillsMap;

public class CharacterSkeleton {
        // Get from database
        private int totalLevel;

        
        private static Map<Stats, Integer> characteristics = createCharMap();
        private static Map<Stats, Integer> createCharMap()
        {
                Map<Stats, Integer> map = new HashMap<>();
                for (Stats stat : Stats.values())
                {
                        map.put(stat, 10);
                }
                return map;
        };


        // calculate on your own
        private static Map<Stats, Integer> mods = createModsMap();
        private static Map<Stats, Integer> createModsMap()
        {
                Map<Stats, Integer> map = new HashMap<>();
                for (Stats stat : Stats.values())
                {
                        map.put(stat, 0);
                }
                // map.put(Stats.STR, 0);
                // map.put(Stats.DEX, 0);
                // map.put(Stats.CON, 0);
                // map.put(Stats.INT, 0);
                // map.put(Stats.WIS, 0);
                // map.put(Stats.CHA, 0);
                return map;
        }

        private int profBonus;
        private int initiativeBonus;

        private Map<Skills, Integer> skillBonus = createSkillMap();
        private static Map<Skills, Integer> createSkillMap()
        {
                Map<Skills, Integer> map = new HashMap<>();
                for (Skills skill : Skills.values())
                {
                        map.put(skill, 0);
                }
                return map;
        }

        public void setCharsAndMods(List<Integer> vals)
        {
                int i = 0;
                for (Map.Entry<Stats, Integer> entry : characteristics.entrySet())
                {
                        characteristics.put(entry.getKey(), vals.get(i));
                        mods.put(entry.getKey(), (vals.get(i) - 10) / 2);
                        i++;
                }
        }

        public void setSkillBonus(List<Integer> prof)
        {
                int i = 0;
                for (Map.Entry<Skills, Integer> entry : skillBonus.entrySet())
                {
                        int bonus = 0;
                        bonus = prof.get(i) * profBonus;
                        bonus += mods.get(SkillsMap.skillCharsMap.get(entry.getKey()));
                        skillBonus.put(entry.getKey(), bonus);
                }
        }

        public Integer getChar(Stats stat, Boolean mod)
        {
                if (mod)
                {
                        return mods.get(stat);
                }
                else
                {
                        return characteristics.get(stat);
                }
        }

        public CharacterSkeleton(int level, List<Integer> chars, List<Integer> prof)
        {
                this.totalLevel = level;
                this.profBonus = 2 + ((level-1) / 4);
                setCharsAndMods(chars);
                this.initiativeBonus = mods.get(Stats.DEX);
                setSkillBonus(prof);
        }
}