package Hashing;
public class Register<K,V>{
	K key;
	V value;
	Register<K,V> next;
	public Register() {
	}
	public Register(K key, V value) {
		this.key=key;
		this.value=value;
		next = new Register<K,V>();
	}
	public K getKey() {
		return key;
	}
	public String toString() {
		return ""+key;
	}
}