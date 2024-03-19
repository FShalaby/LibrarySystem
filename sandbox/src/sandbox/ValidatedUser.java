package sandbox;

public class ValidatedUser extends User
{
    //User to be 'decorated' by this wrapper
    User verified;

    public ValidatedUser(User user)
    {
        this.verified = user;
        verified.isVerified = true; //They're now validated
    }

    /*We need to delegate the User methods to our validated user
        -generateRandomID is static, can't override here.
        -writeUserCsv is delegated.
        -subscription methods (as seen in Figma diagrams) to be added.
        -any additional methods we add during implementation.
    */

    public synchronized void writeUserCsv() {
        Database.getInstance().insertUser(verified.name, verified.id, verified.email, verified.pw, verified.type,verified.isVerified);
      }

    //Accessor methods
    public boolean getIsVerified()
    {
        return verified.isVerified;
    }

    //Behaviours usable only by validated users below:
    //...
}
