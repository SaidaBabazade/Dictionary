import java.util.*;

public class UserUtil {

    public static void userMethod() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("What want yo to do? "
                + "\n1.search\n2.All dictionary to see");
        switch (sc.nextInt()) {
            case 1:
                System.out.println("The available dictionaries are as follows ");
                Set<String> resultDicts = Method.seeAllDictionaryList();
                for (String dict : resultDicts) {
                    System.out.println(dict);
                }
                System.out.println("Enter dictionary name");
                String dictName = sc.next();
                System.out.println("Enter a word, which want you to search");
                String word = sc.next();
                String result = Method.translate(word, dictName);
                System.out.println(result);
                break;
            case 2:
                System.out.println("The available dictionaries are as follows ");
                Set<String> resultDict = Method.seeAllDictionaryList();
                for (String dict : resultDict) {
                    System.out.println(dict);
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

}
