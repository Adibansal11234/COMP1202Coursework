package bugs;

public class NullPointerBug extends Bug {

    //constructor for the null pointer bug
    public NullPointerBug(String name, int level, int initialSteps) {
        super(name, 10, 2, level, initialSteps);
        super.baseDamage = 1;
    }
}
