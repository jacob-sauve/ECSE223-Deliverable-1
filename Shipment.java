/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;

// line 41 "FashionProjectManagementApp.ump"
public class Shipment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shipment Attributes
  private Date deliveryDate;

  //Shipment Associations
  private FashionStoreManagementApp app;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shipment(Date aDeliveryDate, FashionStoreManagementApp aApp)
  {
    deliveryDate = aDeliveryDate;
    boolean didAddApp = setApp(aApp);
    if (!didAddApp)
    {
      throw new RuntimeException("Unable to create shipment due to app. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDeliveryDate(Date aDeliveryDate)
  {
    boolean wasSet = false;
    deliveryDate = aDeliveryDate;
    wasSet = true;
    return wasSet;
  }

  public Date getDeliveryDate()
  {
    return deliveryDate;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getApp()
  {
    return app;
  }
  /* Code from template association_SetOneToMany */
  public boolean setApp(FashionStoreManagementApp aApp)
  {
    boolean wasSet = false;
    if (aApp == null)
    {
      return wasSet;
    }

    FashionStoreManagementApp existingApp = app;
    app = aApp;
    if (existingApp != null && !existingApp.equals(aApp))
    {
      existingApp.removeShipment(this);
    }
    app.addShipment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    FashionStoreManagementApp placeholderApp = app;
    this.app = null;
    if(placeholderApp != null)
    {
      placeholderApp.removeShipment(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "deliveryDate" + "=" + (getDeliveryDate() != null ? !getDeliveryDate().equals(this)  ? getDeliveryDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "app = "+(getApp()!=null?Integer.toHexString(System.identityHashCode(getApp())):"null");
  }
}