import java.util.Base64;

public class DecodeKey {
    public static void main(String[] args) {
        String publicKeyPEM = "-----BEGIN RSA PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAorLA053Qjut3/R3caDln\n" +
                "Jbofph7zXIFtoojlCpsuKizMqFtDcCxPVyZex1Y1zo1S27LVkPjMerAjmvJRlBGY\n" +
                "w5jlyTWlAwA2chtDqKxzngsbs7jLhm4CsVFRM5i7sac3XfJJJNdrlhf0P8phGJGN\n" +
                "X6F9km5zg0Dy0DCMRpbJrW3sSd4frg/x5Yq+eu8FwhiMbeaaNTvUnWAGPlnlUb7q\n" +
                "ehp5fm2iSa2tDjCUu6xInv/QVaqTN4f5rDQ1hfNjb5JFE9EJ/9r6Cva40/kDMicZ\n" +
                "E3qTTsNKQ5gGQIzcewmD1Z3wzUW8ISsL47Gh/UuaXJrKABEgsgUnCTkJy1UU9yd5\n" +
                "9QIDAQAB\n" +
                "-----END RSA PUBLIC KEY-----";

        // Menghapus header dan footer serta karakter newline
        String publicKeyPEMBody = publicKeyPEM
                .replace("-----BEGIN RSA PUBLIC KEY-----", "")
                .replace("-----END RSA PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        // Mendekode base64 menjadi byte array
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyPEMBody);

        System.out.println(publicKeyBytes);
        // Menggunakan byte array untuk membuat kunci publik RSA
        // Anda dapat menggunakan kunci ini untuk operasi kriptografi RSA
        // Misalnya, dengan mengubahnya menjadi objek PublicKey menggunakan KeyFactory

        System.out.println("Decoded public key bytes length: " + publicKeyBytes.length);
    }
}