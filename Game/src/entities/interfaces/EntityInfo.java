package entities.interfaces;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface EntityInfo {
    String name = "Undefined";
}
