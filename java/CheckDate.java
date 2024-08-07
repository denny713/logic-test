import java.text.SimpleDateFormat;

public class CheckDate {

    public static boolean cekDate() {
        try {
            String dateString = "2000-09-11";

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(dateString);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(cekDate());
    }
}
