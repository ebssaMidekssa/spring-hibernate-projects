package apps;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class Main {

  public static void main(String[] args) throws Exception {

    URL u = new URL("http://news.google.com/");
    InputStream in = u.openStream();

    in = new BufferedInputStream(in);

    Reader r = new InputStreamReader(in);
    int c;
    while ((c = r.read()) != -1) {
      System.out.print((char) c);
    }
  }

}