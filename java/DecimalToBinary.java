public class DecimalToBinary {

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "";
        }

        return decimalToBinary(decimal / 2) + (decimal % 2);
    }

    public static void main(String[] args) {
        int decimalNumber = 222;
        String binaryString = decimalToBinary(decimalNumber);

        if (binaryString.isEmpty()) {
            binaryString = "0";
        }

        System.out.println("Bilangan desimal " + decimalNumber + " dalam biner adalah " + binaryString);
    }
}
