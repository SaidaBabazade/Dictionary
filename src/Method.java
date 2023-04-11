import java.io.*;
import java.util.*;

public class Method {

    private static final String All_DICT_PATH = "DictFile.txt";

    public static void createNewDictionary(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(All_DICT_PATH));
        List<String> list = new LinkedList<>();
        while (br.ready()) {
            String data = br.readLine();
            list.add(data);
        }
        if (list.contains(fileName)) {
            System.out.println("The dictionary is already exists");
            return;
        } else {
            FileWriter fw = new FileWriter(fileName + ".txt");
            System.out.println("The dictionary successfuly created");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(All_DICT_PATH, true))) {
                bw.write(fileName);
                bw.newLine();
            }
        }

    }

    public static void addToDictionary(String firstWord, String secondWord, String fileName) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + ".txt", true))) {
            bw.write(firstWord + "-" + secondWord);
            bw.newLine();
        }
    }

    public static Set<String> seeAllDictionaryList() throws Exception {
        Set<String> dictSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(All_DICT_PATH));
        while (br.ready()) {
            String data = br.readLine();
            dictSet.add(data);
        }
        return dictSet;
    }

    public static void delete(String word, String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
        Map<String, String> dictMap = new HashMap<>();
        while (br.ready()) {
            String data = br.readLine();
            if (data != null && !data.isEmpty()) {
                String[] dataParse = data.split("-");
                dictMap.put(dataParse[0], dataParse[1]);
                //dictMap.put(dataParse[1], dataParse[0]);
            }
        }
        FileUtility.writeToFileFalse(fileName, "");
        Set<String> keySet = dictMap.keySet();
        if (keySet.contains(word)) {
            dictMap.remove(word);
            for (Map.Entry<String, String> entry : dictMap.entrySet()) {
                FileUtility.writeToFileTrue(fileName, entry.getKey() + "-" + entry.getValue());
            }
            System.out.println("The word deleted successfuly!!");
            //dictMap.clear();
        } else {
            System.out.println("Not found!!!");
        }

    }

    public static void update(String word, String newValue, String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
        Map<String, String> dictMap = new HashMap<>();
        while (br.ready()) {
            String data = br.readLine();
            if (data != null && !data.isEmpty()) {
                String[] dataParse = data.split("-");
                dictMap.put(dataParse[0], dataParse[1]);
//            dictMap.put(dataParse[1], dataParse[0]);
            }
        }
        FileUtility.writeToFileFalse(fileName, "");
        Set<String> keySet = dictMap.keySet();
        List<String> keysList = new ArrayList<>();
        keysList.addAll(keySet);

        Collection<String> values = dictMap.values();
        List<String> valuesList = new ArrayList<>();
        valuesList.addAll(values);
        if (keysList.contains(word)) {
            keysList.set(keysList.indexOf(word), newValue);
        }
        if (valuesList.contains(word)) {
            valuesList.set(valuesList.indexOf(word), newValue);
        }
        for (int i = 0; i < dictMap.size(); i++) {
            String text = keysList.get(i) + "-" + valuesList.get(i);
            FileUtility.writeToFileTrue(fileName, text);

        }
//        if (keySet.contains(word)) {
//            dictMap.replace(word, newValue);
//            for (Map.Entry<String, String> entry : dictMap.entrySet()) {
//                FileUtility.writeToFileTrue(fileName, entry.getKey() + "-" + entry.getValue());
//            }
//            System.out.println("success");
//        } else {
//            System.out.println("Not found");
//        }

    }

    public static String translate(String word, String fileName) throws Exception {
        Map<String, String> dictMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
        String result = null;
        while (br.ready()) {
            String data = br.readLine();
            String[] dataParse = data.split("-");
            dictMap.put(dataParse[0], dataParse[1]);
            dictMap.put(dataParse[1], dataParse[0]);
        }
        if (dictMap.containsKey(word)) {
            result = dictMap.get(word);

        } else {
            result = "Not found!";
        }
        dictMap.clear();

        return result;
    }
    public static boolean isDictExist(String firstLang, String secondLang) throws Exception {
        try (BufferedReader bw = new BufferedReader(new FileReader(All_DICT_PATH))) {
            while (bw.ready()) {
                String data = bw.readLine();
                String[] dataParse = data.split("-");
                if (firstLang.equals(dataParse[0]) && secondLang.equals(dataParse[1])) {
                    return true;
                }
            }

        }
        return false;
    }
}
