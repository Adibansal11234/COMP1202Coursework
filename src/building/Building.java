package building;
import bugs.Bug;
import java.util.ArrayList;
import java.util.Collections;

public class Building
{
    int constructionPoints;
    int topFloor;
    ArrayList<Bug> bugs = new ArrayList<Bug>();

    public Building (int topFloor, int constructionPoints)
    {
        this.topFloor = topFloor;
        this.constructionPoints = constructionPoints;
    }
    public int getTopFloor()
    {
        return topFloor;
    }

    public int getConstructionPoints()
    {
        return constructionPoints;
    }
    public Bug[] getAllBugs()
    {
        Collections.sort(bugs);
        ArrayList<Bug> bugsInBuilding = new ArrayList<Bug>();
        for (Bug bug: bugs)
        {
            if((bug.getCurrentFloor()>-1)&&bug.getCurrentHp()>0)
            {
                bugsInBuilding.add(bug);
            }
            else if(bug.getCurrentHp()<1)
            {
                bugsInBuilding.remove(bug);
            }
        }
        Collections.sort(bugs);
        //System.out.println(bugs);
        return (Bug[])bugsInBuilding.toArray(new Bug[0]);
    }


    public int addBug(Bug bug)
    {
        if(bug.getCurrentFloor()>-1 || bugs.contains(bug))
        {
            return -1;
        }
        else
        {
            bugs.add(bug);
            return bugs.size();
        }
    }

    public void removeBug(Bug bug)
    {
        bugs.remove(bug);
    }

    public void bugsMove()
    {
        Bug bugToRemove = null;
        try {
            for (Bug bug : bugs) {
                bug.move();
                if (bug.getCurrentFloor() == getTopFloor()) {
                    constructionPoints = constructionPoints - (bug.getBaseDamage());
                    bugToRemove = bug;
                    System.out.println(bug.getName() + " Reached the top floor, doing " + bug.getBaseDamage() + " damage!");
                    System.out.println("Building Construction Points Remaining: " + constructionPoints);
                }
                if (constructionPoints == 0) {
                    break;
                }
            }
        } catch (Exception e) {
                System.out.println("something");
            } finally {
                if(bugToRemove != null) {
                    bugs.remove(bugToRemove);
                }
            }
        }

    public Bug getLastBug()
    {
        try {
            return bugs.get(0);
        }
        catch (Exception e)
        {
            System.out.println("All bugs are dead!");
            return null;
        }
    }
    public Bug getBug(int size)
    {
        try {
            return bugs.get(size - 1);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


}
