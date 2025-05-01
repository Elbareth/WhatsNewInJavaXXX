//We create the module. We have to name it
//Remember to add appropriate configuration into project settings
module ModuleTwo
{
    //We can export the module so another modules can use it
    exports org.example.two;
    //We can import another module to our project
    requires ModuleOne;
}