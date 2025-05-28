package net.nithin.mccourse.block;

//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nithin.mccourse.MCCourseMod;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(Block.Settings.create()
                    .mapColor(MapColor.IRON_GRAY)
                    .strength(5.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(Block.Settings.create()
                        .mapColor(MapColor.IRON_GRAY)
                        .strength(5.0f, 6.0f)
                        .requiresTool()
                        .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock("deepslate_pink_garnet_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 6),
                    Block.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(3.0f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)

            ));

    public static final Block NETHER_PINK_GARNET_ORE = registerBlock("nether_pink_garnet_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 6),
                    Block.Settings.create()
                    .mapColor(MapColor.DARK_RED)
                    .strength(0.4f, 0.4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERRACK)

            ));

    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock("end_stone_pink_garnet_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 6),
                    Block.Settings.create()
                    .mapColor(MapColor.PALE_YELLOW)
                    .strength(3.0f, 9.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)

            ));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 6),
                    Block.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .strength(1.5f, 6.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)

            ));

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MCCourseMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        MCCourseMod.LOGGER.info("Registering ModBlocks for " + MCCourseMod.MOD_ID);

    }

}
