package students;
import building.Building;
import utils.Toolbox;

public class CyberStudent extends AllStudents
{
    int baseDelay = 8;
    Toolbox toolbox = new Toolbox();

    public CyberStudent(int level)
    {
        super(level, 7, "Cyber Student");
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
          if(probability > 50) {
            probability = 50;
          }
          if(toolbox.getRandomInteger(100)<probability) {
            knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel())*20);

            System.out.println("Level "  + level  + " " + type + " PERFORMS SPECIAL ATTACK ON " + building.getLastBug().getName() + " and instantly kills it with a mega blow!\n");
            System.out.println("The " + type + " has gained " + (((building.getLastBug().getLevel()) * 20)) + " knowledge points for the team!\n");
            building.removeBug(building.getLastBug());
          }
          else {
            building.getLastBug().damage((normalAttack()*2));
            System.out.println("Level "  + level  + " " + type + " PERFORMS SPECIAL ATTACK ON " + building.getLastBug().getName() + " for " + normalAttack()*2 + " damage leaving him on " + building.getLastBug().getCurrentHp() + " HP!\n");
            if(building.getLastBug().getCurrentHp()<1) {
              knowledgePoints = knowledgePoints + ((building.getLastBug().getLevel())*20);
              System.out.println(building.getLastBug().getName() + " has been killed by Level " + level + " " + type) ;
              System.out.println("The " + type + " has gained " + (((building.getLastBug().getLevel()) * 20)) + " knowledge points for the team!\n");
              building.removeBug(building.getLastBug());
            }
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
