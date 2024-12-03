class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int pointer = 0;
        if(spaces.length == 0)
            return s;
        for(int i = 0; i < arr.length; i++) {
            if(pointer < spaces.length && spaces[pointer] == i) {
                sb.append(" ");
                pointer++;
                i--;
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}