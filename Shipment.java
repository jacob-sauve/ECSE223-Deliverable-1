/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;

// line 35 "FashionProjectManagementApp.ump"
public class Shipment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shipment Attributes
  private Date deliveryDate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shipment(Date aDeliveryDate)
  {
    deliveryDate = aDeliveryDate;
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

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "deliveryDate" + "=" + (getDeliveryDate() != null ? !getDeliveryDate().equals(this)  ? getDeliveryDate().toString().replaceAll("  ","    ") : "this" : "null");
  }
}