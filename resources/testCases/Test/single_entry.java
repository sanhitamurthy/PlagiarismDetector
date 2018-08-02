package Tests;
/**
 * this is a dummy class for
 * testing purposes.
 * 
 * checking different types of nodes
 */
@SuppressWarnings(value = { "" })
public class single_entry {

	public static void main(String[] args) 	{
		boolean success=true;
		int[] arr4=new int[3];
		arr4={1,2,3,4};


		for(int u=0;i<arr.length;i++){
			System.out.println(arr[u]);
			if(u==1)
				continue;
			else
				break;
		}
		int i=0;
		try{
			do{

				System.out.println(arr[i]);
				++i;
			}
			while(i<2&&success);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	//interface 
	interface HelloWorld {
		public void greet();
		public void greetSomeone(String someone);
	}



	int[] arr1 = { 1, 2, 0, 1, -1, 0, 2 };
	loop:
		for (int num : arr) {
			switch (num) {
			case 1:
				System.out.print("One ");
				break;
			case 2:
				System.out.print("Two ");
				break;
			case 0:
				System.out.print("Zero ");
				continue loop;
			default:
				break loop;
			}
			System.out.print("(" + num + ") ");
		}

	Integer[] ar={1,2,3,4};
	for(Integer a:ar){
		System.out.print(a);
	}
	public enum Season { WINTER, SPRING, SUMMER, FALL }  ;

	EmptyStatement:
		;

	if(i==10)
        ;  //do nothing for i=10
    else 
        i--;

	
}
}

