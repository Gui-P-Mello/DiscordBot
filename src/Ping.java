import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter{

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split(" ");

        MessageChannelUnion textChannel = event.getChannel();

        if(args[0].equalsIgnoreCase("!"+"ping"))
        {
            textChannel.sendMessage(Bot.jda.getGatewayPing() + "ms").queue();
        }
    }
    
}
