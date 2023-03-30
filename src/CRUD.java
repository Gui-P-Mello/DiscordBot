import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

        private static String sql;

        public static void createTable() throws SQLException
        {
                sql = """
                                create table tb_guild
                                (
                                        id integer not null primary key autoincrement unique,
                                        guild_id text not null unique,
                                        prefix text not null
                                )""";

                PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(sql);
                statement.execute();
                statement.close();
                ConnectionFactory.getConnection().close();
        }

        public static void insert(String guildId, char prefix) throws SQLException
        {
                sql = """
                        insert or ignore into tb_guild values(null, ?, ?)
                        """;
                PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(sql);
                statement.setString(1, guildId);
                statement.setString(2, String.valueOf(prefix));
                statement.execute();
                statement.close();
                ConnectionFactory.getConnection().close();
        }

        public static void select(String guildId) throws SQLException
        {
                sql = """
                        select * from tb_guild where guild_id = ?
                        """;
                PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(sql);
                statement.setString(1, guildId);
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next())
                {
                        Bot.prefixMap.put(guildId, resultSet.getString("prefix").charAt(0));
                }

                statement.close();
                ConnectionFactory.getConnection().close();
        }
        
        public static void update(String guildId, char newPrefix) throws SQLException
        {
                sql = """
                        update tb_guild set prefix = ? where guild_id = ?
                        """;
                PreparedStatement statement = ConnectionFactory.getConnection().prepareStatement(sql);

                statement.setString(1, String.valueOf(newPrefix));
                statement.setString(2, guildId);

                statement.executeUpdate();
                statement.close();
                ConnectionFactory.getConnection().close();
        }
}
