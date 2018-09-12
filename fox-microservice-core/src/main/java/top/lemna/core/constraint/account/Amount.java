package top.lemna.core.constraint.account;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@NotNull
@Digits(integer = 10, fraction = 2)
@Constraint(validatedBy = {})
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Amount {
	String message() default "错误的金额";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}