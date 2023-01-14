package dailyWorkshop07;

public class Test03 {
	public static void main(String[] args) {
		String str = "I am second to none";
		
		String aa = str.trim();

		char[] arr = aa.toCharArray();
		
		int cnt = 0;
		
		for(int i =0;i<arr.length; i++) {
			if(arr[i] == ' ') {
				cnt += 1;
			}
		}

		int answer = arr.length - cnt;
		
		System.out.println("문자수 : "+answer);

		System.out.println("단어의 갯수 : " + (cnt+1));
		
		
	}
}
