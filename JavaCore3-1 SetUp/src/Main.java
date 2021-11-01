import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder temp = new StringBuilder();
        String isCreated = null;
        String isNotCreated = null;

        String[] paths = {
            "F://Games/src",
            "F://Games/src/main",
            "F://Games/src/test",
            "F://Games/res",
            "F://Games/res/drawables",
            "F://Games/res/vectors",
            "F://Games/res/icons",
            "F://Games/savegames",
            "F://Games/temp",
        };

        for (String path : paths) {
            File dir = new File(path);
            if (dir.mkdirs()) {
                isCreated = ("Каталог создан по адресу: " + path + "\r\n");
                System.out.print(isCreated);
                temp.append(isCreated);
            } else {
                isNotCreated = ("Каталог не удалось создать по адресу: " + path + "\r\n");
                temp.append(isNotCreated);
            }
        }

        String[] pathsFiles = {
                "F://Games/src/main/Main.java",
                "F://Games/src/main/Utils.java",
                "F://Games/temp/temp.txt",
        };

        for (String path : pathsFiles) {
            File file = new File(path);
            try {
                if (file.createNewFile()) {
                    isCreated = ("Файл был создан по адресу: " + path + "\r\n");
                    System.out.print(isCreated);
                    temp.append(isCreated);
                } else {
                    isNotCreated = ("Файл не удалось создать по адресу: " + path + "\r\n");
                    temp.append(isNotCreated);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }


        try(FileWriter writer = new FileWriter("F://Games/temp/temp.txt", false))
        {
            String string = temp.toString();
            writer.write(string);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

