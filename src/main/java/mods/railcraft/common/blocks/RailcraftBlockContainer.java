/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2016
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/

package mods.railcraft.common.blocks;

import mods.railcraft.common.plugins.forge.CreativePlugin;
import mods.railcraft.common.plugins.forge.WorldPlugin;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by CovertJaguar on 4/13/2016 for Railcraft.
 *
 * @author CovertJaguar <http://www.railcraft.info>
 */
public abstract class RailcraftBlockContainer extends BlockContainer implements IRailcraftBlock {
    protected RailcraftBlockContainer(Material materialIn) {
        super(materialIn);
    }

    protected RailcraftBlockContainer(Material material, MapColor mapColor) {
        super(material, mapColor);
    }

    {
        setCreativeTab(CreativePlugin.RAILCRAFT_TAB);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public void markBlockForUpdate(World world, BlockPos pos) {
        if (world != null) {
            IBlockState state = WorldPlugin.getBlockState(world, pos);
            markBlockForUpdate(state, world, pos);
        }
    }

    public void markBlockForUpdate(IBlockState state, World world, BlockPos pos) {
        if (world != null) {
            world.notifyBlockUpdate(pos, state, state, 3);
        }
    }
}
