/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urusan_login_logout;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ASUS
 */
public class coba_sha256 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    String text = "admin";

    md.update(text.getBytes(StandardCharsets.UTF_8));
    byte[] digest = md.digest();

    String output_thesha256 = String.format("%064x", new BigInteger(1, digest));
    System.out.println(output_thesha256);
  }
}
