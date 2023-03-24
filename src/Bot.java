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


    public static void main(String[] args) throws LoginException, InterruptedException {
        jda = JDABuilder.create("MTA4ODUwNDc4Njc3MDQ3NzEwNg.GZHz8s.ri2yayiBeSb3dDysNMotXujLvL2CiqGB3pZkoQ",
        EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new Ping());
        jda.addEventListener(new MemberJoin());
        jda.addEventListener(new MemberLeave());

        for (Guild guild : jda.awaitReady().getGuilds())
        {
            mapGuildName.put(guild.getIdLong(), guild.getName());

            System.out.println(mapGuildName.get(guild.getIdLong()));
        }
    }
}
