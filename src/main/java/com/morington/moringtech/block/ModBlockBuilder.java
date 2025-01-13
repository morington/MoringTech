package com.morington.moringtech.block;

import com.morington.moringtech.MoringTechMod;
import com.morington.moringtech.item.ModItemBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

/**
 * A builder class for creating and registering custom blocks in Minecraft modding.
 * This class allows setting various properties of a block such as material, hardness,
 * resistance, tool requirements, and more. It also registers the block and its corresponding
 * item automatically.
 */
public class ModBlockBuilder {

    /**
     * Deferred register to handle block registration.
     */
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoringTechMod.MODID);

    // Block properties states
    private String name;
    private Material material = Material.ROCK;
    private int harvestLevel = 0;
    private ToolType harvestTool = ToolType.PICKAXE;
    private float hardness = 3.0f;
    private float resistance = 3.0f;
    private boolean requiresTool = false;
    private ItemGroup itemGroup;
    private Rarity rarity = Rarity.COMMON;

    /**
     * Sets the rarity of the block's item.
     *
     * @param rarity The rarity to set.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setRarity(Rarity rarity) {
        this.rarity = rarity;
        return this;
    }

    /**
     * Sets the name of the block.
     *
     * @param name The name of the block.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the material of the block.
     *
     * @param material The material of the block.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    /**
     * Sets the harvest level required to mine the block.
     *
     * @param harvestLevel The harvest level required.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setHarvestLevel(int harvestLevel) {
        this.harvestLevel = harvestLevel;
        return this;
    }

    /**
     * Sets the tool type required to mine the block.
     *
     * @param harvestTool The tool type required.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setHarvestTool(ToolType harvestTool) {
        this.harvestTool = harvestTool;
        return this;
    }

    /**
     * Sets the hardness of the block.
     *
     * @param hardness The hardness value.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setHardness(float hardness) {
        this.hardness = hardness;
        return this;
    }

    /**
     * Sets the resistance of the block against explosions.
     *
     * @param resistance The resistance value.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setResistance(float resistance) {
        this.resistance = resistance;
        return this;
    }

    /**
     * Sets whether the block requires a specific tool to be mined.
     *
     * @param requiresTool Whether the block requires a specific tool.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setRequiresTool(boolean requiresTool) {
        this.requiresTool = requiresTool;
        return this;
    }

    /**
     * Sets the item group (creative tab) where the block will appear.
     *
     * @param itemGroup The item group.
     * @return The current instance of ModBlockBuilder.
     */
    public ModBlockBuilder setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }

    /**
     * Registers a block with the given name, supplier, and item group.
     *
     * @param name      The name of the block.
     * @param block     Supplier that provides the block instance.
     * @param itemGroup The item group where the block will appear.
     * @param register  The deferred register to use for block registration.
     * @param rarity    The type Rarity
     * @param <T>       The type of the block.
     * @return The registered block.
     */
    public static <T extends Block> RegistryObject<T> registerBlock(
            String name, Supplier<T> block, ItemGroup itemGroup, Rarity rarity, DeferredRegister<Block> register) {
        RegistryObject<T> registeredBlock = register.register(name, block);
        registerBlockItem(name, registeredBlock, itemGroup, rarity);
        return registeredBlock;
    }

    /**
     * Registers the block item associated with the block.
     *
     * @param name       The name of the block.
     * @param block      The registry object of the block.
     * @param itemGroup  The item group where the block item will appear.
     * @param rarity    The type Rarity
     * @param <T>        The type of the block.
     */
    private static <T extends Block> void registerBlockItem(
            String name, RegistryObject<T> block, ItemGroup itemGroup, Rarity rarity) {
        ModItemBuilder.ITEMS.register(name, () -> new BlockItem(
                block.get(), new Item.Properties().group(itemGroup).rarity(rarity)
        ));
    }

    /**
     * Builds and registers the block with the specified properties.
     *
     * @return The registered block.
     */
    public RegistryObject<Block> build() {
        if (name == null || itemGroup == null) {
            throw new IllegalStateException("Name and ItemGroup must be set");
        }
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(material)
                .harvestLevel(harvestLevel)
                .harvestTool(harvestTool)
                .hardnessAndResistance(hardness, resistance);
        if (requiresTool) {
            properties.setRequiresTool();
        }
        return registerBlock(
                name,
                () -> new Block(properties),
                itemGroup,
                rarity,
                BLOCKS
        );
    }

    /**
     * Creates and builds a block with default settings.
     *
     * @param name      The name of the block.
     * @param itemGroup The item group where the block will appear.
     * @return The registered block.
     */
    public static RegistryObject<Block> createAndBuild(String name, ItemGroup itemGroup) {
        return new ModBlockBuilder()
                .setName(name)
                .setItemGroup(itemGroup)
                .build();
    }
}