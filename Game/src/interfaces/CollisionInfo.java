package interfaces;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CollisionInfo {
    int collisionBoxWidth();

    int collisionBoxHeight();
}
