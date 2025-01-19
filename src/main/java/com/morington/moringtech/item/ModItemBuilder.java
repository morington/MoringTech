package com.morington.moringtech.item;

import com.morington.moringtech.MoringTechMod;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraftforge.common.ToolType.*;

public class ModItemBuilder {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoringTechMod.MODID);

    // States
    private String name;
    private Rarity rarity = Rarity.COMMON;
    private Integer maxStackSize = 64;
    private ItemGroup itemGroup;
    private boolean isWhetherTool = false;
    private ToolType toolType;
    private Integer toolLevel = 0;
    private boolean isRepair = true;
    private Integer durability = null;

    public ModItemBuilder setIsRepair(boolean value) {
        this.isRepair = value;
        return this;
    }

    public ModItemBuilder setWhetherTool(ToolType toolType, Integer toolLevel, Integer durability) {
        this.isWhetherTool = true;
        this.toolType = toolType;
        this.toolLevel = toolLevel;
        this.durability = durability;
        return this;
    }

    public ModItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ModItemBuilder setRarity(Rarity rarity) {
        this.rarity = rarity;
        return this;
    }

    public ModItemBuilder setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        return this;
    }

    public ModItemBuilder setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }

    public RegistryObject<Item> build() {
        if (isWhetherTool && toolType != null && toolLevel != null) {
            Item.Properties properties = new Item.Properties()
                    .rarity(rarity)
                    .maxStackSize(maxStackSize)
                    .group(itemGroup);

            if (durability != null) {
                properties.maxDamage(durability);
            }

            if (toolType.equals(PICKAXE)) {
                return ITEMS.register(name, () -> new PickaxeItem(ItemTier.DIAMOND, -2, -2.8F, properties));
            } else if (toolType.equals(AXE)) {
                return ITEMS.register(name, () -> new AxeItem(ItemTier.DIAMOND, 5.0F, -3.0F, properties));
            } else if (toolType.equals(SHOVEL)) {
                return ITEMS.register(name, () -> new ShovelItem(ItemTier.DIAMOND, -1.5F, -3.0F, properties));
            } else if (toolType.equals(HOE)) {
                return ITEMS.register(name, () -> new HoeItem(ItemTier.DIAMOND, -1, -2.8F, properties));
            }
            throw new IllegalArgumentException("Unsupported tool type: " + toolType);
        } else {
            Item.Properties properties = new Item.Properties();
            properties.rarity(rarity)
                    .maxStackSize(maxStackSize)
                    .group(itemGroup);

            return ITEMS.register(name, () -> new Item(properties));
        }
    }

    public static RegistryObject<Item> createAndBuild(String name, ItemGroup itemGroup) {
        return new ModItemBuilder()
                .setName(name)
                .setItemGroup(itemGroup)
                .build();
    }
}
