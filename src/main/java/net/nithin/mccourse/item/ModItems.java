package net.nithin.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nithin.mccourse.MCCourseMod;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new Item.Settings()));

    // First step to add new item.
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries)
    {
        entries.add(PINK_GARNET);
        entries.add(RAW_PINK_GARNET);
    }

    public static void registerModItems()
    {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }

}
