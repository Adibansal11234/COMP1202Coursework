package students;

import building.Building;

public class SeStudent extends AllStudents {
    int baseDelay = 6;

    //constructor for software engineering student
    public SeStudent(int level) {
        super(level, 5, "SE Student");
    }

    //method for the SE student to attack the bug closest to the top floor.
    //on the 6th attack, the student performs a special attack where it slows down the top 5 bugs by 2 steps each
    //if the student manages to kill a bug, it gains knowledge points and the bug is removed from the building
    @Override
    public int defence(Building building) {
        knowledgePoints = 0;
        this.building = building;
        if (counter % baseDelay == 0) {
            int tempValue = building.getAllBugs().length;
            if (tempValue > 5) {
                tempValue = 6;
            }
            for (int i = 1; i < tempValue; i++) {
                building.getBug(i).slowDown(2);
            }
            System.out.println("Level " + level + " " + type + " performs SPECIAL ATTACK on the first " + tempValue + " bugs, slowing them down by 2 steps each\n");
        } else {
            getBuilding().getAllBugs();
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
