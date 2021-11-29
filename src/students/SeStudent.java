package students;

import building.Building;

public class SeStudent extends AllStudents
{
    int baseDelay = 6;
    public SeStudent(int level, Building building)
    {
      super(level, 5, building);
    }

    @Override
    public int defence(Building building)
    {
      this.building = building;
      System.out.println(counter);
      if(counter % baseDelay == 0)
      {
         System.out.println("Special ");
        for (int i = 1; i < 6; i++) {
          building.getBug(i).slowDown(2);
        }
      }
      else
      {
        getBuilding().getAllBugs();
        building.getLastBug().damage(normalAttack());
        if (building.getLastBug().getCurrentHp() < 1)
        {
          knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel()) * 20);
          building.removeBug(building.getLastBug());
          System.out.println("Bug is dead");
          System.out.println("Knowledge points: " + knowledgePoints);
        }
      }



      counter++;

      return knowledgePoints;
  }





}
