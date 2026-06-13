class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        Stack<Character> st = new Stack<>();
        char[] ch = path.toCharArray();
        int i = 0;
        while (i < n) {
            // if (!st.isEmpty()) {
            //     if (ch[i] == '/') {        
            //         if (st.peek() != '/') {
            //             st.push(ch[i]);
            //             i++;
            //         } 
            //         else
            //         {
            //             i++;
            //         }
            //     }
            //     else if (i < n && ch[i] == '.') {
            //         int c = 0;
            //         while (i<n && ch[i] != '/') {
            //             st.push(ch[i]);
            //             i++;
            //             c++;
            //         }
            //         System.out.println(c);
            //         if (c == 1) {
            //             while (st.peek() != '/') {
            //                 st.pop();
            //             }
            //         } else if (c == 2) {
            //             while (st.peek() != '/') {
            //                 st.pop();
            //             }
            //             if (st.size() != 1) {
            //                 st.pop();
            //                 while (st.peek() != '/') {
            //                     st.pop();
            //                 }
            //             }
            //         }

            //     } else if(i<n) {
            //         st.push(ch[i]);
            //         i++;
            //     }
            // } else {
            //     st.push(ch[i]);
            //     i++;
            // }

            if (i == 0) {
                st.push(ch[i]);
                i++;
            } else if (ch[i] == '/') {
                if (!st.isEmpty() && st.peek() != '/') {
                    st.push(ch[i]);
                    i++;
                }
                while (i < n && ch[i] == '/') {
                    i++;
                }
            } else {
                boolean flag = true;
                int c = 0;
                while (i < n && ch[i] != '/') {
                    st.push(ch[i]);
                    if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i]>='A' && ch[i]<='Z')) {
                        flag = false;
                    } else {
                        c++;
                    }
                    i++;
                }
                if (flag) {
                    if (c == 1) {
                        while (st.peek() != '/') {
                            st.pop();
                        }
                    } else if (c == 2) {
                        while (st.peek() != '/') {
                            st.pop();
                        }
                        if (st.size() != 1) {
                            st.pop();
                            while (st.peek() != '/') {
                                st.pop();
                            }
                        }
                    }
                }
             
            }
        }
        StringBuilder str = new StringBuilder("");
        while (st.size() != 1 && st.peek() == '/') {
            st.pop();
        }
        while (!st.isEmpty()) {
            char c = st.pop();
            str.append(c);
        }
        return str.reverse().toString();
    }
}