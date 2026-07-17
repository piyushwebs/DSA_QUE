class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        String ans = "";

        HashMap<Character,Integer> hmt = new HashMap<>();
        HashMap<Character,Integer> hms = new HashMap<>();

        for (int i = 0; i < m; i++) {
            hmt.put(t.charAt(i), hmt.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int required = hmt.size();
        int formed = 0;

        while (right < n) {
            char c = s.charAt(right);

            if (hmt.containsKey(c)) {
                hms.put(c, hms.getOrDefault(c, 0) + 1);
                if (hms.get(c).intValue() == hmt.get(c).intValue()) {
                    formed++;
                }
            }

            while (left <= right && formed == required) {
                if (ans.isEmpty() || (right - left + 1) < ans.length()) {
                    ans = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                if (hmt.containsKey(leftChar)) {
                    hms.put(leftChar, hms.get(leftChar) - 1);
                    if (hms.get(leftChar) < hmt.get(leftChar)) {
                        formed--;
                    }
                }
                left++;
            }

            right++;
        }

        return ans;
    }
}