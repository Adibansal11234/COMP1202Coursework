import bugs.Bug;
import bugs.ConcurrentModificationBug;
import bugs.NoneTerminationBug;
import bugs.NullPointerBug;
import building.Building;
import students.AllStudents;
import students.Student;
import students.Team;
import utils.Toolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Battle {

    Team team = null;
    Building building = null;
    BufferedReader bufferedReader;
    String fileName;
    int counter = 0;
    Toolbox toolbox = new Toolbox();

    public Battle(Team team, Building building, String fn) {
        fileName = fn;
        this.team = team;
        this.building = building;
        try {
            bufferedReader = new BufferedReader(new FileReader("bugs.txt"));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean fileIsReady() {
        try {
            String line;

            bufferedReader.mark(10000);
            line = bufferedReader.readLine();
            if (line == null) {
                return false;
            }
            bufferedReader.reset();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public int getCounter() {
        return counter;
    }

    public ArrayList<Bug> addWave() {
        ArrayList<Bug> waves = new ArrayList<>();
        if (fileIsReady()) {
            try {
                String line;
                    line = Files.readAllLines(Paths.get("bugs.txt")).get(counter);
                    counter++;
                    List<String> myList = (getTokens(line, ";"));
                    for(String token :myList) {
                        String[] splitLine = token.split("\\(");
                        String bugName = splitLine[0];
                        String[] splitLine2 = splitLine[1].split("\\)");
                        List<String> splitLine3 = (getTokens(splitLine2[0], ","));

                        String bugType = splitLine3.get(0);

                        int bugLevel = Integer.parseInt(splitLine3.get(1));
                        int bugSteps = Integer.parseInt(splitLine3.get(2));


                        if (bugType.equals("CMB")) {
                            ConcurrentModificationBug bug = new ConcurrentModificationBug(bugName, bugLevel, bugSteps);
                            building.addBug(bug);
                        } else if (bugType.equals("NTB")) {
                            NoneTerminationBug bug = new NoneTerminationBug(bugName, bugLevel, bugSteps);
                            building.addBug(bug);
                        } else if (bugType.equals("NPB")) {
                            NullPointerBug bug = new NullPointerBug(bugName, bugLevel, bugSteps);
                            building.addBug(bug);
                        }
                    }
            }
            catch (Exception e){
                System.out.println(e);
            }
        return waves;
        }




        return waves;
    }
    public static List<String> getTokens(String str, String param) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, param);
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    public void manageTeam()
    {
        int randomNumber = toolbox.getRandomInteger(100);

        if(((team.getTeamKnowledgePoints()>= team.getNewStudentCost()) && (randomNumber < 10)) || ((team.getStudents().size()==0) && (team.getTeamKnowledgePoints() >= team.getNewStudentCost()))) {
            team.recruitNewStudent();
            team.newStudentAnnouncement();
        }
        else if ((team.getTeamKnowledgePoints() > (int)(100 * Math.pow(2, team.getMaxStudentLevel()))) && (randomNumber > 9) && (randomNumber < 75) && (team.getStudents().size()>0)) {

            team.upgrade();
        }
        else if ((team.getTeamKnowledgePoints() < team.getNewStudentCost()) && team.getStudents().size() == 0){
            System.out.println("GAME OVER! The students have run out of knowledge points and have been defeated!");
            pause(5000);
            System.exit(0);
        }
        else {
            System.out.println("The team decides to save knowledge points for this round.");
            System.out.println("Current Team Knowledge Points: " + team.getTeamKnowledgePoints() + "\n");
        }

    }

    public void step()
    {
        building.getAllBugs();
        System.out.println("The students are now managing their team.\n");
        pause(3500);
        manageTeam();
        pause(3500);
        building.bugsMove();
        if(building.getBugSize()>0) {
            if(building.getBugSize()==1){
                System.out.println("1 BUG MOVES FORWARD 1 STEP\n");
            }
            else{
                System.out.println("ALL " + building.getBugSize() + " BUGS MOVE FORWARD 1 STEP");
            }

            System.out.println("The bug closest to the top floor is " + building.getLastBug().getName() + " on floor " + building.getLastBug().getCurrentFloor() + " and has " + building.getLastBug().getCurrentSteps() + " steps to get to the next floor!\n");
            pause(3500);
            System.out.println("ALERT! THE STUDENTS ATTACK THE BUGS TO DEFEND THE BUILDING!\n");
            team.allStudentsDefence();
            pause(2000);
        }

    }

    public void pause(int time)
    {
        try {
            Thread.sleep(time);
        } catch (Exception f) {
            System.out.println("error");
        }
    }
}
