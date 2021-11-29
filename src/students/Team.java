package students;

import building.Building;
import java.util.ArrayList;
import utils.Toolbox;

public class Team
{
    int teamKnowledgePoints;
    int newStudentCost = 100;
    ArrayList<AllStudents> students = new ArrayList<AllStudents>();
    Toolbox toolbox = new Toolbox();
    Building building = null;
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
            if (probability <= 25 && teamKnowledgePoints > getNewStudentCost()) {
                CyberStudent cyberStudent = new CyberStudent(1, building);
                students.add(cyberStudent);
                teamKnowledgePoints = teamKnowledgePoints - getNewStudentCost();
                newStudentCost = newStudentCost + 10;
            } else if (probability > 25 && probability <= 50
                && teamKnowledgePoints > getNewStudentCost()) {
                CsStudent csStudent = new CsStudent(1, building);
                students.add(csStudent);
                teamKnowledgePoints = teamKnowledgePoints - getNewStudentCost();
                newStudentCost = newStudentCost + 10;
            } else if (probability > 50 && probability <= 75
                && teamKnowledgePoints > getNewStudentCost()) {
                AiStudent aiStudent = new AiStudent(1, building);
                students.add(aiStudent);
                teamKnowledgePoints = teamKnowledgePoints - getNewStudentCost();
                newStudentCost = newStudentCost + 10;
            } else if (probability > 75 && probability <= 100
                && teamKnowledgePoints > getNewStudentCost()) {
                {
                    SeStudent seStudent = new SeStudent(1, building);
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
            if(teamKnowledgePoints > 50)
            {

                int randomNumber = toolbox.getRandomInteger(students.size());

                Student student = students.get(randomNumber-1);
                student.increaseLevel();
                teamKnowledgePoints = teamKnowledgePoints - 50;
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
    public void allStudentsDefence()
    {
        for(AllStudents student : students)
        {
            System.out.println("Defence");
            student.defence(student.building);
            //student.getBuilding().getBug(1).damage(5);
        }
    }




}
