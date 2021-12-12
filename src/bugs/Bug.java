package bugs;

public class Bug implements Comparable {

  String name;
  int baseHp;
  int baseSteps;
  int level;
  int currentHp;
  int currentSteps;
  int currentFloor = -1;
  int baseDamage = 1;

  public Bug(String name, int baseHp, int baseSteps, int level) {
    this.name = name;
    this.baseHp = baseHp;
    this.baseSteps = baseSteps;
    this.level = level;
  }

  public int getBaseSteps() {
    return baseSteps;
  }

  public int getLevel() {
    return level;
  }

  public Bug(String name, int baseHp, int baseSteps, int level, int initialSteps) {
    this.name = name;
    this.baseHp = baseHp;
    this.baseSteps = baseSteps;
    this.level = level;
    this.currentSteps = initialSteps;
    currentHp = (int) Math.round(baseHp * Math.pow(level, 1.5));
  }

  public int getCurrentHp() {
    return currentHp;
  }

  public int getCurrentSteps() {
    return currentSteps;
  }

  public int getCurrentFloor() {
    return currentFloor;
  }

  public void move() {
    if (getCurrentSteps() > 0) {
      currentSteps--;
    } else {
      currentFloor++;
      currentSteps = getBaseSteps() - 1;
    }
  }

  public void damage(int amount) {
    if (currentHp > amount) {
      currentHp = currentHp - amount;

    } else {
      currentHp = 0;
    }

  }

  public void slowDown(int steps) {
    currentSteps = currentSteps + steps;
  }


  public String toString() {
    return "Name: " + name + " Floor: " + currentFloor + " Steps: " + currentSteps + " HP: "
        + currentHp + "\n";

  }

  public String getName() {
    return name;
  }

  @Override
  public int compareTo(Object bug) {

    if (this.getCurrentFloor() == (((Bug) bug).getCurrentFloor())) {
      return (this.getCurrentSteps()) - (((Bug) bug).getCurrentSteps());
    } else {
      return ((Bug) bug).getCurrentFloor() - this.getCurrentFloor();
    }
  }

  public int getBaseDamage() {
    return baseDamage;
  }
}
