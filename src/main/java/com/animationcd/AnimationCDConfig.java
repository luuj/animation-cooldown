package com.animationcd;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("animationcd")
public interface AnimationCDConfig extends Config
{
	@ConfigSection(
			name = "General",
			description = "menu of the general features",
			position = 0
	)
	String generalSettings = "generalSettings";

	@ConfigItem(
			keyName = "enableUI",
			name = "Enable Chat Bar UI",
			description = "This enables UI for each attack above chat bar",
			section = generalSettings,
			position = 1
	)
	default boolean getUI(){return false;}

	@ConfigItem(
			position = 2,
			keyName = "showPlayerTick",
			name = "Show Tick Number Above Player",
			description = "Shows current tick number above the player",
			section = generalSettings
	)
	default boolean showPlayerTick()
	{
		return false;
	}

	@ConfigSection(
			name = "Tick UI",
			description = "Customize tick font/color",
			position = 3
	)
	String tickSettings = "tickSettings";

	@Range(
			min = 8,
			max = 50
	)
	@ConfigItem(
			position = 4,
			keyName = "fontSize",
			name = "Font Size",
			description = "Change the font size of the overhead Tick Number",
			section = tickSettings
	)
	default int fontSize()
	{
		return 15;
	}

	@ConfigItem(
			position = 5,
			keyName = "countColor",
			name = "Tick Number Color",
			description = "Configures the color of tick number",
			section = tickSettings
	)
	default Color NumberColor()
	{
		return Color.CYAN;
	}

}
