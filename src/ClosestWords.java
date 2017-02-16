import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestWords {
	private ArrayList<String> closestWords = new ArrayList<String>();
	private int closestDistance = -1;

	public ClosestWords(String w, List<String> wordList) {
		int distance = -1;
		
		for(String s:wordList){	
			distance = calculateDistance(w, s, w.length(), s.length());
			if(distance <closestDistance || closestDistance ==-1){
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
		int [][] editingDistanceMatrix = new int[w1len+1][w2len+1];
		
		//initialization of borders in the matrix
		for(int i=0; i <w1len+1;i++){
			editingDistanceMatrix[i][0]=i;
		}
		for(int j=0; j<w2len+1;j++){
			editingDistanceMatrix[0][j]=j;
		}
		
		//calculate editDistanceMatrix
		for(int i=1; i <w1len+1;i++){
			for(int j = 1; j<w2len+1; j++){
				if( word1.charAt(i-1) == word2.charAt(j-1) ){
					editingDistanceMatrix[i][j] = editingDistanceMatrix[i-1][j-1];
				}
				else{
					editingDistanceMatrix[i][j] = 1 + Math.min(editingDistanceMatrix[i-1][j],Math.min(editingDistanceMatrix[i][j-1],editingDistanceMatrix[i-1][j-1]));
				}
			}
		}
		return editingDistanceMatrix[w1len][w2len];
	}
	
	
	
	public ArrayList<String> getClosestWords(){
		return closestWords;
	}
	
	public int getMinDistance(){
		return closestDistance;
	}
}
