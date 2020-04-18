import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;

public class Main {
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void main(String[] args) {
		//archivo del diccionario
		File dictionaryFile = new File(System.getProperty("user.dir") + "\\src\\diccionario.txt");
		//arbol binario
		BinaryTree bt = new BinaryTree();
		
		System.out.println("-----------------------------");
		System.out.println("|   Traductor de archivos   |");
		System.out.println("|    de inglés a español    |");
		System.out.println("-----------------------------");
		//existe el diccionario?
		if(dictionaryFile.exists()) {
			try {
				//lectura del diccionario
				FileReader fr = new FileReader(dictionaryFile);
				BufferedReader br = new BufferedReader(fr);
				
				String assosiation = "";
				ArrayList<String> fileWords = new ArrayList<String>();
				List<String> englishWords = new ArrayList<String>();
				List<String> spanishWords = new ArrayList<String>();
				Map<String, String> dictionary = new Hashtable<String, String>();
				
				int wordCount = 0;
				while((assosiation = br.readLine()) != null) {
					String text = assosiation.substring( 1, assosiation.length() - 1).toLowerCase();
					String[] dictionaryWords = text.split(",");
					fileWords.add(dictionaryWords[0]);
					fileWords.add(dictionaryWords[1]);
					wordCount++;
				}

				br.close();
				fr.close();
				
				//archivo con el texto a traducir
				File textFile = new File(System.getProperty("user.dir") + "\\src\\texto.txt");
				
				//existe el archivo para traducir?
				if (textFile.exists()) {
					//lectura del archivo
					FileReader fr_EN = new FileReader(textFile);
					BufferedReader br_EN = new BufferedReader(fr_EN);
					
					String englishText = br_EN.readLine().toLowerCase();
									
					System.out.println("\nTexto del archivo: ");
					System.out.println(englishText);
					
					String[] englishTextList = englishText.split(" ");
						
					//se obtienen las palabras en inglés
					englishWords = bt.dictionaryWords(fileWords, "EN");
					//se obtienen las palabras en español
					spanishWords = bt.dictionaryWords(fileWords, "ES");
					//se crea las asociaciones para el crear el diccionario
					dictionary = bt.createDictionary(englishWords, spanishWords, wordCount);
					
					//se traduce el texto
					System.out.println("\nTexto Traducido: ");
					System.out.println(bt.translate(englishTextList, dictionary).replaceAll("^\\s+",""));
					
					System.out.println("\n-----------------------------");
					System.out.println("|     Archivo traducido     |");
					System.out.println("-----------------------------");
					
					br_EN.close();
					fr_EN.close();
				}else {
					throw new NullPointerException("");
				}
				
			}catch(Exception e) {
				System.out.println("Existe un error con los archivos, el programa terminó");
			}
		}
	}
}