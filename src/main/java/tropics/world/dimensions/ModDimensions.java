package tropics.world.dimensions;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import tropics.Tropics;

public class ModDimensions {
    public static final RegistryKey<DimensionType> TEST_DIMENSION_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(Tropics.MOD_ID, "test_dimension"));
    public static final RegistryKey<World> TEST_DIMENSION = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Tropics.MOD_ID, "test_dimension"));
}
