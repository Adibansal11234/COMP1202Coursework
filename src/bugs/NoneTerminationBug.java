package bugs;


public class NoneTerminationBug extends Bug {

    //constructor for the none termination bug
    public NoneTerminationBug(String name, int level, int initialSteps) {
        super(name, 200, 6, level, initialSteps);
        super.baseDamage = 4;
    }
}
