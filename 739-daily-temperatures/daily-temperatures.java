class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] arr = new int[n];

        Stack<Integer> st = new Stack<>();
        
        int i = n-1;
        while(i>=0)
        {
           if(st.isEmpty())
           {
            arr[i] = 0;
            st.push(i);
            i--;
           }
           while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()])
           {
            st.pop();
           }
           if(st.isEmpty())
           {
            arr[i] = 0;
            st.push(i);
            i--;
           }
           else
           {
            arr[i] = st.peek() - i;
            st.push(i);
            i--;
           }
        }

        return arr;
    }
}