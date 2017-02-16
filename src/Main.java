/* Labb 2 i DD1352 Algoritmer, datastrukturer och komplexitet    */
/* Se labbanvisning under kurssidan http://www.csc.kth.se/DD1352 */
/* Ursprunglig författare: Viggo Kann KTH viggo@nada.kth.se      */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static List<String> readWordList(BufferedReader input) throws IOException {
    LinkedList<String> list = new LinkedList<String>();
    input = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/ordlista.txt"));
    while (true) {
      String s = input.readLine();
      if (s.equals("#"))
        break;
      list.add(s);
    }
    return list;
  }

  public static void main(String args[]) throws IOException {
        //long t1 = System.currentTimeMillis();
	System.out.println("Write Words that should be added to the dictionary:(end with '#')");
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

    // Säkrast att specificera att UTF-8 ska användas, för vissa system har annan
    // standardinställning för teckenkodningen.
    List<String> wordList = readWordList(stdin);
    String word;
    System.out.println("Write a Word:");
    while ((word = stdin.readLine()) != null) {
      ClosestWords closestWords = new ClosestWords(word, wordList);
      System.out.print(word + " (" + closestWords.getMinDistance() + ")");
      for (String w : closestWords.getClosestWords())
        System.out.print(" " + w);
      }
    
    
        //long tottime = (System.currentTimeMillis() - t1);
        //System.out.println("CPU time: " + tottime + " ms");

  }
}