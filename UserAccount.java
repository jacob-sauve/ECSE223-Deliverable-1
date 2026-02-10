/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 26 "FashionProjectManagementApp.ump"
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

  //UserAccount Associations
  private User user;

  //Helper Variables
  private boolean canSetUsername;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UserAccount(String aUsername, String aPassword, User aUser)
  {
    canSetUsername = true;
    password = aPassword;
    if (!setUsername(aUsername))
    {
      throw new RuntimeException("Cannot create due to duplicate username. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create userAccount due to user. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setUser(User aUser)
  {
    boolean wasSet = false;
    //Must provide user to userAccount
    if (aUser == null)
    {
      return wasSet;
    }

    //user already at maximum (3)
    if (aUser.numberOfUserAccounts() >= User.maximumNumberOfUserAccounts())
    {
      return wasSet;
    }
    
    User existingUser = user;
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser))
    {
      boolean didRemove = existingUser.removeUserAccount(this);
      if (!didRemove)
      {
        user = existingUser;
        return wasSet;
      }
    }
    user.addUserAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    useraccountsByUsername.remove(getUsername());
    User placeholderUser = user;
    this.user = null;
    if(placeholderUser != null)
    {
      placeholderUser.removeUserAccount(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null");
  }
}