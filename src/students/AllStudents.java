package students;

import building.Building;

public class AllStudents implements Student {
    int level;
    int baseDelay;
    int baseAttack;
    int knowledgePoints;
    int counter = 1;
    String type;
    Building building = null;

    //constructor for students
    public AllStudents(int level, int baseAttack, String type) {
        this.level = level;
        this.baseAttack = baseAttack;
        this.type = type;

    }

    //returns building
    public Building getBuilding() {
        return building;
    }

    //returns level
    @Override
    public int getLevel() {
        return level;
    }

    //returns type
    public String getType() {
        return type;
    }

    //method to calculate student upgrade cost
    @Override
    public int upgradeCost() {
        return (int) (100 * Math.pow(2, level - 1));
    }

    //method to calculate the damage of a normal attack
    public int normalAttack() {
        return (int) (Math.round(baseAttack * Math.pow(level, 1.2)));
    }

    //defence method
    public int defence(Building building) {
        return 0;
    }

    //method to increase level
    public void increaseLevel() {
        level = level + 1;
    }

    //converts to string
    public String toString() {
        return "Type: " + this.getType() + " Knowledge Points: " + this.knowledgePoints + " Level: " + this.level + "\n";

    }

    //method to set the current building
    public void setBuilding(Building building) {
        this.building = building;
    }


}
