package bot.template;

import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClientBuilder;

import bot.template.commands.HelloGithubCommand;
import bot.template.utils.Helper;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {

	public static void main(String[] args) {
		CommandClientBuilder client = new CommandClientBuilder();

		// set Discord ID of the bot owner
		client.setOwnerId(Helper.OWNER_ID);

		// choose a custom prefix for commands
		client.setPrefix("!");

		// set an alternative prefix which can be used too
		client.setAlternativePrefix(".");

		// override the default activity
		client.setActivity(Activity.playing("Hello GitHub!"));
		
		// add your commands
		client.addCommand(new HelloGithubCommand());

		try {
			// set the bot token, can be created here:
			// https://discord.com/developers/applications
			JDABuilder.createDefault(Helper.BOT_TOKEN)
					.addEventListeners(client.build())
					.build();
		}
		catch (LoginException e) {
			e.printStackTrace();
		}
	}

}
