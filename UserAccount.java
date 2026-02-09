/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 21 "FashionProjectManagementApp.ump"
public abstract class UserAccount
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, UserAccount> useraccountsByUsername = new HashMap<String, UserAccount>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UserAccount Attributes
  private String username;
  private String password;
  private String name;
  private int phoneNumber;

  //UserAccount Associations
  private FashionStoreManagementApp app;

  //Helper Variables
  private boolean canSetUsername;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UserAccount(String aUsername, String aPassword, FashionStoreManagementApp aApp)
  {
    canSetUsername = true;
    password = aPassword;
    name = null;
    phoneNumber = 0;
    if (!setUsername(aUsername))
    {
      throw new RuntimeException("Cannot create due to duplicate username. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddApp = setApp(aApp);
    if (!didAddApp)
    {
      throw new RuntimeException("Unable to create userAccount due to app. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetImmutable */
  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    if (!canSetUsername) { return false; }
    String anOldUsername = getUsername();
    if (anOldUsername != null && anOldUsername.equals(aUsername)) {
      return true;
    }
    if (hasWithUsername(aUsername)) {
      return wasSet;
    }
    canSetUsername = false;
    username = aUsername;
    wasSet = true;
    if (anOldUsername != null) {
      useraccountsByUsername.remove(anOldUsername);
    }
    useraccountsByUsername.put(aUsername, this);
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(int aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }
  /* Code from template attribute_GetUnique */
  public static UserAccount getWithUsername(String aUsername)
  {
    return useraccountsByUsername.get(aUsername);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithUsername(String aUsername)
  {
    return getWithUsername(aUsername) != null;
  }

  /**
   * constrain to a non-empty (+), unique, alphanumeric string
   * not currently functional
   * password mandatory
   */
  public String getPassword()
  {
    return password;
  }

  public String getName()
  {
    return name;
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
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
      existingApp.removeUserAccount(this);
    }
    app.addUserAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    useraccountsByUsername.remove(getUsername());
    FashionStoreManagementApp placeholderApp = app;
    this.app = null;
    if(placeholderApp != null)
    {
      placeholderApp.removeUserAccount(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "," +
            "name" + ":" + getName()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "app = "+(getApp()!=null?Integer.toHexString(System.identityHashCode(getApp())):"null");
  }
}