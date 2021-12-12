package students;

import building.Building;

public class AllStudents implements Student
{
    int level;
    int baseDelay;
    int baseAttack;
    int knowledgePoints;
    int counter = 1;
    String type;
    Building building = null;
    public AllStudents(int level, int baseAttack, String type)
    {
        this.level = level;
        this.baseAttack = baseAttack;
        this.type = type;

    }



    public Building getBuilding() {
        return building;
    }

    @Override
    public int getLevel()
    {
        return level;
    }

    public String getType() {
        return type;
    }

    @Override
    public int upgradeCost()
    {
        return (int)(100 * Math.pow(2, level-1));
    }


    public int normalAttack()
    {

        return (int)(Math.round(baseAttack * Math.pow(level, 1.2)));
    }
    public int defence(Building building)
    {
        return 0;
    }

    public void increaseLevel()
    {
        level = level + 1;
    }
    public String toString()
    {
        return "Type: " + this.getType() + " Knowledge Points: " + this.knowledgePoints + " Level: " + this.level + "\n";

    }
    public void setBuilding(Building building)
    {
        this.building = building;
    }




}
