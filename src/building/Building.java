package building;

import bugs.Bug;

import java.util.ArrayList;
import java.util.Collections;

public class Building {
    int constructionPoints;
    int topFloor;
    ArrayList<Bug> bugs = new ArrayList<Bug>();

    //constructor for building
    public Building(int topFloor, int constructionPoints) {
        this.topFloor = topFloor;
        this.constructionPoints = constructionPoints;
    }

    //returns top floor
    public int getTopFloor() {
        return topFloor;
    }

    //returns construction points
    public int getConstructionPoints() {
        return constructionPoints;
    }

    //method to sort the array of bugs and returns the bugs in the building (those which are on floor 0 or above)
    public Bug[] getAllBugs() {
        Collections.sort(bugs);
        ArrayList<Bug> bugsInBuilding = new ArrayList<Bug>();
        for (Bug bug : bugs) {
            if ((bug.getCurrentFloor() > -1) && bug.getCurrentHp() > 0) {
                bugsInBuilding.add(bug);
            } else if (bug.getCurrentHp() < 1) {
                bugsInBuilding.remove(bug);
            }
        }
        Collections.sort(bugs);
        return (Bug[]) bugsInBuilding.toArray(new Bug[0]);
    }

    //method to add bugs to the array, if the bug is already in the building, it returns -1
    public int addBug(Bug bug) {
        if (bug.getCurrentFloor() > -1 || bugs.contains(bug)) {
            return -1;
        } else {
            bugs.add(bug);
            return bugs.size();
        }
    }

    //method to remove bug from the building
    public void removeBug(Bug bug) {
        bugs.remove(bug);
    }

    //method to cycle through the array of bugs and move each one by 1 step,
    // if a bug reaches the top floor, it damages the building and is removed from the building
    public void bugsMove() {
        Bug bugToRemove = null;
        try {
            for (Bug bug : bugs) {
                bug.move();
                if (bug.getCurrentFloor() == getTopFloor()) {
                    constructionPoints = constructionPoints - (bug.getBaseDamage());
                    bugToRemove = bug;
                    System.out.println(bug.getName() + " Reached the top floor, doing " + bug.getBaseDamage() + " damage!");
                    System.out.println("Building Construction Points Remaining: " + constructionPoints + "\n");
                }
                if (constructionPoints < 1) {
                    System.out.println("\nTHE BUILDING HAS BEEN OVERRUN BY THE BUGS. BETTER LUCK NEXT TIME...");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("something");
        } finally {
            if (bugToRemove != null) {
                bugs.remove(bugToRemove);
            }
        }
    }

    //method to return the last bug, which is the one closest to the top floor of the building
    public Bug getLastBug() {
        try {
            return bugs.get(0);
        } catch (Exception e) {
            System.out.println("get last bug error");
            return null;
        }
    }

    //method to return a bug from the array of position of the integer which is passed
    public Bug getBug(int size) {
        try {
            return bugs.get(size - 1);
        } catch (Exception e) {
            System.out.println("get bug error");
            return null;
        }
    }

    //method to return the number of bugs in and out of the building
    public int getBugSize() {
        return bugs.size();
    }


}
