package students;

import building.Building;

public class CsStudent extends AllStudents
{
    int baseDelay = 6;

    public CsStudent(int level, Building building)
    {
        super(level, 6, building);
    }

  @Override
    public int defence(Building building)
    {
      knowledgePoints = 0;
      this.building = building;
      getBuilding().getAllBugs();
      if(counter % baseDelay == 0)
      {
        building.getLastBug().damage((normalAttack()*4));
        if(building.getLastBug().getCurrentHp()<1)
        {
          knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel())*20);
          building.removeBug(building.getLastBug());
          System.out.println("Bug is dead");

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
