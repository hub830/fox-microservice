package top.lemna.core.constraint.commons;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NotNull
@Max(922337203685477580l)
@Min(1l)
@Constraint(validatedBy = {})
@Documented
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LongSn
{
    String message() default "错误的流水号格式";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}