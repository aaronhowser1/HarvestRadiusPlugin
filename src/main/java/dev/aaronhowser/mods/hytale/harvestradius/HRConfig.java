package dev.aaronhowser.mods.hytale.harvestradius;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class HRConfig {

	public static final BuilderCodec<HRConfig> CODEC =
			BuilderCodec.builder(HRConfig.class, HRConfig::new)
					.append(
							new KeyedCodec<>("Radius", Codec.DOUBLE),
							(config, newRadius) -> config.radius = newRadius,
							HRConfig::getRadius
					)
					.add()
					.build();

	private double radius = 5.0;

	public double getRadius() {
		return radius;
	}

}
