package students;

import building.Building;

public class SeStudent extends AllStudents
{
    int baseDelay = 6;
    public SeStudent(int level)
    {
      super(level, 5, "SE Student");
    }

    @Override
    public int defence(Building building)
    {
      this.building = building;
      if(counter % baseDelay == 0)
      {
        int tempValue = building.getAllBugs().length;
        if(tempValue>5){
            tempValue = 6;
        }
        for (int i = 1; i < tempValue; i++) {
          building.getBug(i).slowDown(2);
        }
        System.out.println("Level "  + level  + " " + type + " performs SPECIAL ATTACK on the first " + tempValue + " bugs, slowing them down by 2 steps each\n");
      }
      else
      {
        getBuilding().getAllBugs();
        building.getLastBug().damage(normalAttack());
          System.out.println("Level "  + level  + " " + type + " attacks " + building.getLastBug().getName() + " for " + normalAttack() + " damage leaving him on " + building.getLastBug().getCurrentHp() + " HP!\n");
        if (building.getLastBug().getCurrentHp() < 1)
        {
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
