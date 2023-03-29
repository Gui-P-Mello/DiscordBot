import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

public class Config {

    
    public static File databaseFile = new File("C:/Users/Guilherme/Documents/Curso de JDA/Aula 4/bot.db");
    
    public static void createFilesAndTable() throws IOException, SQLException
    {
        if(Files.notExists(databaseFile.toPath()))
        {
            Files.createFile(databaseFile.toPath());
            CRUD.createTable();
        }
    }
    
}
