package Hashing;

import java.util.ArrayList;

public class HashTable<K extends Comparable<K>, V extends Comparable<V>> {
	ArrayList<Register<K, V>> table = new ArrayList<Register<K, V>>(); // Arreglo para objetos Genéricos
	Register<K, V> obj; // Registro auxiliar para trabajar con la Función Hash
	int size; // Tamaño de la tabla hash

	public HashTable(int size) {
		this.size = size;
		for (int i = 0; i < size; i++) {
			table.add(i, new Register<K, V>());
		}
	}

	// Función Hash
	public int Module(Register<K, V> register) {
		int num;
		if (isInteger(register.key)) {
			num = Integer.valueOf(register.toString());// Casteo a entero
			return num % size;
		} else if (isString(register.key)) {
			String cadena = (String) register.key;// Casteo a String
			num = (int) (cadena.charAt(0)) * (int) (cadena.codePointAt(1));// Multiplicamos el código ASCII de las 2
																			// primeras letras
			cadena = String.valueOf(num); // Casteamos la multiplicación a String
			num = Integer.parseInt(cadena.substring(cadena.length() - 3, cadena.length()));// Obtenemos los 3 ultimos
																							// digitos de la
																							// multiplicación
			return num % size;
		} else
			return -1;
	}

	public void put(K key, V value) {
		obj = new Register<K, V>(key, value); // Creamos el Registro que ingresaremos
		if (table.get(Module(obj)).key == null) { // Si el index "i" de la tabla está vacio
			table.set(Module(obj), obj); // Agregamos el Registro a la lista en el lugar n%m
		} else {
			emptyRegister(table.get(Module(obj)));
		}
	}

	// Encadenamiento en caso de colisión
	public void emptyRegister(Register<K, V> register) {
		if (register.next.key == null)
			register.next = obj;
		else
			emptyRegister(register.next);
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			obj = table.get(i);
			System.out.print(i + " --> ");
			for (; obj.value != null;) {
				System.out.print(obj.value + " ");
				obj = obj.next;
			}
			System.out.println();
		}
	}

	// Verifica si la llave es un Entero
	public boolean isInteger(K key) {
		return key.getClass().getName().equals("java.lang.Integer");
	}

	// Verifica si la llave es un String
	public boolean isString(K key) {
		return key.getClass().getName().equals("java.lang.String");
	}
}
