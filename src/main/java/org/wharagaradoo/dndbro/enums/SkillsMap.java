package org.wharagaradoo.dndbro.enums;

import java.util.HashMap;
import java.util.Map;

public class SkillsMap {


        public static Map<Skills, Stats> skillCharsMap = new HashMap<>();
        static {

                skillCharsMap.put(Skills.ACROBATICS, Stats.DEX);
                skillCharsMap.put(Skills.ANIMAL_HANDLING, Stats.WIS);
                skillCharsMap.put(Skills.ARCANA, Stats.INT);
                skillCharsMap.put(Skills.ATHLETICS, Stats.STR);
                skillCharsMap.put(Skills.DECEPTION, Stats.CHA);
                skillCharsMap.put(Skills.HISTORY, Stats.INT);
                skillCharsMap.put(Skills.INSIGHT, Stats.WIS);
                skillCharsMap.put(Skills.INTIMIDATION, Stats.CHA);
                skillCharsMap.put(Skills.MEDICINE, Stats.WIS);
                skillCharsMap.put(Skills.NATURE, Stats.INT);
                skillCharsMap.put(Skills.PERCEPTION, Stats.WIS);
                skillCharsMap.put(Skills.PERFORMANCE, Stats.CHA);
                skillCharsMap.put(Skills.PERSUATION, Stats.CHA);
                skillCharsMap.put(Skills.RELIGION, Stats.INT);
                skillCharsMap.put(Skills.SLEIGHT_OF_HAND, Stats.DEX);
                skillCharsMap.put(Skills.STEALTH, Stats.DEX);
                skillCharsMap.put(Skills.SURVIVAL, Stats.WIS);
        }
};