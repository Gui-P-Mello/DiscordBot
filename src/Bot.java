import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.create("MTA4ODUwNDc4Njc3MDQ3NzEwNg.G6r8Fo.fTSk26RvunqVZFSOiB3vH770-bRggNKoSK9pbY", GatewayIntent.GUILD_MEMBERS).build();
    }
    
}
