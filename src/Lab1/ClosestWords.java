package Lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestWords {
	private ArrayList<String> closestWords = new ArrayList<String>();
	private int closestDistance = -1;
	private int [][] editingDistanceMatrix;
	private String prevWord ="";
	// The longest word in the Oxford English dictionary is 45 letters long.
	// https://en.oxforddictionaries.com/explore/what-is-the-longest-english-word
	static int MAX_LENGTH_OF_WORD = 46; 

	public ClosestWords(String w, List<String> wordList) {
		int distance = -1;
		this.editingDistanceMatrix = new int[w.length()+1][MAX_LENGTH_OF_WORD+1];
		
		for(int i=0; i <w.length()+1;i++){
			editingDistanceMatrix[i][0]=i;
		}
		for(int j=0; j<MAX_LENGTH_OF_WORD+1;j++){
			editingDistanceMatrix[0][j]=j;
		}
		for(String s:wordList){	
			distance = calculateDistance(w, s, w.length(), s.length());
			if(distance <this.closestDistance || this.closestDistance ==-1){
				this.closestDistance = distance;
				closestWords.clear();
				closestWords.add(s);
			}
			else {
				if(distance == this.closestDistance){
					closestWords.add(s);
				}
			}
		}
	}
	
	
	private int calculateDistance(String word1, String word2, int w1len, int w2len){
		int length = Math.min(w2len, this.prevWord.length());
		int numberOfMatchingLetters=0;
		for(int i =0; i<length && word2.charAt(i) == prevWord.charAt(i);i++){
			numberOfMatchingLetters++;
		}
		
		if (Math.abs(w2len - w1len) > getMinDistance() && getMinDistance() != -1) {
			return MAX_LENGTH_OF_WORD+1;
		}
		
		//calculate editDistanceMatrix
		for(int i=1; i <w1len+1;i++){
			for(int j = numberOfMatchingLetters+1; j<w2len+1; j++){
				if( word1.charAt(i-1) == word2.charAt(j-1) ){
					editingDistanceMatrix[i][j] = editingDistanceMatrix[i-1][j-1];
				}
				else{
					editingDistanceMatrix[i][j] = 1 + Math.min(editingDistanceMatrix[i-1][j],Math.min(editingDistanceMatrix[i][j-1],editingDistanceMatrix[i-1][j-1]));
				}
			}
		}
		this.prevWord = word2;
		return editingDistanceMatrix[w1len][w2len];
	}
	
	
	
	public ArrayList<String> getClosestWords(){
		return closestWords;
	}
	
	public int getMinDistance(){
		return closestDistance;
	}
}
