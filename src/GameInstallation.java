import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GameInstallation {

    private static final String GAMES_DIRECTORY = "C://Games"; // путь к папке Games
    private static final String LOG_FILE = GAMES_DIRECTORY + "/temp/temp.txt"; // путь к файлу лога

    private static final ArrayList<String> DIRECTORIES_TO_CREATE = new ArrayList<>() {{
        add(GAMES_DIRECTORY);
        add(GAMES_DIRECTORY + "/src");
        add(GAMES_DIRECTORY + "/res");
        add(GAMES_DIRECTORY + "/savegames");
        add(GAMES_DIRECTORY + "/temp");
        add(GAMES_DIRECTORY + "/src/main");
        add(GAMES_DIRECTORY + "/src/test");
        add(GAMES_DIRECTORY + "/res/drawables");
        add(GAMES_DIRECTORY + "/res/vectors");
        add(GAMES_DIRECTORY + "/res/icons");
    }};

    private static final ArrayList<String> FILES_TO_CREATE = new ArrayList<>() {{
        add(GAMES_DIRECTORY + "/src/main/Main.java");
        add(GAMES_DIRECTORY + "/src/main/Utils.java");
        add(GAMES_DIRECTORY + "/temp/temp.txt");
    }};

    private static final StringBuilder logBuilder = new StringBuilder(); // строка для логирования

    public static void main(String[] args) {
        createDirectories();
        createFiles();
        writeLogToFile();
    }

    private static void createDirectories() {
        for (String dir : DIRECTORIES_TO_CREATE) {
            File directory = new File(dir);
            if (directory.mkdir()) {
                logBuilder.append("Папка успешно создана: ").append(dir).append("\n");
            } else {
                logBuilder.append("Не удалось создать папку: ").append(dir).append("\n");
            }
        }
    }

    private static void createFiles() {
        for (String files : FILES_TO_CREATE) {
            File file = new File(files);
            try {
                if (file.createNewFile()) {
                    logBuilder.append("Файл успешно создан: ").append(files).append("\n");
                } else {
                    logBuilder.append("Не удалось создать файл: ").append(files).append("\n");
                }
            } catch (IOException e) {
                logBuilder.append("Не удалось создать файл: ").append(files).append(". Ошибка: ").append(e.getMessage()).append("\n");
            }
        }
    }

    private static void writeLogToFile() {
        try (FileWriter writer = new FileWriter(LOG_FILE)) {
            writer.write(logBuilder.toString());
            System.out.println("Лог успешно записан в файл: " + LOG_FILE);
        } catch (IOException e) {
            System.out.println("Не удалось записать лог в файл: " + LOG_FILE + ". Ошибка: " + e.getMessage());
        }
    }
}