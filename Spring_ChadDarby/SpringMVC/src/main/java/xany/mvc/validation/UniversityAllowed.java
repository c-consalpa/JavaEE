package xany.mvc.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniversityConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniversityAllowed {
    // value that is passed to the annotation
    public String value() default "TNU";

    // error message that validator returns
    public String message() default "existing university must be used";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
