public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;  // store word at end
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        
        // Build Trie
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new TrieNode();
                cur = cur.children[i];
            }
            cur.word = w; // mark end of word
        }
        
        HashSet<String> res = new HashSet<>();
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }
        
        return new ArrayList<>(res);
    }
    
    private void dfs(char[][] board, int r, int c, TrieNode node, HashSet<String> res) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;
        
        node = node.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            // to avoid duplicates, clear word
            node.word = null;
        }
        
        board[r][c] = '#'; // mark visited
        
        dfs(board, r+1, c, node, res);
        dfs(board, r-1, c, node, res);
        dfs(board, r, c+1, node, res);
        dfs(board, r, c-1, node, res);
        
        board[r][c] = ch; // restore
    }
}
