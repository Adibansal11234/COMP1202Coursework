package students;
import building.Building;
import utils.Toolbox;

public class CyberStudent extends AllStudents
{
    int baseDelay = 8;
    Toolbox toolbox = new Toolbox();

    public CyberStudent(int level,Building building)
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
          int probability = level + 20;
          if(probability > 50)
          {
            probability = 50;
          }
          if(toolbox.getRandomInteger(100)<probability)
          {
            knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel())*20);
            building.removeBug(building.getLastBug());
          }
          else
          {
            building.getLastBug().damage((normalAttack()*2));
            if(building.getLastBug().getCurrentHp()<1)
            {
              knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel())*20);
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
            System.out.println("Knowledge points: " + knowledgePoints);
          }
        }


      counter++;

      return knowledgePoints;

    }



}
