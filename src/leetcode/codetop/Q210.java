package leetcode.codetop;

import leetcode.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lrd
 * @date 2023-03-17 10:30
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，
 * 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 *
 * BFS 的总体思路：
 *
 * 建立入度表，入度为 0 的节点先入队
 * 当队列不为空，节点出队，标记学完课程数量的变量加 1，并记录该课程
 * 将课程的邻居入度减 1
 * 若邻居课程入度为 0，加入队列 用一个变量记录学完的课程数量，一个数组记录最终结果，简洁好理解。
 * DFS 的总体思路：
 *
 * 建立邻接矩阵
 * DFS 访问每一个课程，若存在环直接返回 status 保存课程的访问状态，同一个栈保存课程的访问序列。
 *
 * 作者：Kelly
 * 链接：https://leetcode.cn/problems/course-schedule-ii/solutions/221559/java-jian-dan-hao-li-jie-de-tuo-bu-pai-xu-by-kelly/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q210 {
    @Leetcode("拓扑排序 BFS")
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return new int[0];
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) { // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0)
                queue.offer(i);
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int curr = queue.poll();
            res[count++] = curr;   // 将可以学完的课程加入结果当中
            for (int[] p : prerequisites) {
                if (p[1] == curr){
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0)
                        queue.offer(p[0]);
                }
            }
        }
        if (count == numCourses)
            return res;
        return new int[0];
    }
}