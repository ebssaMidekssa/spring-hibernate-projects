package apps;

import java.util.ArrayList;
import java.util.List;

public class Secrete {
	public static boolean isprimeNo(int i){
		boolean isboolean = false;
		return isboolean;
	}

	public static  List<Integer> getPrimeArray()

	{
		List<Integer> primes = new ArrayList<Integer>();

		for (int i=0; i<100 ; i++){

			if(isprimeNo(i))
			primes.add(i);
		}
		return primes;
	}

	public boolean checkSecretAdditiveProperty(ArrayList<Integer> primes){
	boolean flag = false;
	for(int i=0 ; i<primes.size();i++){
	int j = 1;		
	while(j<primes.size()){
			
			int prime1 = primes.get(i);
			int prime2 = primes.get(j);
			int primeSum = prime1+ prime2;
		if(secret(primeSum) != (secret(prime1)+ secret(prime2) ) );
		flag= false;
		break;

		}	
	if(!flag)
	return flag;
	
	else continue;

	}
	
	return flag;

	}
	public static int secret(int prime){
		int result = prime;
		// real implementation of this method is not known.
		return  result; 
	}
	public static void main(String [] args){
		
	}

}
