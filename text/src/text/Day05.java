package text;

class Day05{
	

	public static void main(String[] args) {
		String str = "abc123!@#";
        String regex1 = "[\\w!@#]+";
        String regex4 = "[a-z0-9!@#]+";
        String regex2 = "[\\w]+";
        String regex5= "/d{1,6}-/d*";
        String regex6= "\\d{1,6}-\\d*";
        System.out.println(str.matches(regex1)); //true
        System.out.println(str.matches(regex2)); //false
        System.out.println(str.matches(regex4));//false
        System.out.println(str.matches(regex5));//false
        System.out.println(str.matches(regex6));//false
	}

}
