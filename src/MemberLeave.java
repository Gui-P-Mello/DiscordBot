import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberLeave extends ListenerAdapter{

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event)
    {
        TextChannel textChannel = event.getGuild().getTextChannelById(1088945214502219786L);
        String userName = event.getUser().getName();

        textChannel.sendMessage(userName + " saiu do servidor!").queue();
    }

}