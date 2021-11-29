import bugs.ConcurrentModificationBug;
import bugs.NoneTerminationBug;
import bugs.NullPointerBug;
import building.Building;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import students.Team;

public class EcsBuildingDefence
{
    public static void main (String[] args)
    {
        int topFloor = Integer.parseInt(args[0]);
        int constructionPoints = Integer.parseInt(args[1]);
        Building building = new Building(topFloor, constructionPoints);
        String fileName = args[2];
        int teamKnowledgePoints =  Integer.parseInt(args[3]);
        Team team = new Team(teamKnowledgePoints, building);


        try{
        BufferedReader br = new BufferedReader(new FileReader(fileName));

                String line;
                while ((line = br.readLine()) != null) {
                    // process the line.

                    List<String> myList = (getTokens(line, ";"));
                    for(String token : myList)
                    {
                        //System.out.println(token);
                        String[] splittedLine = token.split("\\(");
                        String[] splittedLine2 = splittedLine[1].split("\\)");
                        String bugName = splittedLine[0];
                        List<String> splittedLine3 = (getTokens(splittedLine2[0], ","));
                        String bugType = splittedLine3.get(0);
                        int level = Integer.parseInt(splittedLine3.get(1));
                        int steps = Integer.parseInt(splittedLine3.get(2));
                        //System.out.println("Name: " + bugName + "  Type: " + bugType + "  Level: " + level + "  Steps: " + steps);

                        if(bugType.equals("CMB"))
                        {
                            ConcurrentModificationBug bug = new ConcurrentModificationBug(bugName,level,steps);
                            building.addBug(bug);
                        }
                        else if(bugType.equals("NTB"))
                        {
                            NoneTerminationBug bug = new NoneTerminationBug(bugName,level,steps);
                            building.addBug(bug);
                        }
                        else if(bugType.equals("NPB"))
                        {
                            NullPointerBug bug = new NullPointerBug(bugName,level,steps);
                            building.addBug(bug);
                        }
                    }
                    team.recruitNewStudent();
                    System.out.println(teamKnowledgePoints);
                    System.out.println(team.getStudents());
                    building.bugsMove();
                    building.bugsMove();
                    //System.out.println(building.getAllBugs());
                    team.allStudentsDefence();
                    //System.out.println(building.getBug(1));


                }



        }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("Error!");
            }


    }
    public static List<String> getTokens(String str, String param) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, param);
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

}
