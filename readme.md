# FishSell

The current fix for [NoOneFishing](https://www.spigotmc.org/resources/noonefishing-30-unique-fish-with-a-huge-number-of-settings-baits-competition-antiafk-system.93692/)

# Download

just take a look to [release](https://github.com/Nobodyno-boop/fixnoOnefishing/releases)

# Why ? 
Because the actual version have a major bug (the 1.2.0).

![image](./md/bug.gif)

# The fix

- Replace the current command `nfsell inventory`
- Using `PlayerCommandPreprocessEvent` so just enjoy this fix
- you can use `/fishsell` its work too.
- When you reload NoOneFishing its still work :)


# Changelog
## v1.1 - 15-12-2021
 ### Added 
 - Updater for check the latest version and print a message at the startup
 ### Fix
 - The price can be `null` so we ignore this item [issue-2](GH-2)

## v1.0 - 14-12-2021
 ### Added
 - First release with the fix command & `PlayerCommandPreprocessEvent`


Nobody.
