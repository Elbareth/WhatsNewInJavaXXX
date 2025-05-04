import org.example.child_classes.MainClass1;
import org.example.child_classes.MainClass2;
import org.example.child_classes.MainClass3;
import org.example.interfaces.MainInterface;

module InheritModule
{
    //We have an interface and some classes with implementation - we want to export it
    //We NOT export the implementation!
    //To use the implementation, we have to use ServiceLoader
    exports org.example.interfaces;
    provides MainInterface with
            MainClass1,
            MainClass2,
            MainClass3;
}