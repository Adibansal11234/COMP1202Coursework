package students;

import bugs.Bug;
import building.Building;

import java.util.ArrayList;
import java.util.Collections;

import utils.Toolbox;

public class Team {
    int teamKnowledgePoints;
    int newStudentCost = 100;
    ArrayList<AllStudents> students = new ArrayList<AllStudents>();
    Toolbox toolbox = new Toolbox();
    Building building = null;
    int maxLevel = 0;

    //constructor for team
    public Team(int teamKnowledgePoints, Building building) {
        this.teamKnowledgePoints = teamKnowledgePoints;
        this.building = building;
    }

    //returns team knowledge points
    public int getTeamKnowledgePoints() {
        return teamKnowledgePoints;
    }

    //returns cost of recruiting new student
    public int getNewStudentCost() {
        return newStudentCost;
    }

    //method to recruit a new student, there is a 25% percent chance of recruiting each type of student
    //the cost starts at 100 and increases by 10 every time a new student is recruited
    //a student can only be recruited if the team has sufficient knowledge points
    public void recruitNewStudent() {
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
        } catch (Exception e) {
            System.out.println("Not enough knowledge points!");
        }
    }

    //method to upgrade a student, chooses a random student from the array of students and increases its level
    //this can only occur if the team has enough knowledge points
    //the higher level a student is, the more it costs to upgrade it to the next level
    public void upgrade() {
        try {
            int randomNumber = toolbox.getRandomInteger(students.size());

            Student student = students.get(randomNumber - 1);
            if (getTeamKnowledgePoints() > students.get(randomNumber - 1).upgradeCost()) {
                student.increaseLevel();
                teamKnowledgePoints = teamKnowledgePoints - students.get(randomNumber - 1).upgradeCost();
                System.out.println("The team has decided to upgrade an " + students.get(randomNumber - 1).getType() + " to level " + students.get(randomNumber - 1).getLevel() + " for " + students.get(randomNumber - 1).upgradeCost() + " knowledge points!\n");
                System.out.println("Students Alive:                " + students.size());
                System.out.println("Bugs Alive:                    " + building.getBugSize());
                System.out.println("Current Team Knowledge Points: " + getTeamKnowledgePoints() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Not enough knowledge points!");
        }
    }

    //returns array list of students
    public ArrayList<AllStudents> getStudents() {
        return students;
    }

    //returns the last student
    public Student getLastStudent() {
        try {
            return students.get(students.size() - 1);
        } catch (Exception e) {
            System.out.println("No students");
            return null;
        }
    }

    //announces that a new student has been recruited
    public void newStudentAnnouncement() {
        System.out.println("The team has decided to recruit a new " + getLastStudent().getType() + " for " + (newStudentCost - 10) + " knowledge points!\n");
        try {
            Thread.sleep(2500);
        } catch (Exception f) {
            System.out.println("error");
        }
        System.out.println("Students Alive:                " + students.size());
        System.out.println("Bugs Alive:                    " + building.getBugSize());
        System.out.println("Current Team Knowledge Points: " + getTeamKnowledgePoints() + "\n");
    }

    //method for all the students to defend the building and attack the bugs
    public void allStudentsDefence() {
        if (building.getBugSize() == 0) {
            return;
        }
        for (AllStudents student : students) {

            teamKnowledgePoints = teamKnowledgePoints + student.defence(student.building);
            if (building.getBugSize() == 0) {
                break;
            }

        }
    }

    //returns the highest student level
    public int getMaxStudentLevel() {
        for (AllStudents student : students) {
            int tempLevel = student.getLevel();
            if (tempLevel > maxLevel) {
                maxLevel = tempLevel;
            }
        }
        return maxLevel;
    }
}
