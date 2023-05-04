import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstallation {
    public static void main(String[] args) {

        // задаем путь до директории Games
        String gamesDirPath = "C:/Games";
        // Создаем экземпляр класса File для директории Games
        File gamesDir = new File(gamesDirPath);
        // Создаем экземпляр класса File для директорий src, res, savegames и temp
        File srcDir = new File(gamesDir, "src");
        File resDir = new File(gamesDir, "res");
        File savegamesDir = new File(gamesDir, "savegames");
        File tempDir = new File(gamesDir, "temp");
        // Создаем экземпляр класса File для директорий main и test в директории src
        File mainDir = new File(srcDir, "main");
        File testDir = new File(srcDir, "test");
        // Создаем экземпляр класса File для директорий drawables, vectors и icons в директории res
        File drawablesDir = new File(resDir, "drawables");
        File vectorsDir = new File(resDir, "vectors");
        File iconsDir = new File(resDir, "icons");
        // Создаем экземпляр класса File для файлов Main.java и Utils.java в директории src/main
        File mainFile = new File(mainDir, "Main.java");
        File utilsFile = new File(mainDir, "Utils.java");
        // Создаем экземпляр класса File для файла temp.txt в директории temp
        File tempFile = new File(tempDir, "temp.txt");

        // создаем директории с помощью метода mkdir()
        gamesDir.mkdir();
        srcDir.mkdir();
        mainDir.mkdir();
        testDir.mkdir();
        resDir.mkdir();
        drawablesDir.mkdir();
        vectorsDir.mkdir();
        iconsDir.mkdir();
        savegamesDir.mkdir();
        tempDir.mkdir();

        // создаем файлы с помощью метода createNewFile()
        try {
            mainFile.createNewFile();
            utilsFile.createNewFile();
            tempFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // создаем объект StringBuilder для записи лога создания файлов и директорий
        StringBuilder logBuilder = new StringBuilder();

        // добавляем информацию о каждом созданном файле и директории в StringBuilder
        logBuilder.append("Директория Games создана: ").append(gamesDir.exists()).append("\n");
        logBuilder.append("Директория src создана: ").append(srcDir.exists()).append("\n");
        logBuilder.append("Директория main создана: ").append(mainDir.exists()).append("\n");
        logBuilder.append("Директория test создана: ").append(testDir.exists()).append("\n");
        logBuilder.append("Директория res создана: ").append(resDir.exists()).append("\n");
        logBuilder.append("Директория drawables создана: ").append(drawablesDir.exists()).append("\n");
        logBuilder.append("Директория vectors создана: ").append(vectorsDir.exists()).append("\n");
        logBuilder.append("Директория Icons создана: ").append(iconsDir.exists()).append("\n");
        logBuilder.append("Директория savegames создана: ").append(savegamesDir.exists()).append("\n");
        logBuilder.append("Директория temp сооздана: ").append(tempDir.exists()).append("\n");
        logBuilder.append("Файл Main.java создан: ").append(mainFile.exists()).append("\n");
        logBuilder.append("Файл Utils.java создан: ").append(utilsFile.exists()).append("\n");
        logBuilder.append("Файл temp.txt создан: ").append(tempFile.exists()).append("\n");

        // записываем лог в файл temp.txt
        try {
            FileWriter writer = new FileWriter(tempFile);
            writer.write(logBuilder.toString());
            writer.close();
            System.out.println("Установка успешно завершена!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}