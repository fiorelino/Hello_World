package de.de.scrum_master.math;

public class Prime {
	/**
	 * Determines if a given number is a prime
	 *
	 * @param number a positive integer number
	 * @return true if the number is prime, false otherwise
	 * @throws IllegalArgumentException if number <= 0
	 */
	public static boolean isPrime(int number) {
		if (number <= 0) throw new IllegalArgumentException("number must be positive");
		if (number == 1) return false;
		if (number == 2) return true;
		if (number % 2 == 0) return false;
		int squareRoot = (int) Math.sqrt(number);
		for (int i = 3; i <= squareRoot; i += 2)
			if (number % i == 0) return false;
		return true;
	}

	public static void main(String[] args) {
		final int PRIMES_PER_LINE = 15;
		int primeCount = 0;
		for (int i = 2; i < 1000; i++) {
			if (isPrime(i)) {
				System.out.printf("%10d", i);
				if (++primeCount % PRIMES_PER_LINE == 0)
					System.out.printf("%n");
			}
		}
	}
}
