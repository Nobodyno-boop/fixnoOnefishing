package fr.nobody.fix.fishsell.data;

import java.util.ArrayList;
import java.util.List;

public final class Fish {
    public String itemname = "Salmon";

    public List<String> itemlore;

    public double minweight = 0.0D;

    public double maxweight = 1.0D;

    public List<String> biome = new ArrayList<>();

    public List<String> regions = new ArrayList<>();

    public String material = "SALMON";

    public String rarity = "uncommon";

    public Boolean glow = Boolean.FALSE;

    public String texture;

    public Boolean shiny = Boolean.FALSE;

    public Boolean hideenchants = Boolean.FALSE;

    public int CustomModelData;

    public Boolean checkTime = Boolean.FALSE;

    public Boolean checkYPos = Boolean.FALSE;

    public Boolean checkWeather = Boolean.FALSE;

    public Boolean checkDifficulty = Boolean.FALSE;

    public Boolean CustomCompetitionPoint = Boolean.FALSE;

    public Boolean FishDiaryHide = Boolean.FALSE;

    public Boolean addCustomExp = Boolean.FALSE;

    public int minXP = 0;

    public int maxXP = 0;

    public int CCP = 0;

    public String time = "";

    public int minY = 0;

    public int maxY = 0;

    public String weather = "";

    public String difficulty = "";

    public double price = 1.0D;

    public List<String> enchants;

    public List<String> commands = new ArrayList<>();

    public String name;

    public Fish(String itemname, List<String> itemlore, double minweight, double maxweight, List<String> biome, String material, String rarity, Boolean glow, Boolean shiny, Boolean hideenchants, List<String> enchants) {
        this.itemname = itemname;
        this.itemlore = itemlore;
        this.minweight = minweight;
        this.maxweight = maxweight;
        this.biome = biome;
        this.material = material;
        this.rarity = rarity;
        this.glow = glow;
        this.shiny = shiny;
        this.hideenchants = hideenchants;
        this.enchants = enchants;
    }

    public String getItemname() {
        return this.itemname;
    }

    public int getCustomModelData() {
        return this.CustomModelData;
    }

    public void setCustomModelData(int customModelData) {
        this.CustomModelData = customModelData;
    }

    public void setCheckTime(Boolean checkTime) {
        this.checkTime = checkTime;
    }

    public void setCheckYPos(Boolean checkYPos) {
        this.checkYPos = checkYPos;
    }

    public void setCheckWeather(Boolean checkWeather) {
        this.checkWeather = checkWeather;
    }

    public void setCheckDifficulty(Boolean checkDifficulty) {
        this.checkDifficulty = checkDifficulty;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Boolean getCheckTime() {
        return this.checkTime;
    }

    public Boolean getCheckYPos() {
        return this.checkYPos;
    }

    public Boolean getCheckWeather() {
        return this.checkWeather;
    }

    public Boolean getCheckDifficulty() {
        return this.checkDifficulty;
    }

    public String getTime() {
        return this.time;
    }

    public int getMinY() {
        return this.minY;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public String getWeather() {
        return this.weather;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getCommands() {
        return this.commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getMaterial() {
        return this.material;
    }

    public List<String> getRegions() {
        return this.regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public String getTexture() {
        return this.texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public Boolean getCustomCompetitionPoint() {
        return this.CustomCompetitionPoint;
    }

    public void setCustomCompetitionPoint(Boolean customCompetitionPoint) {
        this.CustomCompetitionPoint = customCompetitionPoint;
    }

    public int getCCP() {
        return this.CCP;
    }

    public void setCCP(int CCP) {
        this.CCP = CCP;
    }

    public Boolean getFishDiaryHide() {
        return this.FishDiaryHide;
    }

    public void setFishDiaryHide(Boolean fishDiaryHide) {
        this.FishDiaryHide = fishDiaryHide;
    }

    public Boolean getAddCustomExp() {
        return this.addCustomExp;
    }

    public void setAddCustomExp(Boolean addCustomExp) {
        this.addCustomExp = addCustomExp;
    }

    public int getMinXP() {
        return this.minXP;
    }

    public void setMinXP(int minXP) {
        this.minXP = minXP;
    }

    public int getMaxXP() {
        return this.maxXP;
    }

    public void setMaxXP(int maxXP) {
        this.maxXP = maxXP;
    }
}
