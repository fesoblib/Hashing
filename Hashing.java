package Hashing;

import java.util.Scanner;

public class Hashing {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("--Clave Integer--");
		HashTable<Integer,Integer> hash1= new HashTable<Integer, Integer>(10);// Tamaño del Hash
		hash1.put(6, 24);
		hash1.put(21, 98);
		hash1.put(16, 42);
		hash1.put(19, 55);
		hash1.put(26,34);
		hash1.put(54, 33);
		hash1.put(31, 63);
		hash1.put(37, 62);
		hash1.put(40, 90);
		hash1.show();
		System.out.println("\n--Clave String--");
		HashTable<String,Integer> hash2= new HashTable<String,Integer>(5);// Tamaño del Hash
		hash2.put("frederic", 53);
		hash2.put("benigno", 12);
		hash2.put("edgard", 42);
		hash2.put("arnold", 29);
		hash2.put("gabriel", 12);
		hash2.put("luis", 23);
		hash2.put("angela", 82);
		hash2.put("francisco", 30);
		hash2.put("fernando", 11);
		hash2.show();
	}
}