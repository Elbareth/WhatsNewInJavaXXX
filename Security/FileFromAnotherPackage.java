//Pay attention that this class has the same name as the class where it will be loaded!
//It is possbile thanks to different system loader procedure
public class FileFromAnotherPackage
{
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}