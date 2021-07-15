package xany.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class UniversityConstraintValidator implements ConstraintValidator<UniversityAllowed, String> {

   List<String> registeredUniversities = Arrays.asList("SEVNTU", "TNU", "HUEU");
   String universityConstraint;
   public void initialize(UniversityAllowed constraint) {
      universityConstraint = constraint.value();
   }
   //
   public boolean isValid(String university2Validate, ConstraintValidatorContext context) {

      System.out.println(registeredUniversities.contains(university2Validate));
      return registeredUniversities.contains(university2Validate);
   }
}
