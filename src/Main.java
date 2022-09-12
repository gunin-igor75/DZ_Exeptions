public class Main {

    public static boolean check(String login, String password, String confirmPassword) {

        String sample = "^[a-zA-Z0-9_]*$"; // латинские буквы, цифры и знак подчеркивания
        boolean resultLogin = login.matches(sample) && login.length() <= 20;
        boolean resultPassword = password.matches(sample) && login.length() < 20 && password.equals(confirmPassword);
        if (!resultLogin) {
            try {
                throw new WrongLoginException();
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
        System.out.println(check("sdsd_ksds", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
        System.out.println(check("ava_skypбаааrogo", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
        System.out.println(check("ava_skypzazazazazzazazarogo", "D_1hWiKjjP_9", "D_1hWiKjjP_9"));
    }
}