import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {

    public static JDA jda;
    public static Map<Long, String> mapGuildName = new HashMap<>();
    public static Map<String, Character> prefixMap = new HashMap<>();

    public static void main(String[] args) throws LoginException, InterruptedException, IOException, SQLException {

        BufferedReader tokenRead = new BufferedReader(new FileReader("token.txt"));
        String token = tokenRead.readLine();
        tokenRead.close();

        Config.createFilesAndTable();

        jda = JDABuilder.create(token,
        EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new Ping());
        jda.addEventListener(new MemberJoin());
        jda.addEventListener(new MemberLeave());
        jda.addEventListener(new Prefix());
        jda.addEventListener(new Roles());

        for (Guild guild : jda.awaitReady().getGuilds())
        {
            CRUD.insert(guild.getId(), '!');
        }

        for (Guild guild : jda.awaitReady().getGuilds())
        {
            CRUD.select(guild.getId());
        }

        /*for (Guild guild : jda.awaitReady().getGuilds())
        {
            mapGuildName.put(guild.getIdLong(), guild.getName());

            System.out.println(mapGuildName.get(guild.getIdLong()));
        }*/
    }
}