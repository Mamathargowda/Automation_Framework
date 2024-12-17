package Debug;

public class DebuggingEx {

	public static void main(String[] args) {
		int a =10, b=20;
		System.out.println(a);
		System.out.println(b);
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println(a);
		System.out.println(b);

	}

}
