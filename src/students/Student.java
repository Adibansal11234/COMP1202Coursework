package students;

import building.Building;

public interface Student {
    public int getLevel();
    public int upgradeCost();
    public int defence(Building building);
    public void increaseLevel();
    public String getType();
}
