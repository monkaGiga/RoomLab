package Items.Food;

import People.Person;

public class Apple implements consume {
    @Override
    public void eat(Person p)
    {
        p.restoreHealth(5);
        p.gainSpeed(2);
        p.gainStatus(sated);
    }
}
