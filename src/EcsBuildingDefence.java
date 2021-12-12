import bugs.Bug;
import bugs.ConcurrentModificationBug;
import bugs.NoneTerminationBug;
import bugs.NullPointerBug;
import building.Building;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import students.Team;

public class EcsBuildingDefence
{
    public static void main (String[] args)
    {
        int bugWave = 0;
        int topFloor = Integer.parseInt(args[0]);
        BufferedReader bufferedReader;
        int constructionPoints = Integer.parseInt(args[1]);
        Building building = new Building(topFloor, constructionPoints);
        Building tempBuilding = new Building(topFloor, constructionPoints);
        ArrayList<Bug> waves;

        String fileName = args[2];
        int teamKnowledgePoints =  Integer.parseInt(args[3]);
        Team team = new Team(teamKnowledgePoints, building);
        Battle battle = new Battle(team, building, fileName);
        //waves = battle.getWaves();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
        }
        catch (Exception e )
        {
            System.out.println(e);
        }
        System.out.println("\n=======================================");
        System.out.println("        BATTLE IS COMMENCING!");
        System.out.println("=======================================\n");
        battle.pause(3500);
        try {
            for (int i = 0; i < 1; i++) {
                System.out.println("WAVE " + (battle.getCounter()+1) + " OF BUGS ARE ABOUT TO ATTACK THE BUILDING!\n");

                battle.addWave();
                battle.pause(3500);
                battle.step();
                battle.step();
                battle.step();
                battle.step();
                for (int e = 0; e < (4); e++) {


                }

            }

        }
        catch(Exception e){
            System.out.println("h");
        }




        //System.out.println(building.getAllBugs());
    }

}
