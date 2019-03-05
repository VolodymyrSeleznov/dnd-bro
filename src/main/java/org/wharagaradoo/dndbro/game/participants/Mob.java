package org.wharagaradoo.dndbro.game.participants;

import org.wharagaradoo.dndbro.model.monster.Monster;
import org.wharagaradoo.dndbro.util.Dice;

import java.util.Map;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-03. */
public class Mob extends Fighter {

  private Monster monster;
  private int ac;
  private int hp;
  private int str;
  private int dex;
  private int con;
  private int iNt;
  private int wis;
  private int cha;
  private Dice damage;
  private Map<String, Dice> attacks;

  public Mob(Monster monster) {

    this.monster = monster;
    this.ac = monster.getAcs().getAc();
    this.hp = monster.getHp().getFormula().roll().getResult();

  }
}
