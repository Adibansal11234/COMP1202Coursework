package students;

import bugs.Bug;
import building.Building;

public class AiStudent extends AllStudents
{
    int baseDelay = 7;
    public AiStudent(int level, Building building)
    {
        super(level, 7, building);
    }
    @Override
    public int defence(Building building)
    {
      knowledgePoints = 0;
      this.building = building;
      getBuilding().getAllBugs();
      if(counter % baseDelay == 0)
      {
        for(int i = 1;i < 4; i++)
        {
          Bug tempBug = building.getBug(i);
          tempBug.damage(normalAttack());
          System.out.println("SPECIAL ATTACK ON" + tempBug.getName());
          if(building.getBug(i).getCurrentHp()<1)
          {
            knowledgePoints = knowledgePoints + ((building.getBug(i).getLevel())*20);
            building.removeBug(building.getLastBug());
            System.out.println("Bug is dead");

          }
        }
      }
      else
      {
        building.getLastBug().damage(normalAttack());
        if(building.getLastBug().getCurrentHp()<1)
        {
          knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel())*20);
          building.removeBug(building.getLastBug());
          System.out.println("Bug is dead");

        }
      }



      counter++;

      return knowledgePoints;
    }
}
