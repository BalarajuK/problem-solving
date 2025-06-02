package practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeating().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {

        Set<Character> map = new HashSet<>();
        int n = s.length();

        // bacabd
        int max = 0;
        for(int i=0,j=0;j<n; j++){


            while(i<j && map.contains(s.charAt(j))){
                map.remove(s.charAt(i));
                i++;
            }
            max = Math.max(max, j-i+1);
            map.add(s.charAt(j));
        }

        return max;


    }
}
