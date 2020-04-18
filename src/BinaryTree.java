/**
 * Extraido de: Duane A Bailey (2007) java structures in java for principled programmer edición raiz 7
 * Clase para implementar un BinaryTree
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;

public class BinaryTree<E>
{

    protected E val; // value associated with node
	protected BinaryTree<E> parent; // parent of node
	protected BinaryTree<E> left, right; // children of node
	
	
	public BinaryTree()
	// post: constructor that generates an empty node
	{
		val = null;
		parent = null; 
		left = right = this;
	}
	
	public BinaryTree(E value)
	// post: returns a tree referencing value and two empty subtrees
	{
		val = value;
		right = left = new BinaryTree<E>();
		setLeft(left);
		setRight(right);
	}
	
	public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
	// post: returns a tree referencing value and two subtrees
	{
		val = value;
		if (left == null) { left = new BinaryTree<E>(); }
		setLeft(left);
		if (right == null) { right = new BinaryTree<E>(); }
		setRight(right);
	}
	
	public BinaryTree<E> left()
	// post: returns reference to (possibly empty) left subtree
	// post: returns reference to (possibly empty) left subtree
	{
		return left;
	}
	
	public BinaryTree<E> parent()
	// post:
	{
		return null;
	}
	// post: returns reference to parent node, or null
	
	public void setLeft(BinaryTree<E> newLeft)
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	{
		if (isEmpty()) return;
		if (left != null && left.parent() == this) left.setParent(null);
		left = newLeft;
		left.setParent(this);
	}
	
	private void setRight(BinaryTree<E> newRight) 
	// post: sets right subtree to newRight
	// re-parents newRight if not null
	{
		if (isEmpty()) return;
		if (right != null && right.parent() == this) right.setParent(null);
		right = newRight;
		right.setParent(this);
	}
	
	private boolean isEmpty() 
	// post: return true or false
	{
		return false;
	}

	protected void setParent(BinaryTree<E> newParent)
	// post: re-parents this node to parent reference, or null
	{
		if (!isEmpty()) {
		parent = newParent;
		}
	}
	
	public Iterator<E> iterator(){
		return null;
	}
	// post: returns an in-order iterator of the elements
	
	public boolean isLeftChild() {
		return false;
	}
	// post: returns true if this is a left child of parent
	
	public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	}
	
	/**
	 * @param dictionary lista de palabras que serán asociadas
	 * @param lang lenguaje en el que se desea el listado EN para inglés, ES para español
	 * @return retorna una lista de palabras del diccionario según el idioma que se desea
	 */
	public List<String> dictionaryWords(ArrayList<String> dictionary, String lang) {
		List<String> wordsList = null;
		if (lang.equals("EN")) {
			int n = dictionary.size();
			wordsList = new ArrayList<String>();
			for(int i = 0; i < n; i = i+2) {
				wordsList.add(dictionary.get(i));
			}
		}else if (lang.equals("ES")) {
			int n = dictionary.size();
			wordsList = new ArrayList<String>();
			for(int i = 1; i<n; i = i +2) {
				wordsList.add(dictionary.get(i));
			}
		}
		return wordsList;
	}
	
	/**
	 * @param englishWords listado de palabras en inglés
	 * @param spanishWords listado de palabras en español
	 * @param totalWords total de palabras del diccionario
	 * @return retorna el diccionario asociando las palabras en inglés y español
	 */
	public Map<String, String> createDictionary(List<String> englishWords, List<String> spanishWords, int totalWords){
		Map<String, String> associationMap = new Hashtable<String, String>();
		for(int i = 0; i < totalWords; i++) {
			associationMap.put(englishWords.get(i), spanishWords.get(i));
		}
		return associationMap;
	}
	
	/**
	 * @param text es el texto que se va a traducir
	 * @param dictionaryMap diccionario para poder traducir el texto
	 * @return retorna el texto traducido.
	 */
	public String translate(String[] text, Map<String, String> dictionaryMap ) {
		String translate = "";
		for(int i = 0; i < text.length; i++) {
			boolean h = dictionaryMap.containsKey(text[i]);
			if(h == true) {
				translate = translate + dictionaryMap.get(text[i]);
			}
			else {
				translate = translate + (" *")+text[i]+("*");
			}
		}
		return translate;
	}
}