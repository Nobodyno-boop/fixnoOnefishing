# FishSell

A Plugin for fix the sell command (in [NoOneFishing](https://www.spigotmc.org/resources/noonefishing-30-unique-fish-with-a-huge-number-of-settings-baits-competition-antiafk-system.93692/)) & hex Color ([NoOneFishing](https://www.spigotmc.org/resources/noonefishing-30-unique-fish-with-a-huge-number-of-settings-baits-competition-antiafk-system.93692/) & [NoOneRods](https://www.spigotmc.org/resources/noonerods-custom-fishing-rods-with-crafting-recipes-bonuses-add-on-for-noonefishing.94796/)) 


- [1. Why ?](#why-)
    * [1.1 Duplication](#duplication-probleme)
    * [1.3 solutions](#the-fix)
        + [1.3.1 fix the color](#color)

# Why ?
Because the actual version have a major bug (the 1.2.0).

---
### Duplication probleme

![image](./md/bug.gif)

- Hex color not supported only in 1.18 and higher




# The fix

- Replace the current command `nfsell inventory`
- Using `PlayerCommandPreprocessEvent` so just enjoy this fix
- you can use `/fishsell` its work too.
- When you reload NoOneFishing its still work :)

# Color
### ⚠️  FishSell-1.3.1.jar does not contains the javaagent anymore !
Related to #12 new version of spigot/other doing some weird stuff and losing injection dependencies.

Now you can download the fix color jar in standalone version.

Steps:
1. Download the fix-color-1.3.1.jar and place it into your server folder
2. Put this java argrument on your startup command 
3. Enjoy hex color :D
```bash
-javaagent:fix-color-1.3.1.jar
```


# Download

just take a look to [release](https://github.com/Nobodyno-boop/fixnoOnefishing/releases)


config
===
The default config

| path                  | name                    | description                                                                         | default |
|-----------------------|-------------------------|-------------------------------------------------------------------------------------|---------|
| `fix.command.fix`     | enable the command      | Enable the command `/nsfsell inventory` by cancel this command and execute a script | true    |
| `fix.command.custom`  | enable custom command   | Enable the command `/fishsell` its like `/nsfsell inventory`                        | true    |
| `fix.slot.head`       | remove fish in head     | Remove fish in head slot while execute `/nfsell Inventory`                          | true    |
| `fix.slot.offhand`    | Remove fish in off hand | Remove the fish in offhand slot while execute `/nfsell Inventory`                   | true    |
| `plugin.update.check` | Check update            | Check if the plugin can be updated only at the start                                | true    |



# Changelog
## v1.3 - 14/03/2021
 - add config [Feature #9](#9)

## v1.2 - 15-01-2021
 - Add instrument for javaAgent for modify the current hexMethod.
## v1.1 - 15-12-2021
 ### Added 
 - Updater for check the latest version and print a message at the startup
 ### Fix
 - The price can be `null` so we ignore this item [issue-2](GH-2)

## v1.0 - 14-12-2021
 ### Added
 - First release with the fix command & `PlayerCommandPreprocessEvent`


Nobody.
