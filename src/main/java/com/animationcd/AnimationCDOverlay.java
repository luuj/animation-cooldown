package net.runelite.client.plugins.animationcd;

import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.FontManager;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import javax.inject.Inject;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Font;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPriority;

import javax.inject.Inject;
import java.awt.*;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;



class AnimationCDOverlay extends Overlay {

    private final Client client;
    private final AnimationCDPlugin plugin;
    private final AnimationCDConfig config;

    @Inject
    private AnimationCDOverlay(AnimationCDPlugin plugin, AnimationCDConfig config, Client client){
        super(plugin);
        this.client = client;
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.UNDER_WIDGETS);
        setPriority(OverlayPriority.MED);
    }

    @Override
    public Dimension render(Graphics2D graphics){

        if (config.showPlayerTick() && plugin.tickCounter > -3)
        {
            graphics.setFont(new Font(FontManager.getRunescapeFont().getName(), Font.PLAIN, config.fontSize()));

            final int height = client.getLocalPlayer().getLogicalHeight()+20;
            final LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();
            final Point playerPoint = Perspective.localToCanvas(client, localLocation, client.getPlane(), height);

            OverlayUtil.renderTextLocation(graphics, playerPoint, String.valueOf(plugin.tickCounter), config.NumberColor());
        }

        return null;
    }

}
