/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 28 "FashionProjectManagementApp.ump"
public class Customer extends UserAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String address;
  private String points;

  //Customer Associations
  private Cart cart;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aUsername, String aPassword, String aName, int aPhoneNumber, FashionStoreManagementApp aApp, String aAddress, String aPoints, Cart aCart)
  {
    super(aUsername, aPassword, aName, aPhoneNumber, aApp);
    address = aAddress;
    points = aPoints;
    if (aCart == null || aCart.getShopper() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aCart. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    cart = aCart;
  }

  public Customer(String aUsername, String aPassword, String aName, int aPhoneNumber, FashionStoreManagementApp aApp, String aAddress, String aPoints)
  {
    super(aUsername, aPassword, aName, aPhoneNumber, aApp);
    address = aAddress;
    points = aPoints;
    cart = new Cart(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPoints(String aPoints)
  {
    boolean wasSet = false;
    points = aPoints;
    wasSet = true;
    return wasSet;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPoints()
  {
    return points;
  }
  /* Code from template association_GetOne */
  public Cart getCart()
  {
    return cart;
  }

  public void delete()
  {
    Cart existingCart = cart;
    cart = null;
    if (existingCart != null)
    {
      existingCart.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "address" + ":" + getAddress()+ "," +
            "points" + ":" + getPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cart = "+(getCart()!=null?Integer.toHexString(System.identityHashCode(getCart())):"null");
  }
}