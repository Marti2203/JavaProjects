package defaultPackage;
import java.net.*;

public class EvilEmpire {
  public static void main(String[] args) throws Exception{
    try {
      @SuppressWarnings("resource")
	Socket socket = new Socket("25.28.126.198", 80);
	System.out.printf("Connected to %s!",socket.getLocalAddress().toString());
    }
    catch (SecurityException e) {
      System.out.println("SecurityException: could not connect.");
    }
  }
}