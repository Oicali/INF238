
package model;

import javax.swing.Icon;

public class Model_Products {
    private double price;
    private int stocks;
    private String itemName;
    private Icon image;
    private String ID;
    private String category;
    
    public Model_Products(){
    
    }
    
    public Model_Products(String itemName, Icon image, int stocks, double price, String ID, String category){
        this.itemName = itemName;
        this.stocks = stocks;
        this.price = price; 
        this.image = image; 
        this.ID = ID;
        this.category = category;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the stocks
     */
    public int getStocks() {
        return stocks;
    }

    /**
     * @param stocks the stocks to set
     */
    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the image
     */
    public Icon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Icon image) {
        this.image = image;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
}
