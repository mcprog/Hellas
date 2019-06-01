package com.mcprog.hellas;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLContainerHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import com.mcprog.hellas.init.ModBlocks;
import com.mcprog.hellas.init.ModRecipes;
import com.mcprog.hellas.proxy.CommonProxy;

@Mod(modid = HellasMod.MODID, name = HellasMod.NAME, version = HellasMod.VERSION, acceptedMinecraftVersions = HellasMod.MC_VERSIONS)
public class HellasMod
{
    public static final String MODID = "hellasmod";
    public static final String NAME = "Hellas Mod";
    public static final String VERSION = "1.0.0-alpha";
    public static final String MC_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY = "com.mcprog.hellas.proxy.ClientProxy";
    public static final String COMMON_PROXY = "com.mcprog.hellas.proxy.CommonProxy";

    private static Logger logger;
    
    @Instance
    public static HellasMod instance;
    
    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy; //since client extends common, this can be declared as the super type

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);

    }


    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
}
