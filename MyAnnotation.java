/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

//We create our annotation interface -- it cannot be extended!
@interface BugReport
{
    //this annotation will have this two atributes
    String assignedTo() default "[none]";
    int severity() default 0;
}

public class Main
{
    @BugReport(assignedTo = "Different", severity = 10)
    private String diff1;
    @BugReport(assignedTo = "Different")
    private String defaultSeverity;
    @BugReport
    private String defaultBoth;
    
    private String diff;
    
    /*public void metodka(@BugReport Main this) //when we want to use this with annotation
    {
        this.diff = "TMP";
    }*/
    
	public static void main(String[] args) {
        
        
	}
}
