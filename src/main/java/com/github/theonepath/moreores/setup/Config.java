package com.github.theonepath.moreores.setup;

import com.github.theonepath.moreores.lists.BlockList;
import net.minecraft.block.Block;
import net.minecraft.world.gen.placement.CountRangeConfig;

import java.util.HashMap;
import java.util.Map;


public class Config {
    private static final CountRangeConfig ALUMORE_PLACEMENT = new CountRangeConfig(7, 5, 0, 40);
    private static final CountRangeConfig COPPERORE_PLACEMENT = new CountRangeConfig(10, 20, 0, 80);
    private static final CountRangeConfig LEADORE_PLACEMENT = new CountRangeConfig(6, 10, 0, 45);
    private static final CountRangeConfig NICKELORE_PLACEMENT = new CountRangeConfig(5, 2, 0, 30);
    private static final CountRangeConfig SILVERORE_PLACEMENT = new CountRangeConfig(5, 10, 0, 50);
    private static final CountRangeConfig TINORE_PLACEMENT = new CountRangeConfig(8, 20, 0, 70);
    private static final CountRangeConfig ZINCORE_PLACEMENT = new CountRangeConfig(4, 0, 0, 30);

    public static Map<Block, Map<CountRangeConfig, Integer>> ORES_DATA = new HashMap<Block, Map<CountRangeConfig, Integer>>()
    {{
        put(BlockList.ALUM_ORE,   new HashMap<CountRangeConfig, Integer>(){{ put(ALUMORE_PLACEMENT, ALUMORE_PLACEMENT.count); }});
        put(BlockList.COPPER_ORE, new HashMap<CountRangeConfig, Integer>(){{ put(COPPERORE_PLACEMENT, COPPERORE_PLACEMENT.count); }});
        put(BlockList.LEAD_ORE,   new HashMap<CountRangeConfig, Integer>(){{ put(LEADORE_PLACEMENT, LEADORE_PLACEMENT.count); }});
        put(BlockList.NICKEL_ORE, new HashMap<CountRangeConfig, Integer>(){{ put(NICKELORE_PLACEMENT, NICKELORE_PLACEMENT.count); }});
        put(BlockList.SILVER_ORE, new HashMap<CountRangeConfig, Integer>(){{ put(SILVERORE_PLACEMENT, SILVERORE_PLACEMENT.count); }});
        put(BlockList.TIN_ORE,    new HashMap<CountRangeConfig, Integer>(){{ put(TINORE_PLACEMENT, TINORE_PLACEMENT.count); }});
        put(BlockList.ZINC_ORE,   new HashMap<CountRangeConfig, Integer>(){{ put(ZINCORE_PLACEMENT, ZINCORE_PLACEMENT.count); }});
    }};
}
