package com.pracha.orderorganic.models.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categorywiseproductlist {

    @SerializedName("Home & Kitchen")
    @Expose
    private List<HomeKitchen> homeKitchen = null;
    @SerializedName("Mens Fashion")
    @Expose
    private List<MensFashion> mensFashion = null;
    @SerializedName("Mobiles & Tablets")
    @Expose
    private List<MobilesTablet> mobilesTablets = null;
    @SerializedName("Grocery")
    @Expose
    private List<Grocery> grocery = null;
    @SerializedName("Computers, Laptops & Accessories")
    @Expose
    private List<ComputersLaptopsAccessory> computersLaptopsAccessories = null;
    @SerializedName("TVs, ACs & Appliances")
    @Expose
    private List<TVsACsAppliance> tVsACsAppliances = null;
    @SerializedName("Women's Fashion")
    @Expose
    private List<WomenSFashion> womenSFashion = null;
    @SerializedName("Car & Bike Accessories")
    @Expose
    private List<CarBikeAccessory> carBikeAccessories = null;
    @SerializedName("Books & Stationary")
    @Expose
    private List<BooksStationary> booksStationary = null;
    @SerializedName("Kids Store")
    @Expose
    private List<KidsStore> kidsStore = null;
    @SerializedName("Sports & Fitness")
    @Expose
    private List<SportsFitness> sportsFitness = null;
    @SerializedName("Furniture & Home-Living")
    @Expose
    private List<FurnitureHomeLiving> furnitureHomeLiving = null;
    @SerializedName("Gifts Store")
    @Expose
    private List<GiftsStore> giftsStore = null;
    @SerializedName("Bags & Outdoor")
    @Expose
    private List<BagsOutdoor> bagsOutdoor = null;

    public List<HomeKitchen> getHomeKitchen() {
        return homeKitchen;
    }

    public void setHomeKitchen(List<HomeKitchen> homeKitchen) {
        this.homeKitchen = homeKitchen;
    }

    public List<MensFashion> getMensFashion() {
        return mensFashion;
    }

    public void setMensFashion(List<MensFashion> mensFashion) {
        this.mensFashion = mensFashion;
    }

    public List<MobilesTablet> getMobilesTablets() {
        return mobilesTablets;
    }

    public void setMobilesTablets(List<MobilesTablet> mobilesTablets) {
        this.mobilesTablets = mobilesTablets;
    }

    public List<Grocery> getGrocery() {
        return grocery;
    }

    public void setGrocery(List<Grocery> grocery) {
        this.grocery = grocery;
    }

    public List<ComputersLaptopsAccessory> getComputersLaptopsAccessories() {
        return computersLaptopsAccessories;
    }

    public void setComputersLaptopsAccessories(List<ComputersLaptopsAccessory> computersLaptopsAccessories) {
        this.computersLaptopsAccessories = computersLaptopsAccessories;
    }

    public List<TVsACsAppliance> getTVsACsAppliances() {
        return tVsACsAppliances;
    }

    public void setTVsACsAppliances(List<TVsACsAppliance> tVsACsAppliances) {
        this.tVsACsAppliances = tVsACsAppliances;
    }

    public List<WomenSFashion> getWomenSFashion() {
        return womenSFashion;
    }

    public void setWomenSFashion(List<WomenSFashion> womenSFashion) {
        this.womenSFashion = womenSFashion;
    }

    public List<CarBikeAccessory> getCarBikeAccessories() {
        return carBikeAccessories;
    }

    public void setCarBikeAccessories(List<CarBikeAccessory> carBikeAccessories) {
        this.carBikeAccessories = carBikeAccessories;
    }

    public List<BooksStationary> getBooksStationary() {
        return booksStationary;
    }

    public void setBooksStationary(List<BooksStationary> booksStationary) {
        this.booksStationary = booksStationary;
    }

    public List<KidsStore> getKidsStore() {
        return kidsStore;
    }

    public void setKidsStore(List<KidsStore> kidsStore) {
        this.kidsStore = kidsStore;
    }

    public List<SportsFitness> getSportsFitness() {
        return sportsFitness;
    }

    public void setSportsFitness(List<SportsFitness> sportsFitness) {
        this.sportsFitness = sportsFitness;
    }

    public List<FurnitureHomeLiving> getFurnitureHomeLiving() {
        return furnitureHomeLiving;
    }

    public void setFurnitureHomeLiving(List<FurnitureHomeLiving> furnitureHomeLiving) {
        this.furnitureHomeLiving = furnitureHomeLiving;
    }

    public List<GiftsStore> getGiftsStore() {
        return giftsStore;
    }

    public void setGiftsStore(List<GiftsStore> giftsStore) {
        this.giftsStore = giftsStore;
    }

    public List<BagsOutdoor> getBagsOutdoor() {
        return bagsOutdoor;
    }

    public void setBagsOutdoor(List<BagsOutdoor> bagsOutdoor) {
        this.bagsOutdoor = bagsOutdoor;
    }

}