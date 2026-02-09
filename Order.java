/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 13 "FashionProjectManagementApp.ump"
public class Order
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextOrderNumber = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int orderNumber;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order()
  {
    orderNumber = nextOrderNumber++;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getOrderNumber()
  {
    return orderNumber;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "orderNumber" + ":" + getOrderNumber()+ "]";
  }
}