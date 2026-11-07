package com.fpsengine;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FPSEngine implements ModInitializer {
    public static final String MOD_ID = "fpsengine";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    /** Particles farther than this (in blocks) from the player skip their tick. */
    public static final double PARTICLE_TICK_RADIUS_SQ = 24.0 * 24.0;

    @Override
    public void onInitialize() {
        LOGGER.info("FPSEngine loaded: particle tick throttle active.");
    }
}
