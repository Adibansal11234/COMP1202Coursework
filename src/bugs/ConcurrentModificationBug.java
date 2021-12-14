package bugs;

public class ConcurrentModificationBug extends Bug {

    //constructor for the concurrent modification bug
    public ConcurrentModificationBug(String name, int level, int initialSteps) {
        super(name, 20, 4, level, initialSteps);
        super.baseDamage = 2;
    }

}
