package net.nithin.mccourse.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        System.out.println("Metal detector used!");
        BlockPos positionClicked = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        boolean foundBlock = false;

        for (int i = 0; i <= positionClicked.getY() + 64; i++) {
            BlockState blockState = context.getWorld().getBlockState(positionClicked.down(i));
            Block block = blockState.getBlock();
            if (isValuableBlock(blockState)) {
                if (player != null) {
                    outputValuableCoordinates(positionClicked.down(i), player, block);
                }
                foundBlock = true;
                break;
            }
        }

        if (!foundBlock && player != null) {
            player.sendMessage(Text.translatable("item.mccourse.metal_detector.no_valuables"));
        }

        if (player != null) {
            player.getMainHandStack().damage(
                    1,
                    player,
                    LivingEntity.getSlotForHand(player.getActiveHand())
            );
        }

        return ActionResult.SUCCESS;
    }


    private void outputValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Valuable Found " + block.getName().getString() + " at " +
                "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")"));

    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.getBlock() == Blocks.IRON_ORE || blockState.getBlock() == Blocks.GOLD_ORE ||
                blockState.getBlock() == Blocks.DIAMOND_ORE || blockState.getBlock() == Blocks.REDSTONE_ORE;
    }
}
