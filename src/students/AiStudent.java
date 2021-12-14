package students;

import bugs.Bug;
import building.Building;

public class AiStudent extends AllStudents {
    int baseDelay = 7;

    //constructor for Artificial Intelligence Student
    public AiStudent(int level) {
        super(level, 7, "AI Student");
    }

    //method for the AI student to attack the bug closest to the top floor.
    //on the 7th attack, the student performs a special attack where it performs a basic attack on the top 3 bugs in the building
    //if the student manages to kill a bug, it gains knowledge points and the bug is removed from the building
    @Override
    public int defence(Building building) {
        knowledgePoints = 0;
        this.building = building;
        getBuilding().getAllBugs();
        if (counter % baseDelay == 0) {
            int tempValue = building.getBugSize();
            if (tempValue > 2) {
                tempValue = 3;
            }
            for (int i = 1; i < tempValue + 1; i++) {
                building.getBug(i).damage(normalAttack());
                System.out.println("Level " + level + " " + type + " PERFORMS SPECIAL ATTACK ON " + building.getBug(i).getName() + " for " + normalAttack() + " damage leaving him on " + building.getBug(i).getCurrentHp() + " HP!\n");
                if (building.getBug(i).getCurrentHp() < 1) {
                    knowledgePoints = knowledgePoints + ((building.getBug(i).getLevel()) * 20);
                    System.out.println(building.getBug(i).getName() + " has been killed by Level " + level + " " + type);
                    System.out.println("The " + type + " has gained " + (((building.getBug(i).getLevel()) * 20)) + " knowledge points for the team!\n");
                    building.removeBug(building.getBug(i));
                    i = i - 1;
                }
            }
        } else {
            building.getLastBug().damage(normalAttack());
            System.out.println("Level " + level + " " + type + " attacks " + building.getLastBug().getName() + " for " + normalAttack() + " damage leaving him on " + building.getLastBug().getCurrentHp() + " HP!\n");
            if (building.getLastBug().getCurrentHp() < 1) {
                knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel()) * 20);
                System.out.println(building.getLastBug().getName() + " has been killed by Level " + level + " " + type);
                System.out.println("The " + type + " has gained " + (((building.getLastBug().getLevel()) * 20)) + " knowledge points for the team!\n");
                building.removeBug(building.getLastBug());
            }
        }
        counter++;
        return knowledgePoints;
    }
}
