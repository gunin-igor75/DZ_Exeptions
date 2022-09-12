public class Main {

    public static boolean check(String login, String password, String confirmPassword) {
        String sample = "\\w+"; // латинские буквы, цифры и знак подчеркивания
        boolean resultLogin = login.matches(sample) && login.length() <= 20;
        boolean resultPassword = login.matches(sample) && login.length() < 20 && password.equals(confirmPassword);
        if (!resultLogin) {
            try {
                new WrongLoginException();
            } catch (WrongLoginException e) {
                return false;
            }
        }
        if (!resultPassword) {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("ava_skyprogo", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
        System.out.println(check("ava_skyp,rogo", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
        System.out.println(check("ava_skypzazazazazzazazarogo", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
    }
}