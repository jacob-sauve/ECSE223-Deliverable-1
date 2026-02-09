/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;

// line 65 "FashionProjectManagementApp.ump"
public class LimitedItem extends LimitedStatus
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LimitedItem(Date aStartDate, Date aEndDate, ClothingItem aLimitedItem)
  {
    super(aStartDate, aEndDate, aLimitedItem);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}