package main.java.com.mysko.rps;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


import static main.java.com.mysko.rps.Mains.gameArray;

public class Computer {

    private static final String HMAC_ALGO = "HmacSHA256";
    private byte []bytes = new byte[16];
    private int computerMove;
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length*2);
        for (byte b: bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public  void computerMove() throws InvalidKeyException, NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        computerMove = secureRandom.nextInt(gameArray.size() );
        secureRandom.nextBytes(bytes);
        Mac signer = Mac.getInstance(HMAC_ALGO);
        SecretKeySpec keySpec = new SecretKeySpec(bytes, HMAC_ALGO);
        signer.init(keySpec);
        byte[] result = signer.doFinal(gameArray.get(computerMove).getBytes());
        System.out.println("HMAC: " + bytesToHex(result));
    }

    public void getKey() {
        System.out.println("Key: " + bytesToHex(bytes));
    }

    public int getComputerMove() {
       return computerMove;
    }


}
