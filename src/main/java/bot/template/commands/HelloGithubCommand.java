package bot.template.commands;

import java.util.concurrent.TimeUnit;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.utils.MarkdownUtil;

public class HelloGithubCommand extends Command {

	public HelloGithubCommand() {
		// command name. In this example the command to use is !hello
		this.name = "hello";

		// will be displayed if you ask for !help
		this.help = "Say hello to GitHub";

		// define whether to use this command in servers only
		this.guildOnly = false;
	}

	@Override
	protected void execute(CommandEvent event) {
		// get some data from the event
		User author = event.getAuthor();
	    MessageChannel channel = event.getChannel(); 

		// avoid spamming
		if (!author.isBot()) {
			// say hello to the user
			StringBuilder helloUserBuilder = new StringBuilder();
			helloUserBuilder.append("Hope you're doing well, ");
			helloUserBuilder.append(author.getName() + "!");
			channel.sendMessage(helloUserBuilder.toString()).queue();

			// send a message after 2 seconds delay
			StringBuilder helloGitHubBuilder = new StringBuilder();
			helloGitHubBuilder.append("Ouh, I nearly forgot: ");
			helloGitHubBuilder.append(MarkdownUtil.bold("Hello GitHub!"));
			channel.sendMessage(helloGitHubBuilder.toString()).queueAfter(2, TimeUnit.SECONDS);
		}
	}

}
