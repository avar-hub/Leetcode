class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        String rejex = "[A-Za-z0-9]";
        char arr[] = s.toCharArray();
        while(i <= j) {
            char ch1 = Character.toLowerCase(s.charAt(i));
            char ch2 = Character.toLowerCase(s.charAt(j));
            if(!String.valueOf(ch1).matches(rejex)) {
                i++;
                continue;
            } 
            if(!String.valueOf(ch2).matches(rejex)) {
                j--;
                continue;
            }
            if(ch1 != ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}