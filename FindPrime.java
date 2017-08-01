ArrayList<Integer> FindPrime(int n){
    ArrayList<Integer> result = new ArrayList<>();

	if(n <= 1) return null;
	result.add(2);
	if(n == 2){
		
		return result;
}

	for(int i = 3;i <= n; i += 2 ){
		if(isPrime(List<Integer> result, int i)){
			result.add(i);



}
	return result;



}


public boolean isPrime(List<Integer> result, int i){
	boolean flag = true;

	for(Integer item : result){
		if(i%item == 0){
			flag == flase;
			return flag;
} 
	return flag;

}