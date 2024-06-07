
package settings;

import javax.swing.Icon;

public class Model_User {
    private String cardID;
    private String userFName;
    private String Role;
    private String userName;
    private Icon image;
    private String userLName;
     private String status;
    

    public String getCardID() {
        return cardID;
    }


    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getUserFName() {
        return userFName;
    }


    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getRole() {
        return Role;
    }


    public void setRole(String Role) {
        this.Role = Role;
    }

 
    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
    
    public Model_User(){
    
    }
    
    public Model_User(String userID, String userFName, String Lname, String Role, String userName, Icon image, String status){
        this.cardID = userID;
        this.userFName = userFName;
        this.userLName = Lname; 
        this.Role = Role;
        this.userName = userName;
        this.status = status;
        this.image = image;
        
    }

    /**
     * @return the userLName
     */
    public String getUserLName() {
        return userLName;
    }

    /**
     * @param userLName the userLName to set
     */
    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
