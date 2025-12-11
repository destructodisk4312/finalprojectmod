🌟 FinalProjectMod – Crystal Expansion Mod (Forge 1.21.1)
By Andrew Bustos
📘 Overview

FinalProjectMod is a custom Minecraft Forge 1.21.1 mod created as my final project for Columbia College CIS.
This mod introduces an entirely new crystal-themed progression system, including custom blocks, tools, armor, food, loot tables, crafting recipes, and a unique creative mode tab.

All textures in this mod are original 16×16 pixel art, created for this project.

This README explains how the mod meets the project requirements and serves as documentation for grading and review.

🧱 Features
🔷 New Blocks
Block	Description
Crystal Ore	Generates crystal shards when mined (Fortune supported).
Crystal Block	Storage block crafted from 9 shards.
Crystal Bricks	Decorative building block.
Crystal Glass	Transparent blue-tinted glass variant.

Each block has:

Original textures

Blockstates

Models

Loot tables

Creative tab inclusion

💠 New Items
Item	Purpose
Crystal Shard	Core crafting material.
Crystal Bread	Food item that grants the Glowing effect for 20s.
⚒ New Tool Set

A full tool set using a custom ForgeTier:

Crystal Sword

Crystal Pickaxe

Crystal Axe

Crystal Shovel

Crystal Hoe

Crystal Tier Stats:

Mining Level: 4

Speed: 10.0

Attack Bonus: 4

Enchantability: 22

Repair Material: Crystal Shards

🛡 New Armor Set

Crystal Helmet

Crystal Chestplate

Crystal Leggings

Crystal Boots

All with original item textures.

🍞 New Food

Crystal Bread

Nutrition: 6

Saturation: 0.8

Grants Glowing (20 seconds)

🎁 Loot Tables

Includes:

Crystal Ore → 1–3 shards (Fortune bonus)

Blocks drop correctly

Custom chest loot table that can generate crystal shards, crystal bread, and rare diamonds

🧪 Crafting Recipes

Includes recipes for:

Tools

Armor

Crystal bread

Crystal block ↔ shards

Crystal bricks

Crystal glass

Smelting/blasting crystal ore

All recipes follow vanilla conventions.

🎨 Textures

All textures are:

16×16 resolution

Original pixel art made specifically for this mod

Organized into proper folders:

assets/finalprojectmod/textures/block/
assets/finalprojectmod/textures/item/

🗂 Project Structure
src/main/java/com/example/finalproject/finalprojectmod.java
src/main/resources/
    assets/finalprojectmod/
        blockstates/
        models/block/
        models/item/
        textures/block/
        textures/item/
    data/finalprojectmod/
        loot_tables/blocks/
        loot_tables/chests/
        recipes/


This follows Forge 1.21.1 standards.

✔️ Rubric Checklist (Assignment Requirements)
Must-Have Features
Requirement	Completed?	Evidence
Custom blocks	✔	Crystal Ore, Block, Bricks, Glass
Custom items	✔	11+ items including tools & armor
≥ 15 total new items/blocks	✔	4 blocks + 11 items = 15+
At least 2 crafting recipes	✔	Tools, armor, bread, block conversions
Blocks drop items	✔	Loot tables implemented
Advanced Features (Choose 3)
Requirement	Completed?	Evidence
Custom Ore	✔	Crystal Ore + smelting
Custom Armor/Weapon/Tool Set	✔	Entire crystal tier
Custom Loot Tables	✔	Chest loot + ore drops
Custom Food w/ Status Effect	✔	Crystal Bread (Glowing)

More than three advanced features are implemented.
