package net.runelite.client.plugins.animationcd;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;


class AnimationCDOverlayChat extends OverlayPanel {
    private final AnimationCDPlugin plugin;
    private final AnimationCDConfig config;

    @Inject
    private AnimationCDOverlayChat(AnimationCDPlugin plugin, AnimationCDConfig config, Client client){
        super(plugin);
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Animation cooldown overlay"));
    }

    @Override
    public Dimension render(Graphics2D graphics){
        if (config.getUI()){
            //Variables used to make the string we need to display
            int tick = plugin.getLastAttackTick();
            //Text string to be displayed
            final String lastAttack = "Ticks since last attack: " + tick;

            panelComponent.getChildren().add(TitleComponent.builder()
                    .text(lastAttack)
                    .color(tick == plugin.getASpeed2() ? Color.GREEN : Color.RED)
                    .build());

            panelComponent.setPreferredSize(new Dimension(
                    graphics.getFontMetrics().stringWidth(lastAttack) + 10,
                    0));

            return super.render(graphics);
        }
        return null;
    }

}
