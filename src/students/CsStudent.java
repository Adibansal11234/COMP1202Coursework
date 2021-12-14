package students;

import building.Building;

public class CsStudent extends AllStudents {
    int baseDelay = 6;

    //constructor for computer science student
    public CsStudent(int level) {
        super(level, 6, "CS Student");
    }

    //method for the CS student to attack the bug closest to the top floor.
    //on the 6th attack, the student performs a special attack where it attacks the bug closest to the top for 4 x the usual damage
    //if the student manages to kill a bug, it gains knowledge points and the bug is removed from the building
    @Override
    public int defence(Building building) {
        knowledgePoints = 0;
        this.building = building;
        getBuilding().getAllBugs();
        if (counter % baseDelay == 0) {
            building.getLastBug().damage((normalAttack() * 4));
            System.out.println("Level " + level + " " + type + " PERFORMS SPECIAL ATTACK ON " + building.getLastBug().getName() + " for " + normalAttack() * 4 + " damage leaving him on " + building.getLastBug().getCurrentHp() + " HP!\n");
        } else {
            building.getLastBug().damage(normalAttack());
            System.out.println("Level " + level + " " + type + " attacks " + building.getLastBug().getName() + " for " + normalAttack() + " damage leaving him on " + building.getLastBug().getCurrentHp() + " HP!\n");
        }
        if (building.getLastBug().getCurrentHp() < 1) {
            knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel()) * 20);
            System.out.println(building.getLastBug().getName() + " has been killed by Level " + level + " " + type);
            System.out.println("The " + type + " has gained " + (((building.getLastBug().getLevel()) * 20)) + " knowledge points for the team!\n");
            building.removeBug(building.getLastBug());
        }
        counter++;
        return knowledgePoints;
    }
}
