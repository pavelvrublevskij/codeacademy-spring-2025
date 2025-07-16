package lt.codeacademy.spring2025.core.validation.annotation.fieldsstringcompare;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import lt.codeacademy.spring2025.core.validation.annotation.fieldsstringcompare.impl.FieldsStringCompareValidator;


import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = { FieldsStringCompareValidator.class })
public @interface FieldsStringCompare {

  String message() default "{jakarta.validation.constraints.fields.compare.message}";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

  String firstField();
  String secondField();

  @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
  @Retention(RUNTIME)
  @Documented
  public @interface List {
    NotBlank[] value();
  }
}
