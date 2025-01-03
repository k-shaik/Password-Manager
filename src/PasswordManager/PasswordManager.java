package PasswordManager;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {
    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;
    private final Map<String, String> passwordStore = new HashMap<>();

    public static void main(String[] args) {
        PasswordManager manager = new PasswordManager();
        Scanner scanner = new Scanner(System.in);

        try {
            generateSecretKey(); // Generate a secure key at runtime

            while (true) {
                System.out.println("\nPassword Manager");
                System.out.println("================");
                System.out.println("1. Add Password");
                System.out.println("2. Retrieve Password");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                
                String choice = scanner.nextLine().trim();
                
                switch (choice) {
                    case "1":
                        System.out.print("Enter site: ");
                        String site = scanner.nextLine().trim();
                        if (site.isEmpty()) {
                            System.out.println("Site cannot be empty.");
                            break;
                        }

                        System.out.print("Enter password: ");
                        String password = scanner.nextLine().trim();
                        if (password.isEmpty()) {
                            System.out.println("Password cannot be empty.");
                            break;
                        }

                        manager.addPassword(site, password);
                        break;

                    case "2":
                        System.out.print("Enter site: ");
                        site = scanner.nextLine().trim();
                        if (site.isEmpty()) {
                            System.out.println("Site cannot be empty.");
                            break;
                        }

                        String retrievedPassword = manager.getPassword(site);
                        System.out.println("Password: " + retrievedPassword);
                        break;

                    case "3":
                        System.out.print("Are you sure you want to exit? (yes/no): ");
                        String exitConfirmation = scanner.nextLine().trim();
                        if (exitConfirmation.equalsIgnoreCase("yes")) {
                            System.out.println("Goodbye!");
                            return;
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static void generateSecretKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128); // AES key size
            secretKey = keyGen.generateKey();
            System.out.println("Secret key generated successfully.");
        } catch (Exception e) {
            throw new RuntimeException("Error generating secret key.", e);
        }
    }

    public void addPassword(String site, String password) {
        try {
            String encryptedPassword = encrypt(password);
            passwordStore.put(site, encryptedPassword);
            System.out.println("Password added successfully.");
        } catch (Exception e) {
            System.out.println("Error encrypting password: " + e.getMessage());
        }
    }

    public String getPassword(String site) {
        try {
            String encryptedPassword = passwordStore.get(site);
            return encryptedPassword != null ? decrypt(encryptedPassword) : "No password found for this site.";
        } catch (Exception e) {
            return "Error decrypting password: " + e.getMessage();
        }
    }

    private String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
}
