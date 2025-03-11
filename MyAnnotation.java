/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

//import jakarta.annotation.*;
import java.lang.annotation.*;

//We create our annotation interface -- it cannot be extended!
@Target ({
    ElementType.ANNOTATION_TYPE, //we an use annotation on another annotation
    ElementType.PACKAGE,         //we can use annotation on PACKAGE
    ElementType.TYPE,            //we can use annotation on types of the fields, for example on int, String etc.
    ElementType.METHOD,          //we can use annotation on METHOD
    ElementType.CONSTRUCTOR,     //we can use annotation on constructor
    ElementType.FIELD,           //we can use annotation on fields within the classes
    ElementType.PARAMETER,       //we can use annotation on parameter within the METHOD
    ElementType.LOCAL_VARIABLE,   //we can use annotation on local variable within the method
    ElementType.TYPE_PARAMETER,
    ElementType.TYPE_USE
})//where annotation can be used?
@Retention(RetentionPolicy.RUNTIME) //how long an annotation lives?
//RetentionPolicy.RUNTIME -- we have annotation in code file and annotations are loaded by JVM
//RetentionPolicy.CLASS   -- we have annotation in code file but annotations are NOT loaded by JVM
//RetentionPolicy.SOURCE  -- we have NOT annotation in code file AND it is NOT loaded by JVM
@Documented //should we document annotation?
@Repeatable(AnotherBugReport.class) //annotation can be used multiple times on the same element
@Inherited // the children classes should inherit all annotations after the parent class
@interface BugReport
{
    //this annotation will have this two atributes
    String assignedTo() default "[none]";
    int severity() default 0;
}

@Target ({
    ElementType.ANNOTATION_TYPE, //we an use annotation on another annotation
    ElementType.PACKAGE,         //we can use annotation on PACKAGE
    ElementType.TYPE,            //we can use annotation on types of the fields, for example on int, String etc.
    ElementType.METHOD,          //we can use annotation on METHOD
    ElementType.CONSTRUCTOR,     //we can use annotation on constructor
    ElementType.FIELD,           //we can use annotation on fields within the classes
    ElementType.PARAMETER,       //we can use annotation on parameter within the METHOD
    ElementType.LOCAL_VARIABLE,   //we can use annotation on local variable within the method
    ElementType.TYPE_PARAMETER,
    ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface AnotherBugReport
{
    BugReport[] value();
}

@FunctionalInterface //it check the functional interface - the interface contains only one abstract method
interface functionalInterface
{
    String method1(String arg);
}


public class Main
{
    @BugReport(assignedTo = "Different", severity = 10)
    private String diff1;
    @BugReport(assignedTo = "Different")
    private String defaultSeverity;
    @BugReport
    private String defaultBoth;
    /*@Resource(name = "jdbc/mysql")
    private String mySecretData;*/ //value injection jakarta
    
    private String diff;
    
    @SuppressWarnings(value = "unchecked") // it disable the warnings
    private String tmp;
    
    public void metodka(@BugReport Main this) //when we want to use this with annotation
    {
        this.diff = "TMP";
    }
    
    @SafeVarargs //it take care of multi arguments - thants to it it is safe - it has to be private OR fianl
    private final void multiArgs (String... args)
    {
        System.out.println(args);
    }
    
    /*@PostConstruct // this method will be called just after creation of the object
    public void justAfeterCreation(String abs)
    {
        System.out.println("On object creation");
    }
    
    @PreDestroy // this method will be called just before deletion of the object
    public void justBeforeDeletion(String abc)
    {
        System.out.println("On object deletion");
    }*/ // <-- this part of the code works only for jakarta 
    //https://www.baeldung.com/spring-postconstruct-predestroy
    
	public static void main(String[] args) {
        
        
	}
}
