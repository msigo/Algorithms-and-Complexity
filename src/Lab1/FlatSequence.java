package Lab1;


public class FlatSequence {
	
	public FlatSequence(){
	
	}
	public static int FL(double[] sequence, int k){
		if(k<1 || k>sequence.length) return 0;
		if(k==1) return 1;
		if(sequence[k-1]-sequence[k-2]>0 && sequence[k-1]-sequence[k-2]<1) return FL(sequence, k-1)+1;
		return 1;
		
	}
	public static int FL_dp(double[] sequence, int k){
		if(k<1 || k>sequence.length) return 0;
		int[] FL = new int[k];
		FL[0] = 1;
		for(int i =2; i<=k;i++){
			if(sequence[i-1]-sequence[i-2]>0 && sequence[i-1]-sequence[i-2]<1) 
				FL[i-1] = FL[i-2]+1;
			else
				FL[i-1] = 1;
		}
		return FL[k-1];
		
	}
	
	
	public static void main(String args[]){
		//double[] list = new double[]{0.7,1.5,2.3,2.4,2.5,3.4,4.3,5};
		//double[] list = new double[]{0.25,0.22,0.2,0.3};
		double[] list = new double[]{0.1,0.2,0.3,0.4,0.5,10.5,0.6,0.7,0.8,0.9};
		System.out.println(FlatSequence.FL_dp(list, 10));
		System.out.println(list.length);
	}
}
