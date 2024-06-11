
package testing;

import javax.swing.Icon;


public class Model_Pro {
    private double price;
    private int stocks;
    private String itemName;
    private Icon image;

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
    
    public Model_Pro(){
    
    }
    
    public Model_Pro(String itemName, Icon image, int stocks, double price){
        this.itemName = itemName;
        this.stocks = stocks;
        this.price = price; 
        this.image = image;    
    }
    
}
