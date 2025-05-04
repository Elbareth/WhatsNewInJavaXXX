import org.example.interfaces.MainInterface;

//We have to name our module
//Remember to add appropriate configuration into project settings
module ModuleThree
{
    //We will only import one module into our project
    //transitive - it requires also child modules
    //static - module has to be available during compilation time; however it is optional during runtime
    requires transitive static ModuleTwo;
    requires InheritModule;
    uses MainInterface; //We want to use the interface and available implementation
}