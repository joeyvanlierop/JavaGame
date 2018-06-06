package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Manages Entities And Stores Entity-Component Pool
 * Singleton (Prone To Change In The Future)
 *
 * https://cbpowell.wordpress.com/2012/10/30/entity-component-game-programming-using-jruby-and-libgdx-part-1/
 * https://github.com/JamesMcMahon/entitas-2d-roguelike/blob/master/Assets/Sources/Features/Input/InputSystem.cs
 * https://github.com/ClickerMonkey/Ents/blob/master/Java/src/org/magnos/entity/
 * https://www.gamedev.net/articles/programming/general-and-gameplay-programming/understanding-component-entity-systems-r3013/
 */
public final class EntityManager
{
    /**
     * Outer HashMap Key Is Component Class, Value Is Inner HashMap
     * Inner HashMap Key Is Entity UUID, Value Is List Of Component Objects (Type Of Outer HashMap Key)
     */
    private static HashMap<Class<? extends Component>, HashMap<UUID, ArrayList<Component>>> componentPool = new HashMap<>();

    /**
     * HashMap Key Is Entity UUID, Value Is Entity Tag
     */
    private static HashMap<UUID, String> entityTags = new HashMap<>();

    /**
     * Creates An Entity With Empty Tag
     * An Entity Is Just An UUID That Can Be Linked To Components In {@link #componentPool}
     *
     * @return UUID Of Created Entity
     */
    public static UUID createEntity()
    {
        return createTaggedEntity("");
    }

    /**
     * Creates An Entity With A Tag
     * An Entity Is Just An UUID That Can Be Linked To Components In {@link #componentPool}
     *
     * @return UUID Of Created Entity
     */
    public static UUID createTaggedEntity(String tag)
    {
        UUID ID = UUID.randomUUID();

        entityTags.put(ID, tag);

        return ID;
    }

    /**
     * Destroys Entity By Removing All References Of Its UUID In {@link #componentPool}
     *
     * @param ID
     */
    public static void destroyEntity(UUID ID)
    {
        for(HashMap IDS : componentPool.values())
        {
            IDS.remove(ID);
        }
    }

    /**
     * Links Component Object To Entity
     *
     * @param ID UUID Of Entity That Component Is Being Added To
     * @param component Component Object That Is Being Added To Entity
     */
    public static void addComponent(UUID ID, Component component)
    {
        // Instantiate Keys If Absent
        componentPool.putIfAbsent(component.getClass(), new HashMap<>());
        componentPool.get(component.getClass()).putIfAbsent(ID, new ArrayList<>());

        // Link Component To ID
        componentPool.get(component.getClass()).get(ID).add(component);
    }

    /**
     * Links Component Object To Entity If Entity Is Not Already Linked To One Of The Same Type
     *
     * @param ID UUID Of Entity That Component Is Being Added To
     * @param component Component Object That Is Being Added To Entity
     */
    public static void addSingletonComponent(UUID ID, Component component)
    {
        if(!hasComponent(ID, component.getClass()))
        {
            addComponent(ID, component);
        }
        else
        {
            java.lang.System.out.println("SingletonComponent Already Exists");
        }
    }

    /**
     * Checks If Entity Is Linked To A Component Of A Specific Type
     *
     * @param ID UUID Of Entity That Is Being Checked
     * @param component Class Of Component Whose Presence Is Being Tested
     * @return
     */
    public static boolean hasComponent(UUID ID, Class<? extends Component> component)
    {
        if(componentPool.containsKey(component))
        {
            return componentPool.get(component).containsKey(ID);
        }

        return false;
    }

    /**
     * Returns First Component Of Type Linked To An Entity
     * Currently Does Not Check If Entity Has Component Because I Am Lazy
     *
     * @param ID UUID Of Entity That Is Linked To Component
     * @param component Component Type To Return
     * @return Component Of Type Linked To Entity
     */
    public static Component getComponent(UUID ID, Class<? extends Component> component)
    {
        return componentPool.get(component).get(ID).get(0);
    }

    /**
     * Returns List Of Components Of Type Linked To Entity
     * Currently Does Not Check If Entity Has Component Because I Am Lazy
     *
     * @param ID UUID Of Entity That Is Linked To Components
     * @param component Component Type To Return
     * @return ArrayList Of Components Of Type Linked To Entity
     */
    public static ArrayList<Component> getComponents(UUID ID, Class<? extends Component> component)
    {
        return componentPool.get(component).get(ID);
    }

    /**
     * Returns A List Of Entities That Are Each Linked To Every Component Class Provided As A Parameter
     *
     * @param components Component Classes That Entities Are Being Checked For Existence
     * @return ArrayList Populated With UUIDS Of Entites WIth Every Component Class Provided As A Parameter
     */
    public static ArrayList<UUID> getEntityGroup(Class<? extends Component>... components)
    {
        ArrayList<UUID> entityGroup = new ArrayList<>(entityTags.keySet());
        ArrayList<UUID> entitiesToRemove = new ArrayList<>();

        for(Class<? extends Component> component : components)
        {
            if(componentPool.containsKey(component))
            {
                for(UUID ID : componentPool.get(component).keySet())
                {
                    if(!entityGroup.contains(ID))
                    {
                        entitiesToRemove.add(ID);
                    }
                }
            }
            else
            {
                entityGroup.clear();

                return entityGroup;
            }
        }

        entityGroup.removeAll(entitiesToRemove);

        return entityGroup;
    }
}
