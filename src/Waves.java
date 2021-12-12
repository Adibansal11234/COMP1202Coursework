public class Waves
{
    String name;
    String type;
    int level;
    int steps;

    public Waves(String n, String t, int l, int s){
        name = n;
        type = t;
        level = l;
        steps = s;
    }

    public Waves(String n) {
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getSteps() {
        return steps;
    }
}
