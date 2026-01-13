package com.otherpatrick.magicmod;

import com.otherpatrick.magicmod.items.FlipjeWand;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.function.Function;

public class ModdedItems {
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, name));
        GenericItem item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final Consumable FLIPJE_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SLOWNESS, 67 * 20, 67), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RESISTANCE, 67 * 20, 67), 1.0f))
            .build();
    public static final FoodProperties FLIPJE_FOOD_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .build();


    public static final ToolMaterial FLIPJE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            6767,
            67.67F,
            67.67F,
            67,
            ModdedItems.REPAIRS_FLIPJE
    );
    public static final TagKey<Item> REPAIRS_FLIPJE = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "repairs_flipje"));
    public static final Item FLIPJE = register("flipje", Item::new, new Item.Properties().food(FLIPJE_FOOD_COMPONENT, FLIPJE_CONSUMABLE_COMPONENT));
    public static final Item FLIPJE_SWORD = register("flipje_sword", Item::new, new Item.Properties().sword(FLIPJE_TOOL_MATERIAL, 1f, 1f));
    public static final Item FLIPJE_PICKAXE = register("flipje_pickaxe", Item::new, new Item.Properties().pickaxe(FLIPJE_TOOL_MATERIAL, 1f, 1f));
    public static final Item FLIPJE_AXE = register("flipje_axe", Item::new, new Item.Properties().axe(FLIPJE_TOOL_MATERIAL, 1f, 1f));
    public static final Item FLIPJE_HOE = register("flipje_hoe", Item::new, new Item.Properties().hoe(FLIPJE_TOOL_MATERIAL, 1f, 1f));
    public static final Item FLIPJE_SHOVEL = register("flipje_shovel", Item::new, new Item.Properties().shovel(FLIPJE_TOOL_MATERIAL, 1f, 1f));
    public static final BowItem FLIPJE_BOW = register("flipje_bow", BowItem::new, new Item.Properties());
    public static final FlipjeWand FLIPJE_WAND = register("flipje_wand", FlipjeWand::new, new Item.Properties());

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
                .register((itemGroup) -> itemGroup.accept(ModdedItems.FLIPJE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register((itemGroup) -> itemGroup.accept(ModdedItems.FLIPJE_SWORD));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(ModdedItems.FLIPJE_PICKAXE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(ModdedItems.FLIPJE_AXE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(ModdedItems.FLIPJE_HOE));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(ModdedItems.FLIPJE_SHOVEL));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register((itemGroup) -> itemGroup.accept(ModdedItems.FLIPJE_BOW));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(ModdedItems.FLIPJE_WAND));
    }

}