import java.math.BigInteger;
import java.nio.charset.StandardCharsets; import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException; import java.util.*;

public class PasswordGenerator {


public static byte[] obtainSHA(String s) throws NoSuchAlgorithmException {
// Static getInstance() method is invoked with the hashing SHA-256 MessageDigest msgDgst = MessageDigest.getInstance("SHA-256");

// the digest() method is invoked
// to compute the message digest of the input
// and returns an array of byte
return msgDgst.digest(s.getBytes(StandardCharsets.UTF_8));
}


public static String toHexStr(byte[] hash) {
// Converting the byte array in the signum representation BigInteger no = new BigInteger(1, hash);

// Converting the message digest into the hex value StringBuilder hexStr = new StringBuilder(no.toString(16));

while (hexStr.length() < 32) { hexStr.insert(0, '0');
}


return hexStr.toString();
}
 

public static String genPass(String username, String pass1, int n) throws NoSuchAlgorithmException {
n = n - n / 2; String pass2 = "";
String s1 = "qwertyuioplkjhgfdsazxcvbnm"; String s2 = "!@#$%^&*?";

String hash = toHexStr(obtainSHA(username));


pass2 += s2.charAt((int) ((s2.length()) * Math.random())); pass2 += hash.charAt((int) ((hash.length()) * Math.random()));

for (int i = 0; i < n - 3; i++) {
int rand = (int) (2 * Math.random());


switch (rand) { case 0:
pass2 += s1.toUpperCase().charAt((int) ((s1.length()) *
Math.random()));

break;

case 1:

pass2 += s1.charAt((int) ((s1.length()) * Math.random())); break;
}

}


pass2 += ((int) (10 * Math.random()));


return pass2 + pass1;

}
 
public static void main(String[] args) {


Scanner sc = new Scanner(System.in); System.out.println("Please enter your name");

String username = sc.nextLine();


System.out.println("Enter length of the password (keep minimum length 8 for a strong password)");


int len = sc.nextInt();

System.out.println("Please enter password of length " + len / 2 + " (containing only
alphabates)");


Scanner sc1 = new Scanner(System.in); String pass1 = sc1.nextLine();
System.out.println("Recommended passwords are "); for (int i = 0; i < 5; i++) {
try {
System.out.println(genPass(username, pass1, len));
} catch (NoSuchAlgorithmException e) {
// TODO Auto-generated catch block e.printStackTrace();
}
}


}

}
