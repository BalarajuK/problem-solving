package practice;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        String first = strs[0];
        StringBuilder res = new StringBuilder();
        for(int i=0;i<first.length();i++){
            char ch = first.charAt(i);
            if(!hasMatch(strs, i, ch)){
                break;
            }
            res.append(ch);
        }

        return res.toString();

    }

    private boolean hasMatch(String[] strs, int i, char ch){

        for (String str : strs) {
            if (i >= str.length() || str.charAt(i) != ch) {
                return false;
            }
        }
        return true;
    }
}
