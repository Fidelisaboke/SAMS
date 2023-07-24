public abstract class LoginAccount {
    abstract void getDetails();
   public static float radius;
   public static int length;
   public static int width;
   public static int side;
    public static Shape createAccount(String user) {
        if (user.equals("teacher")) {
            return new Circle(radius);
        }
        if (user.equals("student")) {
            return new Rectangle(length, width);
        }
        else {
            System.out.println("Please input correct details");
        }


        return null;
    }
}
