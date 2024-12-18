// class Solution {
//     List<List<String>> res;
//     Map<Integer, Set<String>> map;
//     Set<String> set;
//     int goal;
//     String es;
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         res = new LinkedList<>();
//         set = new HashSet<>(wordList);
//         es = endWord;
//         if(!set.contains(endWord)) return(res);
//         int step = 0;
//         Queue<String> q = new LinkedList<>();
//         q.offer(beginWord);
//         Set<String> seen = new HashSet<>();
//         seen.add(beginWord);
//         map = new HashMap<>();
//         boolean found = false;
//         while(!q.isEmpty()){
//             int sz = q.size();
//             map.put(step, new HashSet<>());
//             while(sz-- > 0){
//                 String cs = q.poll();
//                 map.get(step).add(cs);
//                 if(cs.equals(endWord)){
//                     found = true;
//                     break;
//                 }
//                 Set<String> nbrs = nb(cs, set, seen);
//                 for(String ns: nbrs){
//                     q.offer(ns);
//                 }
//             }
//             if(found) break;
//             step++;
//         }
//         if(!found) return(res);
//         //System.out.println(step);
//         //System.out.println(map);
//         goal = step;
//         List<String> list = new LinkedList<>();
//         list.add(es);
//         dfs(es, goal, list);
//         return(res);
//     }
    
//     public void dfs(String s, int level, List<String> list){
//         if(level == 0){
//             List<String> copy = new LinkedList<>(list);
//             Collections.reverse(copy);
//             res.add(copy);
//             return;
//         }
//         Set<String> nbrs = new HashSet<>();
//         for(String nss: map.get(level - 1)){
//             if(isnb(nss, s)) nbrs.add(nss);
//         }
//         for(String ns: nbrs){
//             list.add(ns);
//             dfs(ns, level - 1, list);
//             list.remove(list.size() - 1);
//         }
//     }
//     public boolean isnb(String s1, String s2){
//         int n = s1.length();
//         int d = 0;
//         for(int i = 0; i < n; i++){
//             if(s1.charAt(i) != s2.charAt(i)) d++;
//         }
//         return(d == 1);
//     }
//     public Set<String> nnb(String s, Set<String> set, int dep){
//         Set<String> res = new HashSet<>();
//         int n = s.length();
//         for(int i = 0; i < n; i++){
//             int chi = s.charAt(i) - 'a';
//             for(int j = 0; j < 26; j++){
//                 if(j == chi) continue;
//                 String ns = s.substring(0, i) + (char)('a' + j) + s.substring(i + 1);
//             }
//         }
//         return(res);
//     }
//     public Set<String> nb(String s, Set<String> set, Set<String> seen){
//         Set<String> res = new HashSet<>();
//         int n = s.length();
//         for(int i = 0; i < n; i++){
//             int chi = s.charAt(i) - 'a';
//             for(int j = 0; j < 26; j++){
//                 if(j == chi) continue;
//                 String ns = s.substring(0, i) + (char)('a' + j) + s.substring(i + 1);
//                 if(set.contains(ns) && seen.add(ns)) res.add(ns);
                
//             }
//         }
//         return(res);
//     }
// }
import java.util.*;
class Solution {
 public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return new AbstractList<List<String>>() {

            private List<List<String>> resList;

            private void onload() {
                resList = new ArrayList<>();
                Set<String> wordSet = new HashSet<>(wordList);
                if (!wordSet.contains(endWord)) {
                    return;
                }
                Map<String, Set<String>> map = new HashMap<>();
                boolean flag = false;
                Set<String> currLevel = new HashSet<>();
                currLevel.add(beginWord);
                while (!currLevel.isEmpty() && !flag) {
                    wordSet.removeAll(currLevel);
                    Set<String> nextLevel = new HashSet<>();
                    for (String currWord : currLevel) {
                        for (String nextWord : generate(currWord, wordSet)) {
                            if (nextWord.equals(endWord)) {
                                flag = true;
                            }
                            map.putIfAbsent(nextWord, new HashSet<>());
                            map.get(nextWord).add(currWord);
                            nextLevel.add(nextWord);
                        }
                    }
                    currLevel = nextLevel;
                }
                if (flag) {
                    helper(endWord, map, new ArrayList<>());
                }
                return;
            }

            private List<String> generate(String currWord, Set<String> wordSet) {
                List<String> arr = new ArrayList<>();
                char[] chArr = currWord.toCharArray();
                for (int i = 0; i < chArr.length; i++) {
                    char old = chArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) {
                            continue;
                        }
                        chArr[i] = ch;
                        String nextWord = new String(chArr);
                        if (wordSet.contains(nextWord)) {
                            arr.add(nextWord);;
                        }
                    }
                    chArr[i] = old;
                }
                return arr;
            }

            private void helper(String currWord, Map<String, Set<String>> map, List<String> path) {
                path.add(currWord);
                if (currWord.equals(beginWord)) {
                    resList.add(new ArrayList<>(path).reversed());
                    path.remove(path.size() - 1);
                    return;
                }
                for (String prevWord : map.get(currWord)) {
                    helper(prevWord, map, path);
                }

                path.remove(path.size() - 1);
            }

            private void init() {
                if (null == resList) {
                    onload();
                    System.gc();
                }
            }

            @Override
            public List<String> get(int index) {
                init();
                return resList.get(index);
            }

            @Override
            public int size() {
                init();
                return resList.size();
            }

        };
    }
}

class xSolution {

    Map<String, List<String>> neighbors = new HashMap<>();
    List<List<String>> ladders = new ArrayList<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for (String word: wordList) {
            wordSet.add(word);
        }
        queue.add(beginWord);
        wordSet.remove(beginWord);
        int minLen = Integer.MAX_VALUE, currLen = 1;
        Set<String> needRemove = new HashSet<>();
        while (!queue.isEmpty()) {
            if (currLen > minLen) {
                break;
            }
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    minLen = currLen;
                }
                char[] chs = word.toCharArray();
                for (int i = 0; i < word.length(); ++i) {
                    char prev = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c != prev) {
                            chs[i] = c;
                            String newWord = String.valueOf(chs);
                            if (wordSet.contains(newWord)) {
                                neighbors.computeIfAbsent(newWord, l -> new ArrayList<>()).add(word);
                                if (!needRemove.contains(newWord)) {
                                    queue.add(newWord);
                                    needRemove.add(newWord);
                                }
                            }
                            chs[i] = prev;
                        }
                    }
                }
            }
            for (String word: needRemove) {
                wordSet.remove(word);
            }
            ++currLen;
        }
        findPaths(endWord, beginWord, new LinkedList<>(Arrays.asList(endWord)));
        return ladders;
    }

    private void findPaths(String word, String start, LinkedList<String> path) {
        if (word.equals(start)) {
            ladders.add(new ArrayList<>(path));
            return;
        }
        for (String prevWord: neighbors.getOrDefault(word, new ArrayList<>())) {
            path.addFirst(prevWord);
            findPaths(prevWord, start, path);
            path.removeFirst();
        }
    }
}

class SolutionMy {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            var unvisited = new HashSet<>(wordList);
            unvisited.remove(beginWord);
            var adjList = buildAdjList(beginWord, endWord, unvisited);
            if (adjList == null) return Collections.emptyList();
            bt(adjList, endWord, new ArrayList<>(List.of(beginWord)));
            return paths;
        }

        List<List<String>> paths = new ArrayList<>();
        void bt(Map<String, Set<String>> adjList, String endWord, List<String> path) {
            //base case
            if (path.getLast().equals(endWord)) {
                paths.add(new ArrayList<>(path)); // copy because we keep using path
            }
            else {
                var neighbors = adjList.get(path.getLast());
                if (neighbors == null) return;
                for (var n : neighbors) {
                    //choose
                    path.add(n);
                    //explore
                    bt(adjList, endWord, path);
                    //unchoose
                    path.removeLast();
                }
            }
        }

        public List<Set<String>> mine = new ArrayList<>(); // remove
        // returns adj list if end to end path discovered
        public Map<String, Set<String>> buildAdjList(String beginWord, String endWord, Set<String> unvisited) {
            boolean hasPath = false;
            Map<String, Set<String>> adjList = new HashMap<>();
            var q = new ArrayDeque<String>();
            q.add(beginWord);
            while (!q.isEmpty()) {
                if (hasPath) break;
                var sz = q.size();
                var levelAdjs = new HashSet<String>();
                for (int i = 0; i < sz; i++) {
                    var w = q.remove();
                    var adj = getAdjacent(w, unvisited);
                    adjList.put(w, adj);
                    if (adj.contains(endWord))
                        hasPath = true;
                    q.addAll(adj);
                    levelAdjs.addAll(adj);
                }
                unvisited.removeAll(levelAdjs); // prune adjs found at this level
                mine.add(levelAdjs); //remove
            }
            return hasPath ? adjList : null;
        }

        public Set<String> getAdjacent(String w, Set<String> unvisited) {
            var res = new HashSet<String>();
            for (int i = 0; i < w.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == w.charAt(i)) continue;  // very important
                    var neigh = w.substring(0, i) + c + w.substring(i + 1);
                    if (unvisited.contains(neigh)) res.add(neigh);
                }
            }
            return res;
        }

    }


class SolutionAnother {

    private int L;
    private boolean hasPath;

    // https://leetcode.com/problems/word-ladder-ii/solutions/5743986/java-solution-beats-98-with-intuition
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.L = beginWord.length();
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord))
            return new ArrayList<>();

        // BFS
        // build a directed graph G with beginWord being the root
        // we guarantee in G, for all nodes, the dis from beginWord is the shortest
        Map<String, List<String>> adjList = new HashMap<String, List<String>>();
        wordSet.remove(beginWord); // beginWord in wordList is useless
        buildAdjList(beginWord, endWord, wordSet, adjList);
        if (this.hasPath == false)
            return new ArrayList<>();

        // DFS
        // get all paths from beginWord to endWord, knowing that all paths have the same
        // shortest length
        // implement a cache to save branches that have already been visited
        return backtrack(adjList, beginWord, endWord, new HashMap<>());
    }

    public List<List<String>> backtrack(
            Map<String, List<String>> adjList,
            String currWord,
            String endWord,
            Map<String, List<List<String>>> cache) {
        if (cache.containsKey(currWord))
            return cache.get(currWord);
        List<List<String>> result = new ArrayList<>();
        if (currWord.equals(endWord)) {
            result.add(new ArrayList<>(Arrays.asList(currWord)));
        } else {
            List<String> neighbors = adjList.getOrDefault(currWord, new ArrayList<>());
            for (String neighbor : neighbors) {
                List<List<String>> paths = backtrack(adjList, neighbor, endWord, cache);
                for (List<String> path : paths) {
                    List<String> copy = new ArrayList<>(path);
                    copy.add(0, currWord);
                    result.add(copy);
                }
            }
        }
        cache.put(currWord, result);
        return result;
    }

    public void buildAdjList(String beginWord, String endWord, Set<String> unvisitedWords,
            Map<String, List<String>> adjList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while (!q.isEmpty()) {
            if (this.hasPath)
                break;
            int size = q.size();
            Set<String> nextLevelWords = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();
                List<String> nextLevelNeighbors = getNextLevelNeighbors(currWord, unvisitedWords, adjList);
                // System.out.println(currWord+" neighbors: " + nextLevelNeighbors);
                for (String nextLevelNeighbor : nextLevelNeighbors) {
                    if (!nextLevelWords.contains(nextLevelNeighbor)) {
                        if (nextLevelNeighbor.equals(endWord))
                            this.hasPath = true;
                        nextLevelWords.add(nextLevelNeighbor);
                        q.add(nextLevelNeighbor);
                    }
                }
            }
            // only after adding all edges to next level
            // can we remove next level nodes
            for (String w : nextLevelWords) {
                unvisitedWords.remove(w);
            }
        }
    }

    public List<String> getNextLevelNeighbors(String word, Set<String> unvisitedWords,
            Map<String, List<String>> adjList) {
        // for every char -- K *
        // replace it with 26 letters -- 26 *
        // check if it exists in wordSet -- O(1)
        List<String> neighbors = new ArrayList<>();
        char[] wordSeq = word.toCharArray();
        for (int i = 0; i < this.L; i++) {
            char oldC = wordSeq[i];
            for (int j = 0; j < 26; j++) {
                char newC = (char) ('a' + j);
                if (newC == oldC)
                    continue;
                wordSeq[i] = newC;
                String newWord = new String(wordSeq);
                if (unvisitedWords.contains(newWord)) {
                    neighbors.add(newWord);
                }
                wordSeq[i] = oldC;
            }
        }
        adjList.put(word, neighbors);
        return neighbors;
    }

    // from https://leetcode.com/problems/word-ladder-ii/editorial/comments/1189577
    public List<List<String>> findLaddersX(String beginWord, String endWord, List<String> wordList) {
        // Adjacency list
        Map<String, List<String>> adj = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "#" + word.substring(i + 1);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // Parents dictionary
        Map<String, Set<String>> parents = new HashMap<>();
        // BFS queue with word and distance
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 0));
        // Seen map for minimum distance
        Map<String, Integer> seen = new HashMap<>();
        seen.put(beginWord, 0);
        // Minimum distance to get to the endWord
        int minDist = Integer.MAX_VALUE;

        // BFS
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int dist = current.dist;

            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "#" + word.substring(i + 1);
                if (!adj.containsKey(pattern))
                    continue;

                for (String neighbor : adj.get(pattern)) {
                    if (!seen.containsKey(neighbor) || seen.get(neighbor) == dist + 1 && dist + 1 <= minDist) {
                        if (neighbor.equals(endWord))
                            minDist = dist + 1;
                        parents.computeIfAbsent(neighbor, k -> new HashSet<>()).add(word);
                        if (!seen.containsKey(neighbor)) {
                            seen.put(neighbor, dist + 1);
                            queue.offer(new Pair(neighbor, dist + 1));
                        }
                    }
                }
            }
        }

        // Results list
        List<List<String>> answers = new ArrayList<>();
        // Helper function to build sequences
        buildSequences(endWord, beginWord, new LinkedList<>(), parents, answers);
        return answers;
    }

    private void buildSequences(String word, String beginWord, LinkedList<String> sequence,
            Map<String, Set<String>> parents, List<List<String>> answers) {
        sequence.addFirst(word);
        if (word.equals(beginWord)) {
            answers.add(new ArrayList<>(sequence));
        } else if (parents.containsKey(word)) {
            for (String parent : parents.get(word)) {
                buildSequences(parent, beginWord, sequence, parents, answers);
            }
        }
        sequence.removeFirst();
    }

    // Helper class to store word and distance
    private static class Pair {
        String word;
        int dist;

        Pair(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
}