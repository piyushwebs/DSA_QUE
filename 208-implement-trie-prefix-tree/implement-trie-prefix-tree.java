class Trie {

    HashMap<String,Integer> hm;
    public Trie() {
        hm = new HashMap<>();
    }
    
    public void insert(String word) {
        hm.put(word,hm.getOrDefault(word,0)+1);
    }
    
    public boolean search(String word) {
        return hm.containsKey(word);
    }
    
    public boolean startsWith(String prefix) {
        Set<String> st = hm.keySet();
        int n = prefix.length();
        for(String s : st)
        {
            boolean flag = true;
            if(s.length()>=n)
            {
                String sub = s.substring(0,n);
                for(int i=0;i<n;i++)
                {
                    if(sub.charAt(i) != prefix.charAt(i))
                    {
                       flag = false;
                       break;
                    }
                }
                if(flag) return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */