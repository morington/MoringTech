package com.morington.moringtech.block;

import com.morington.moringtech.group.ModGroup;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;


public class ModBlocks {
    // Ores
    public static final RegistryObject<Block> ORE_SPODUMENE = ModBlockBuilder.createAndBuild("ore/spodumene", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_LEPIDOLITE = ModBlockBuilder.createAndBuild("ore/lepidolite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_BERYL = ModBlockBuilder.createAndBuild("ore/beryl", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_MAGNESITE = ModBlockBuilder.createAndBuild("ore/magnesite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_DOLOMITE = ModBlockBuilder.createAndBuild("ore/dolomite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_ILMENITE = ModBlockBuilder.createAndBuild("ore/ilmenite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_RUTILE = ModBlockBuilder.createAndBuild("ore/rutile", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_CHROMITE = ModBlockBuilder.createAndBuild("ore/chromite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_PYROLUSITE = ModBlockBuilder.createAndBuild("ore/pyrolusite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_BRAUNITE = ModBlockBuilder.createAndBuild("ore/braunite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_MAGNETITE = ModBlockBuilder.createAndBuild("ore/magnetite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_HEMATITE = ModBlockBuilder.createAndBuild("ore/hematite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_LIMONITE = ModBlockBuilder.createAndBuild("ore/limonite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_SIDERITE = ModBlockBuilder.createAndBuild("ore/siderite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_COBALTITE = ModBlockBuilder.createAndBuild("ore/cobaltite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_CARROLLITE = ModBlockBuilder.createAndBuild("ore/carrollite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_GARNIERITE = ModBlockBuilder.createAndBuild("ore/garnierite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_PENTLANDITE = ModBlockBuilder.createAndBuild("ore/pentlandite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_CHALCOPYRITE = ModBlockBuilder.createAndBuild("ore/chalcopyrite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_BORNITE = ModBlockBuilder.createAndBuild("ore/bornite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_MALACHITE = ModBlockBuilder.createAndBuild("ore/malachite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_SPHALERITE = ModBlockBuilder.createAndBuild("ore/sphalerite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_MOLYBDENITE = ModBlockBuilder.createAndBuild("ore/molybdenite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_SCHEELITE = ModBlockBuilder.createAndBuild("ore/scheelite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_GOLD = ModBlockBuilder.createAndBuild("ore/gold", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_ARGENTITE = ModBlockBuilder.createAndBuild("ore/argentite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_PLATINUM = ModBlockBuilder.createAndBuild("ore/platinum", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_BASTNASITE = ModBlockBuilder.createAndBuild("ore/bastnasite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_MONAZITE = ModBlockBuilder.createAndBuild("ore/monazite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_URANINITE = ModBlockBuilder.createAndBuild("ore/uraninite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_CASSITERITE = ModBlockBuilder.createAndBuild("ore/cassiterite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_GALENA = ModBlockBuilder.createAndBuild("ore/galena", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_STIBNITE = ModBlockBuilder.createAndBuild("ore/stibnite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_BISMUTHINITE = ModBlockBuilder.createAndBuild("ore/bismuthinite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_ORE_SULFUR = ModBlockBuilder.createAndBuild("ore/sulfur", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_APATITE = ModBlockBuilder.createAndBuild("ore/apatite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_QUARTZ = ModBlockBuilder.createAndBuild("ore/quartz", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_BAUXITE = ModBlockBuilder.createAndBuild("ore/bauxite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_SPERRYLITE = ModBlockBuilder.createAndBuild("ore/sperrylite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_COLUMBITE_TANTALITE = ModBlockBuilder.createAndBuild("ore/columbite_tantalite", ModGroup.ORE);
    public static final RegistryObject<Block> ORE_PIRIT = ModBlockBuilder.createAndBuild("ore/pirit", ModGroup.ORE);


    public static void register(IEventBus eventBus) {ModBlockBuilder.BLOCKS.register(eventBus);}
}
