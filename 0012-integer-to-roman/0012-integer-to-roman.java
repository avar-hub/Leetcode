class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        String str = String.valueOf(num);
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            int pos = ch.length - i; 
            int n = Character.getNumericValue(ch[i]);
            if (pos == 4) { 
                for (int j = 0; j < n; j++) {
                    ans.append("M");
                }
            } else if (pos == 3) {
                int value = n * 100;
                if (map.containsKey(value)) {
                    ans.append(map.get(value));
                } else {
                    if (n < 5) {
                        for (int j = 0; j < n; j++) {
                            ans.append("C");
                        }
                    } else {
                        ans.append("D");
                        for (int j = 0; j < n - 5; j++) {
                            ans.append("C");
                        }
                    }
                }
            } else if (pos == 2) { 
                int value = n * 10;
                if (map.containsKey(value)) {
                    ans.append(map.get(value));
                } else {
                    if (n < 5) {
                        for (int j = 0; j < n; j++) {
                            ans.append("X");
                        }
                    } else {
                        ans.append("L");
                        for (int j = 0; j < n - 5; j++) {
                            ans.append("X");
                        }
                    }
                }
            } else { 
                int value = n;
                if (map.containsKey(value)) {
                    ans.append(map.get(value));
                } else {
                    if (n < 5) {
                        for (int j = 0; j < n; j++) {
                            ans.append("I");
                        }
                    } else {
                        ans.append("V");
                        for (int j = 0; j < n - 5; j++) {
                            ans.append("I");
                        }
                    }
                }
            }
        }
        return ans.toString();
    }
}
