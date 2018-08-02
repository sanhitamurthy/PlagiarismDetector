public class empty(){
	
//	int[] arr1 = { 1, 2, 0, 1, -1, 0, 2 };
//
//		for (int num : arr) {
//			switch (num) {
//			case 1:
//				System.out.print("One ");
//				break;
//			case 2:
//				System.out.print("Two ");
//				break;
//			case 0:
//				System.out.print("Zero ");
//				continue loop;
//			default:
//				break loop;
//			}
//			System.out.print("(" + num + ") ");
//		}
		
		String[] month={"january,february,march"};
		switch (month.toLowerCase()) {
		case "january":
		    monthNumber = 1;
		    break;
		case "february":
		    monthNumber = 2;
		    break;
		default: 
		    monthNumber = 0;
		    break;
		}
}