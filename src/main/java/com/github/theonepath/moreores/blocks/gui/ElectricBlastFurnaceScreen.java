package com.github.theonepath.moreores.blocks.gui;

import com.github.theonepath.moreores.blocks.container.ElectricBlastFurnaceContainer;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import static com.github.theonepath.moreores.MoreOres.MODID;

public class ElectricBlastFurnaceScreen extends ContainerScreen<ElectricBlastFurnaceContainer> {

    private ResourceLocation GUI = new ResourceLocation(MODID, "textures/gui/electric_blast_furnace.png");

    public ElectricBlastFurnaceScreen(ElectricBlastFurnaceContainer container, PlayerInventory inventory, ITextComponent component) {
        super(container, inventory, component);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTick) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTick);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.title.getFormattedText();
        String energy = "Energy: " + container.getEnergy();
        //this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 9.0f, (float)(this.ySize - 108 + 2), 4210752);
        drawString(Minecraft.getInstance().fontRenderer, energy, 9, 6, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.blendColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bindTexture(GUI);

        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
    }
}
