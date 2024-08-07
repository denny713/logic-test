public class YearToCentury {
    public static int getCentury(int year) {
        return (year + 99) / 100;
    }

    public static void main(String[] args) {
        int year = 512;
        System.out.println("Tahun " + year + " berada di abad ke-" + getCentury(year));
    }
}
