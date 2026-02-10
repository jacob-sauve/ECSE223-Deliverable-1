/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 41 "FashionProjectManagementApp.ump"
public class Manager extends UserAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Attributes
  private String username;
  private String password;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager(String aUsername, String aPassword, User aUser, FashionStoreManagementApp aApp)
  {
    super(aUsername, aPassword, aUser, aApp);
    username = "manager";
    password = "manager";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]";
  }
}