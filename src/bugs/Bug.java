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

    //bug constructor
    public Bug(String name, int baseHp, int baseSteps, int level) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSteps = baseSteps;
        this.level = level;
    }

    //returns base steps
    public int getBaseSteps() {
        return baseSteps;
    }

    //returns level
    public int getLevel() {
        return level;
    }

    //second bug constructor
    public Bug(String name, int baseHp, int baseSteps, int level, int initialSteps) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSteps = baseSteps;
        this.level = level;
        this.currentSteps = initialSteps;
        currentHp = (int) Math.round(baseHp * Math.pow(level, 1.5));
    }

    //returns current HP
    public int getCurrentHp() {
        return currentHp;
    }

    //returns current steps
    public int getCurrentSteps() {
        return currentSteps;
    }

    //returns current floor
    public int getCurrentFloor() {
        return currentFloor;
    }

    //method to move the bug forward one step, if there is 0 steps to the next floor it goes up 1 floor
    public void move() {
        if (getCurrentSteps() > 0) {
            currentSteps--;
        } else {
            currentFloor++;
            currentSteps = getBaseSteps() - 1;
        }
    }

    //method to damage the bug, sets hp as 0 if damage exceeds current hp
    public void damage(int amount) {
        if (currentHp > amount) {
            currentHp = currentHp - amount;

        } else {
            currentHp = 0;
        }

    }

    //method to slow down bug by an integer of steps
    public void slowDown(int steps) {
        currentSteps = currentSteps + steps;
    }

    //method to output as string
    public String toString() {
        return "Name: " + name + " Floor: " + currentFloor + " Steps: " + currentSteps + " HP: "
                + currentHp + "\n";

    }

    //returns name
    public String getName() {
        return name;
    }

    //method to sort array of bugs in order of steps to top floor
    @Override
    public int compareTo(Object bug) {

        if (this.getCurrentFloor() == (((Bug) bug).getCurrentFloor())) {
            return (this.getCurrentSteps()) - (((Bug) bug).getCurrentSteps());
        } else {
            return ((Bug) bug).getCurrentFloor() - this.getCurrentFloor();
        }
    }

    //method to return base damage
    public int getBaseDamage() {
        return baseDamage;
    }
}
