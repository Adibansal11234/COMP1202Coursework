package students;

import building.Building;

public class CsStudent extends AllStudents
{
    int baseDelay = 6;

    public CsStudent(int level)
    {
        super(level, 6, "CS Student");
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
        System.out.println("Level "  + level  + " " + type + " attacks " + building.getLastBug().getName() + " for " + normalAttack() + " damage leaving him on " + building.getLastBug().getCurrentHp() + " HP!\n");


        if(building.getLastBug().getCurrentHp()<1)
        {
          knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel())*20);
          System.out.println(building.getLastBug().getName() + " has been killed by Level " + level + " " + type) ;
          System.out.println("The " + type + " has gained " + (((building.getLastBug().getLevel()) * 20)) + " knowledge points for the team!\n");
          building.removeBug(building.getLastBug());


        }
      }


      counter++;
      return knowledgePoints;
    }

}
