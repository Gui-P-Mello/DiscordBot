import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Roles extends ListenerAdapter{

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(Bot.prefixMap.get(event.getGuild().getId()) + "listroles"))
        {
            for (Role role : event.getGuild().getRoles()) {

                event.getChannel().sendMessage(role.getName()).queue();
                
            }
        }
    }
    
}
