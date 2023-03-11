package de.hsos.ordermanagement.utils.id;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.PARAMETER,
        ElementType.TYPE
})
public @interface IdGenerationQualifier {
    IdGenerationType type() default IdGenerationType.ORDER;
}
