package filing;

import java.io.FileReader;
import java.io.IOException;

public class Counting {

    public static void main(String[] args) {
        String path = "data\\textInput.txt";
        try(FileReader fr = new FileReader(path)){
            int loaded;
            int lineCount = 0, charCount = 0, sentenceCount = 0, wordCount = 0;

            while ((loaded = fr.read()) != -1){
                System.out.print((char)loaded);
                if (loaded == '\n'){
                    lineCount++;
                    wordCount++;
                }
                if (loaded == '.' || loaded == '?' || loaded == '!'){
                    sentenceCount++;
                }
                if (loaded == ' '){
                    wordCount++;
                }
                charCount++;
            }

            System.out.println("Stats:");
            System.out.println("Chars: " + charCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Lines: " + lineCount);
            System.out.println("Sentences: " + sentenceCount);
        }catch (IOException e){
            System.out.println("Chyba pri cteni: " + e.getMessage());
        }
    }

}