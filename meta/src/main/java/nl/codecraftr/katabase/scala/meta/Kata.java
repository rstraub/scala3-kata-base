package nl.codecraftr.katabase.scala.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URI;

/**
 * Idea!
 * <p>
 * Use annotations to tie the url to a solution of a kata. This can feed into
 * creating an overview page of all kata's I've done. It can also feed into
 * doing some analytics (e.g. no of kata's).
 * <p>
 * Both could be automated by the CI/CD pipeline and thus kept in sync.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Kata {
    String url() default "";
}
