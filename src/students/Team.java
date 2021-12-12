package students;

import bugs.Bug;
import building.Building;
import java.util.ArrayList;
import java.util.Collections;

import utils.Toolbox;

public class Team
{
    int teamKnowledgePoints;
    int newStudentCost = 100;
    ArrayList<AllStudents> students = new ArrayList<AllStudents>();
    Toolbox toolbox = new Toolbox();
    Building building = null;
    int maxLevel = 0;
    public Team(int teamKnowledgePoints, Building building)
    {
        this.teamKnowledgePoints = teamKnowledgePoints;
        this.building = building;
    }


    public int getTeamKnowledgePoints()
    {
        return teamKnowledgePoints;
    }

    public void addStudent(AllStudents student)
    {
        students.add(student);
    }
    public void studentsAct(Building building)
    {
        for(AllStudents student : students)
        {
            student.defence(building);
            teamKnowledgePoints = teamKnowledgePoints + student.knowledgePoints;

        }
    }
    public int getNewStudentCost()
    {
        return newStudentCost;
    }

    public void recruitNewStudent()
    {
        try {
            int probability = toolbox.getRandomInteger(100);
            if (probability <= 25 && teamKnowledgePoints >= getNewStudentCost()) {
                CyberStudent cyberStudent = new CyberStudent(1);
                cyberStudent.setBuilding(building);
                students.add(cyberStudent);
                teamKnowledgePoints = teamKnowledgePoints - getNewStudentCost();
                newStudentCost = newStudentCost + 10;
            } else if (probability > 25 && probability <= 50
                && teamKnowledgePoints >= getNewStudentCost()) {
                CsStudent csStudent = new CsStudent(1);
                csStudent.setBuilding(building);
                students.add(csStudent);
                teamKnowledgePoints = teamKnowledgePoints - getNewStudentCost();
                newStudentCost = newStudentCost + 10;
            } else if (probability > 50 && probability <= 75
                && teamKnowledgePoints >= getNewStudentCost()) {
                AiStudent aiStudent = new AiStudent(1);
                aiStudent.setBuilding(building);
                students.add(aiStudent);
                teamKnowledgePoints = teamKnowledgePoints - getNewStudentCost();
                newStudentCost = newStudentCost + 10;
            } else if (probability > 75 && probability <= 100
                && teamKnowledgePoints >= getNewStudentCost()) {
                {
                    SeStudent seStudent = new SeStudent(1);
                    seStudent.setBuilding(building);
                    students.add(seStudent);
                    teamKnowledgePoints = teamKnowledgePoints - getNewStudentCost();
                    newStudentCost = newStudentCost + 10;
                }
            }
        }

        catch(Exception e)
        {
            System.out.println("Not enough knowledge points!");
        }

    }

    public void upgrade()
    {
        try
        {
                int randomNumber = toolbox.getRandomInteger(students.size());

                Student student = students.get(randomNumber-1);
                if(getTeamKnowledgePoints() > students.get(randomNumber-1).upgradeCost()) {
                    student.increaseLevel();
                    teamKnowledgePoints = teamKnowledgePoints - students.get(randomNumber-1).upgradeCost();
                    System.out.println("ALERT! " + students.get(randomNumber-1).getType() + " was successfully upgraded to level " + students.get(randomNumber-1).getLevel() + " for " + students.get(randomNumber-1).upgradeCost() + " knowledge points!");
                    System.out.println("Current Team Knowledge Points: " + getTeamKnowledgePoints() + "\n");
                }
        }
        catch(Exception e)
        {
            System.out.println("Not enough knowledge points!");
        }
    }
    public ArrayList<AllStudents> getStudents()
    {
        return students;
    }

    public void printStudents()
    {
        for(AllStudents student : students)
        {
            System.out.println(student);
        }
    }

    public Student getLastStudent()
    {
        try {
            return students.get(students.size()-1);
        }
        catch (Exception e)
        {
            System.out.println("No students");
            return null;
        }
    }

    public void newStudentAnnouncement()
    {
        System.out.println("The team has decided to recruit a new " + getLastStudent().getType() + " for " + (newStudentCost-10) + " knowledge points!");
        System.out.println("Students Alive: " + students.size());
        System.out.println("Current Team Knowledge Points: " + getTeamKnowledgePoints() + "\n");
    }
    public void studentUpgradeAnnouncement()
    {

    }
    public void allStudentsDefence()
    {
        for(AllStudents student : students)
        {
            if(building.getBugSize() == 0){
                break;
            }
            teamKnowledgePoints = teamKnowledgePoints + student.defence(student.building);

        }
    }

    public int getMaxStudentLevel()
    {
        for(AllStudents student : students)
        {
            int tempLevel = student.getLevel();
            if (tempLevel > maxLevel){
                maxLevel = tempLevel;
            }
        }
        return maxLevel;


    }




}
