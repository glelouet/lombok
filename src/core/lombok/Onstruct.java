package lombok;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@link Onstruct} annotation declares variables based on getters of an
 * object.<br />
 * The variables names are the one specified. If the annotation has parameters for prefix and suffix, those parameters are added to the variable names.<br />
 * The getter is the existing method in the object's class verifying
 * <ol>
 * 	<li>return non-void type</li>
 *  <li>requires no argument</li>
 * 	<li>match the variable name specified, prefixed by get|is, and ignoring case. In the order : 
 * 		<ol>
 * 			<li>getName is selected if exists</li>
 * 			<li>isName is selected if exists</li>
 * 			<li>getname (ignoring case) is selected if exists only ONE. compiling error if several found</li>
 * 			<li>isname (ignoring case) is selected if exists only ONE. compiling error if several found</li>
 * 			<li>if no matching method exists, error</li>	
 * 		</ol>
 * 	</li>
 * </ol>  
 * 
 * <p>
 * It MUST only be applied to var declarations.
 * </p>
 *
 * 
 * <p>
 * Before:
 *
 * <pre>
 * &#064;Onstruct(prefix="b_")
 * var author, name=mybook;
 * </pre>
 *
 * After:
 *
 * <pre>
 * var b_author = mybook.getAuthor();
 * var b_name = mybook.getName();
 * </pre>
 *
 */
@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.SOURCE)
public @interface Onstruct {

	String prefix() default "";

	String suffix() default "";

}
