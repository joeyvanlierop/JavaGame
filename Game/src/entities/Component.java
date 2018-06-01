package entities;

import java.util.UUID;

public abstract class Component
{
    //https://github.com/libgdx/ashley/tree/master/ashley/src/com/badlogic/ashley
    //https://en.wikipedia.org/wiki/Composition_over_inheritance
    //https://en.wikipedia.org/wiki/Entity-component-system
    //https://cbpowell.wordpress.com/2012/12/06/entity-component-game-programming-using-jruby-and-libgdx-part-3/

    private final UUID ID;

    public Component()
    {
        this.ID = UUID.randomUUID();
    }

    @Override
    public String toString()
    {
        return String.format("#%s: %s", ID.toString(), this.getClass().getName());
    }
}
