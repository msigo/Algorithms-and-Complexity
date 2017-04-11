package Lab2;

public class CastingReducer {
	public CastingReducer(){
		Kattio io = new Kattio(System.in,System.out);
		
		int V = io.getInt();
		int E = io.getInt();
		int m = io.getInt();
		
		int n = V + 2;
		int s = E + 2;
		int k = m + 2;
		
		io.println("" + n);
		io.println("" + s);
		io.println("" + k);
		
		//Constraint 1:
		// Start with the two divas, they need a role each
		io.println("1 1");
		io.println("1 2");
		
		//There must be a third actor to play against the diva. 
		io.println("1 3");
		
		//If there are more actors, give them the possibility to play all other roles
		StringBuilder roleRow = new StringBuilder(); 
		if(n>3){
			roleRow.append((k-2)); // all actors, except the divas can play this role
			for(int i = 3; i<=k; i++){
				roleRow.append(" " + i);
			}
			String row = roleRow.toString(); 
			for(int i = 4; i<=n;i++ ){
				io.println(row);
			}
		}
		
		// Constraint 2:
		//Start with the 2 divas: 
		io.println("2 1 3");
		io.println("2 2 3");
		
		//For the rest of the edges, representing two roles that plays in the same scene:
		int startEdge = 0;
		int endEdge = 0;
		for(int i = 1; i<=s-2;i++){
			startEdge = io.getInt() + 2 ;
			endEdge   = io.getInt() + 2 ;
			
			io.println("2 " + startEdge + " " + endEdge);
		}
		
		
		io.close();
		
	}
	public static void main(String[] args) {
		new CastingReducer();
	}
}
