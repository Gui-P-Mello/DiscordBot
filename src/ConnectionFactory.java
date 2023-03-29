import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection()
    {
        String url = "jdbc:sqlite:C:/Users/Guilherme/Documents/Curso de JDA/Aula 4/bot.db";
        try{
            return DriverManager.getConnection(url);
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return null;
        
    }
    
}
