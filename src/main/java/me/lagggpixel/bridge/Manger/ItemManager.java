package me.lagggpixel.bridge.Manger;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;

public class ItemManager {

    private final ArrayList<Player> _playerWithKit = new ArrayList<>();

    public void giveKit(Player pPlayer, String pTeam) {
        // Blue Items
        ItemStack redClay = new ItemStack(Material.STAINED_CLAY, 64, DyeColor.RED.getWoolData());

        // Red Items
        ItemStack blueClay = new ItemStack(Material.STAINED_CLAY, 64, DyeColor.BLUE.getWoolData());

        if (!_playerWithKit.contains(pPlayer)) {
            _playerWithKit.add(pPlayer);
        }

        Inventory playerInv = pPlayer.getInventory();
        playerInv.clear();

        playerInv.setItem(0, buildSword());
        playerInv.setItem(1, buildBow());
        playerInv.setItem(2, buildPickaxe());
        if (pTeam.equalsIgnoreCase("Blue")) {
            playerInv.setItem(3, blueClay);
            playerInv.setItem(4, blueClay);

            pPlayer.getEquipment().setArmorContents(buildBlueArmor());
        } else {
            playerInv.setItem(3, redClay);
            playerInv.setItem(4, redClay);

            pPlayer.getEquipment().setArmorContents(buildRedArmor());
        }
        playerInv.setItem(5, new ItemStack(Material.GOLDEN_APPLE, 8));
        playerInv.setItem(8, new ItemStack(Material.ARROW));


    }

    private ItemStack buildPickaxe() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addEnchant(Enchantment.DIG_SPEED, 3, false);
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }

    private  ItemStack buildBow() {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }

    private  ItemStack buildSword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }

    private ItemStack[] buildBlueArmor(){
        ItemStack[] items = new ItemStack[3];
        ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lch = (LeatherArmorMeta)lchest.getItemMeta();
        lch.setColor(Color.fromRGB(0, 0, 255));
        lchest.setItemMeta(lch);

        ItemStack lleggins = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta lle = (LeatherArmorMeta)lleggins.getItemMeta();
        lle.setColor(Color.fromRGB(0, 0, 255));
        lleggins.setItemMeta(lle);

        ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta lbo = (LeatherArmorMeta)lboots.getItemMeta();
        lbo.setColor(Color.fromRGB(0, 0, 255));
        lboots.setItemMeta(lbo);

        items[2]= lchest;
        items[1]= lleggins;
        items[0]= lboots;
        return items;
    }

    private ItemStack[] buildRedArmor(){
        ItemStack[] items = new ItemStack[3];
        ItemStack lchest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta lch = (LeatherArmorMeta)lchest.getItemMeta();
        lch.setColor(Color.fromRGB(255, 0, 0));
        lchest.setItemMeta(lch);

        ItemStack lleggins = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta lle = (LeatherArmorMeta)lleggins.getItemMeta();
        lle.setColor(Color.fromRGB(255, 0, 0));
        lleggins.setItemMeta(lle);

        ItemStack lboots = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta lbo = (LeatherArmorMeta)lboots.getItemMeta();
        lbo.setColor(Color.fromRGB(255, 0, 0));
        lboots.setItemMeta(lbo);

        items[2]= lchest;
        items[1]= lleggins;
        items[0]= lboots;
        return items;
    }
}