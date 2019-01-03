package org.wharagaradoo.dndbro.game;

import org.wharagaradoo.dndbro.game.participants.Fighter;

import java.util.ArrayList;
import java.util.List;

/** @author Created by Vladimir Seleznov (v.e.seleznov@gmail.com) on 2019-01-03. */
public class GameController {

  private static GameController gameControllerInstance;
  boolean isActive;
  List<Fighter> fighters = new ArrayList<>();

  private GameController() {
    isActive = true;
  }

  public static synchronized GameController getInstance() {
    if (!gameControllerInstance.isActive) {
      gameControllerInstance = new GameController();
    }

    return gameControllerInstance;
  }

  public void finishGame() {
    isActive = false;
  }

  public void addFighter(Fighter fighter) {

    fighters.add(fighter);
  }
}
