package common.annotation;


import common.config.pool.AppThreadPoolConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Import(AppThreadPoolConfiguration.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface EnableThreadPool {
}
