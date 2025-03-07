class Solution {
    public String intToRoman(int num) {
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] s = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < nums.length; i++) {

            if(num == 0)
                break;

                
            int times = num / nums[i];

            while(times-- > 0) {
                sb.append(s[i]);
            } 

            num %= nums[i];
        }
        return sb.toString();
    }
}