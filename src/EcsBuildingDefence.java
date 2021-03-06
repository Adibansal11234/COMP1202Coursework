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

public class EcsBuildingDefence {
    public static void main(String[] args) {
        int bugWave = 0;
        int topFloor = Integer.parseInt(args[0]);
        BufferedReader bufferedReader;
        int constructionPoints = Integer.parseInt(args[1]);
        Building building = new Building(topFloor, constructionPoints);
        Building tempBuilding = new Building(topFloor, constructionPoints);
        ArrayList<Bug> waves;
        String fileName = args[2];
        int teamKnowledgePoints = Integer.parseInt(args[3]);
        Team team = new Team(teamKnowledgePoints, building);
        Battle battle = new Battle(team, building, fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            System.out.println(e);
        }

        //battle starts here
        System.out.println("\n===================================================");
        System.out.println("              BATTLE IS COMMENCING!");
        System.out.println("===================================================\n");
        battle.pause(3500);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("\n===================================================");
                System.out.println(" WAVE " + (battle.getCounter() + 1) + " OF BUGS ARE ABOUT TO ATTACK THE BUILDING!");
                System.out.println("===================================================\n");

                battle.addWave();
                battle.pause(3500);
                for (int e = 0; e < 8 * topFloor; e++) {
                    battle.step();
                    if (building.getBugSize() == 0) {
                        break;
                    }
                }
            }
            if (team.getStudents().size() > 0) {
                System.out.println("\nTHE STUDENTS HAVE SUCCESSFULLY DEFENDED THE BUILDING! CONGRATULATIONS!");
            } else {
                System.out.println("\nALL STUDENTS HAVE BEEN KILLED! BETTER LUCK NEXT TIME...");
            }
        } catch (Exception e) {
            System.out.println("h");
        }
    }
}
