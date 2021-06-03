package DFSandBFS;

import java.util.*;

/**
 * @author s1mple
 * @create 2021/6/3-21:18
 */
public class LadderLengthDemo {
    /**
     *  解法: 一圈一圈往外扩散
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //把字典中的单词放入到set中,主要是为了方便查询
        Set<String> dictSet = new HashSet<>(wordList);
        //创建一个新的单词,记录单词是否被访问到,如果没有被访问过就加入进来
        Set<String> visit = new HashSet<>();
        //BFS中常见的队列,我们可以把他想象成为一颗二叉树,记录每一层的节点
        //或者把他想象成一个图,记录挨着的节点,也就是没一圈的节点.这里我们把他想象成为一个图
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        //这里的图是一圈一圈往外扩散的,这里的minlen可以看做扩散了多少圈
        //也就是最短的转换序列长度
        int minlen = 1;
        while (!queue.isEmpty()) {
            //这里找出每个节点周围的节点数量,然后都遍历他们
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                //出队
                String word = queue.poll();
                //这里遍历每一个节点的单词.然后修改其中一个字符,让他成为一个新的单词
                //并查看这个新的单词在字典中是否存在,如果存在并且没有被访问过,就加入到队列中
                for (int j = 0; j < word.length(); j++) {
                    char[] ch = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(j)) {
                            continue;
                        }
                        ch[j] = c;
                        //修改其中的一个字符,然后重新构建一个新的单词
                        String newWord = String.valueOf(ch);
                        //查看字典中有没有这个单词,如果有并且没有被访问过,就加入到队列中
                        //(Set的add方法表示吧单词加入到队列中,如果set中没有这个单词
                        //就会添加成功,返回true,如果有这个单词,就会添加失败,返回false
                        if (dictSet.contains(newWord) && visit.add(newWord)) {
                            //如果新单词是endWord就返回,这里访问的是第minlen圈的节点,然后
                            //创建的节点就是第minlen+1层
                            if (newWord.equals(endWord)) {
                                return minlen + 1;
                            }
                            queue.add(newWord);
                        }
                    }
                }
            }
            //每往外扩一圈,长度就加1
            minlen++;
        }
        return 0;
    }
}
