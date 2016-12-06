package InterfaceTest;

interface Output{
	int MAX_CACHE_LINE = 50;
	void out();
	void getData(String msg);
	default void print(String... msgs){
		for (String msg : msgs){
			System.out.println(msg);
		}
	}
	default void test(){
		System.out.println("Default test() method");
	}
	static String staticTest(){
		return "static method in interface output";
	}
}

interface Product{
	int getProduceTime();
}

public class Printer implements Output, Product{
	private String[] printData
		= new String[MAX_CACHE_LINE];
	private int dataNum = 0;
	public void out(){
		while(dataNum>0){
			System.out.println("Printer is printing: "+printData[0]);
			System.arraycopy(printData,1,printData,0,--dataNum);
		}
	}
	public void getData(String msg){
		if(dataNum>=MAX_CACHE_LINE){
			System.out.println("cache line is full, getting data fail");
		}else{
			printData[dataNum++] = msg;
		}
	}
	public int getProduceTime(){
		return 45;
	}
	public static void main(String[] args){
		Output o = new Printer();
		o.getData("COD1");
		o.getData("COD2");
		o.out();
		o.getData("COD3");
		o.getData("COD4");
		o.out();
		o.print("bf1","bf2","bf3");
		o.test();
		Product p = new Printer();
		System.out.println(p.getProduceTime());
		Object obj = p;
	}
}