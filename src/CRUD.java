import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

                Statement statement = ConnectionFactory.getConnection().createStatement();
                statement.execute(sql);
                statement.close();
                ConnectionFactory.getConnection().close();
        }

        public static void insert(String guildId, char prefix) throws SQLException
        {
                sql = """
                        insert or ignore into tb_guild values(null, '%s', '%s')
                        """.formatted(guildId, prefix);
                Statement statement = ConnectionFactory.getConnection().createStatement();
                statement.execute(sql);
                statement.close();
                ConnectionFactory.getConnection().close();
        }

        public static void select(String guildId) throws SQLException
        {
                sql = """
                        select * from tb_guild where guild_id = '%s'
                        """.formatted(guildId);
                Statement statement = ConnectionFactory.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while(resultSet.next())
                {
                        Bot.prefixMap.put(guildId, resultSet.getString("prefix").charAt(0));
                }

                statement.close();
                ConnectionFactory.getConnection().close();
        }
}
