import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        openZip("F:\\Games\\savegames\\savegames.zip", "F:\\Games\\savegames\\");
        System.out.println(openProgress("F:\\Games\\savegames\\Save3.dat"));
    }

    public static void openZip(String pathZip, String pathUnZip) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZip))) {
            ZipEntry entry;
            String name;
            int count;
            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fos = new FileOutputStream(pathUnZip + name);
                while ((count = zis.read()) != -1) {
                    fos.write(count);
                }
                fos.flush();
                zis.closeEntry();
                fos.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static GameProgress openProgress(String path) {
        GameProgress gameProgress;
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream obis = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) obis.readObject();
            return gameProgress;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
