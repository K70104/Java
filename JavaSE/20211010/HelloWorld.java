
class Test {

}

/**
 * 文档注释 --> 类或方法的前面
 */


public class HelloWorld {

	public static void main(String[] args) {
		short s = 10; // 2字节
		// -2^16 - 2^16-1
	}

	public static void main6(String[] args) {
		byte b1 = 10; // 1字节 相当于C中的char
		System.out.println(b1); // 10

		//byte b2 = 130; // err
		//System.out.println(b2); // 错误: 不兼容的类型: 从int转换到byte可能会有损失
		
		byte b3 = 127; // ok
	}

	public static void main5(String[] args) {
		char ch1 = 'a';
		System.out.println(ch1); // a

		char ch2 = '数';
		System.out.println(ch2); // 数
	}

	public static void main4(String[] args) {
		// float f = 10.5;
		// System.out.println(f);
		// 错误: 不兼容的类型: 从double转换到float可能会有损失
	}

	public static void main3(String[] args) {
		// int d = 1.0;
		// System.out.println(a*a);

		double num = 1.1;
		System.out.println(num*num); // 1.2100000000000002
	}

	public static void main2(String[] args) {
		long a = 10L;
		System.out.println(Long.MAX_VALUE); // 9223372036854775807
		System.out.println(Long.MIN_VALUE); // -9223372036854775808
	}


	/**
	 * int 4字节
	 * @param args [description]
	 */
	public static void main1(String[] args) {
		int a = 10;
		System.out.println(a); // 10

		System.out.println(Integer.MAX_VALUE); // 2147483647
		System.out.println(Integer.MIN_VALUE); // -2147483648

		int maxMax = 10;
		int max_num = 10;
		int $max3num = 10;

		int ___________ = 100; // 可以，但不要用
		System.out.println(___________); // 100

		int 钱 = 300;
		System.out.println(钱); // 300

		// int num; // err
		// System.out.println(num);
	}

	public static void func(String[] args) {
		for(int i = 0; i< args.length; i++) {
			// System.out.println(args[i]); 行注释
			
			/*
			System.out.println(args[0]);
			System.out.println(args[1]);
			System.out.println(args[2]);
			System.out.println(args[3]);
			*/
		}
		
		System.out.print("打印不换行");
		System.out.println("打印换行");
		System.out.printf("%d\n", 10);
		
		System.out.println("hello");
	}
}