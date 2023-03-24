import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoin extends ListenerAdapter{
    
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event)
    {
        TextChannel textChannel = event.getGuild().getTextChannelById(1088927258351243285L);
        String userName = event.getUser().getName();

        textChannel.sendMessage(userName + " entrou no servidor!").queue();
    }
}
