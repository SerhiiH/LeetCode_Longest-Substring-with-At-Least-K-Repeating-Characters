import java.util.*;

public class Solution {
    public static int longestSubstring(String s, int k) {
        return recursiveFunction(s, k, 0, s.length());
    }

    private static int recursiveFunction(String s, int k, int begin, int end) {
        if(begin >= end)
            return 0;
        else {
            for(int a = begin; a < end; a++) {
                List<Character> charList = new ArrayList<>();
                int count = 1;
                char ch1 = s.charAt(a);
                for (int b = begin; b < end; b++) {
                    if (b == a)
                        continue;
                    char ch2 = s.charAt(b);
                    if (ch1 == ch2) {
                        if (charList.contains(ch1))
                            continue;
                        else
                            count++;
                    }
                }
                if (!charList.contains(ch1)) {
                    if (count < k) {
                        int length1 = recursiveFunction(s, k, begin, a);
                        int length2 = recursiveFunction(s, k, a + 1, end);
                        return (length1 > length2) ? length1 : length2;
                    }
                    else
                        charList.add(ch1);
                }
            }
            return end - begin;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
        System.out.println(longestSubstring("abaaavbncnb", 2));
    }
}
