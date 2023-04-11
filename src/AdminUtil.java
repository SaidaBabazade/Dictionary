import java.io.*;
import java.util.*;
public class AdminUtil {
    private static final String LOG_PATH = "AdminFile";
    public static boolean loginAdmin(String username, String password) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(LOG_PATH));
        while (br.ready()) {
            String data = br.readLine();
            String[] dataParse = data.split("-");
            if (username.equalsIgnoreCase(dataParse[0]) && password.equals(dataParse[1])) {
                return true;
            }
        }
        return false;
    }

    public static void adminMethod() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();
        if (loginAdmin(username, password)) {
            System.out.println("Welcome our dıctıonary!");
            System.out.println("There are some methods.Enter your choice:\n"
                    + "1.Create new dictionary\n"
                    + "2.Add new word to the dictionary\n"
                    + "3.Delete a word from the dictionary\n"
                    + "4.Update the word");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Create new dictionary.");
                    String fileName = sc.next();
                    System.out.println("Enter firstLang");
                    String firstLang = sc.next();
                    System.out.println("Enter secondLang");
                    String secondLang = sc.next();
                    if (Method.isDictExist(firstLang, secondLang)) {
                        System.out.println("Bele bir  luget var.");
                    } else {
                        Method.createNewDictionary(fileName);
                        System.out.println("The dictionary has been successfully created!");
                    }
                    Method.createNewDictionary(fileName);
                    break;
                case 2:
                    System.out.println("Which dictionary do you want to add to?");
                    System.out.println(Method.seeAllDictionaryList());
                    String filename = sc.next();
                    System.out.println("Enter first word:");
                    String azWord = sc.next();
                    System.out.println("Enter second word:");
                    String engWord = sc.next();
                    Method.addToDictionary(azWord, engWord, filename);
                    break;
                case 3:
                    System.out.println("The available dictionaries are as follows ");
                    Set<String> resultDict = Method.seeAllDictionaryList();
                    for (String dict : resultDict) {
                        System.out.println(dict);
                    }
                    System.out.println("Which dictionary do you want to delete from?");
                    String FileName = sc.next();
                    System.out.println("Which word want you to delete? Please enter");
                    String word = sc.next();
                    Method.delete(word, FileName);
                    break;
                case 4:
                    System.out.println("The available dictionaries are as follows ");
                    Set<String> resultDicts = Method.seeAllDictionaryList();
                    for (String dict : resultDicts) {
                        System.out.println(dict);
                    }
                    System.out.println("In which dictionary do you want to update?");
                    String dictName = sc.next();
                    System.out.println("Which word want you update? Enter the word");
                    String wordUpdate = sc.next();
                    System.out.println("Enter new Value");
                    String newValue = sc.next();

                    Method.update(wordUpdate, newValue, dictName);
                    break;
                default:
                    System.err.println("Invalid methods");
            }
        } else {
            System.err.println("Your username or password is wrong!");
        }

    }
}
