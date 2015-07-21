package PrimeFactors;

public class Prime {
	public boolean isPrime(long n) {
		if (n % 2 == 0) //소인수 확인 위해 
			return false;

		long half = (n / 2) % 2 == 0 ? (n / 2) - 1 : n / 2; 
		
		for (int i = 3; i < half; i += 2) // 
		{
			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Prime p = new Prime();

		long t = 600851475143L; // -> 600251475143의 가장큰소인수는 600251475143의 제곱근보다 작다....
		long d = 2;
		while (1 == 1) { // 이 반복문...흡....어렵다.....
			long tmp = 600851475143L / d;
			if (t % tmp == 0 && p.isPrime(tmp)) {
				System.out.println("= " + tmp);
				break;
			}
			d++;
		}
	}
}
