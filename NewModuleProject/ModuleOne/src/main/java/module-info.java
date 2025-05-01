//We have to name our module
//Remember to add appropriate configuration into project settings
/*open*/ module ModuleOne //We can also open entire model for reflection
{
    //We can export our module only to specific modules
    exports org.example.one to ModuleTwo;
    //it allows the another module to use reflection - single package
    opens org.example.one;
}