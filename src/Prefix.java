import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Prefix extends ListenerAdapter {
    @Override
    public void onMessageReceived( @NotNull MessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split(" ");

        MessageChannelUnion textChannel = event.getChannel();

        if(args[0].equals(Bot.prefixMap.get(event.getGuild().getId()) + "prefix"))
        {
            textChannel.sendMessage("O prefixo para este servidor é " + Bot.prefixMap.get(event.getGuild().getId())).queue();
        }

        if(args[0].equals(Bot.prefixMap.get(event.getGuild().getId()) + "setprefix"))
        {
            Bot.prefixMap.replace(event.getGuild().getId(), args[1].charAt(0));
            textChannel.sendMessage("O novo prefixo para este servidor é " + Bot.prefixMap.get(event.getGuild().getId())).queue();
            try {
                CRUD.update(event.getGuild().getId(), args[1].charAt(0));
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
