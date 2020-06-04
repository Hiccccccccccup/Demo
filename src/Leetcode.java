import java.math.BigDecimal;
import java.util.*;

public class Leetcode {


    public static void main(String[] args) throws InterruptedException {
//        ListNode<Integer> node5 = new ListNode<>(5);
//        ListNode<Integer> node4 = new ListNode<>(4,node5);
//        ListNode<Integer> node3 = new ListNode<>(3,node4);
//        List<Integer> res = new ArrayList<>();
//        printNode(res,node3);
//        System.out.println(res);

//        String a_b = replace("A B");
//        System.out.println(a_b);

//        int i = NumberOf1(4);
//        System.out.println(i);

//        double power = Power(12.34, 3);
//        System.out.println(power);

//        int[] ints = {1,2,3,4,5,6,7,8};
//        moveOddFront(ints);
//        moveOddFrontWithOrder1(ints);

//        ListNode<Integer> node5 = new ListNode<>(5);
//        ListNode<Integer> node4 = new ListNode<>(4,node5);
//        ListNode<Integer> node3 = new ListNode<>(3,node4);
//        ListNode<Integer> node2 = new ListNode<>(2,node3);
//        remove(node2,node3);


//        ListNode<Integer> node5 = new ListNode<>(5);
//        ListNode<Integer> node4 = new ListNode<>(4,node5);
//        ListNode<Integer> node3 = new ListNode<>(3,node4);
//        ListNode<Integer> node2 = new ListNode<>(2,node3);
//        ListNode newHead = reverseList1(node2);
//        System.out.println("sdfsd");

//        int[] s = {3, 32, 321};
//        String s1 = PrintMinNumber(s);
//        System.out.println(s1);
//        System.out.println("321".compareTo("32"));

//        sendRandomBonus(new BigDecimal("0.10"),5);

//        int[] push = {1,2,3,4,5};
//        int[] pop = {4,5,3,2,1};
//        boolean b = IsPopOrder(push, pop);
//        System.out.println(b);


        TreeNode<Integer> n4 = new TreeNode<Integer>(4);
        TreeNode<Integer> n5 = new TreeNode<Integer>(5);
        TreeNode<Integer> n6 = new TreeNode<Integer>(6);
        TreeNode<Integer> n7 = new TreeNode<Integer>(7);
        TreeNode<Integer> n2 = new TreeNode<Integer>(2, n4, n5);
        TreeNode<Integer> n3 = new TreeNode<Integer>(3, n6, n7);
        TreeNode<Integer> n1 = new TreeNode<Integer>(1, n2, n3);
//        List<Integer> integers = PrintFromTopToBottom(n1);
//        ArrayList<ArrayList<Integer>> integers = PrintFromTopToBottomAsRows(n1);
//        ArrayList<ArrayList<Integer>> integers = PrintFromTopToBottomAsZ(n1);

//        String serialize = Serialize(n1);
//        System.out.println(serialize);

//        int[] s = {1,2,3,1,1,4,3,3,2,3};
//        int i = MoreThanHalfNum_Solution(s);
//        System.out.println(i);

//        int[] s = {1,2,3,1,5,4,3,9,2,3};
//        topK(s,3);
//        System.out.println(s);

//        String example_good_a = reverseWords1("a good   example");
//        System.out.println(example_good_a);

//        int[] s = {1,3,-1,-3,5,3,6,7};
//        int[] ints = maxSlidingWindow(s, 3);
//        System.out.println(ints);

//        for (int j = 0; j < 12; j++) {
//            int i = randomeLevel();
//            System.out.println(i);
//            Thread.sleep(500);
//        }


        int i = strToInt("-132456");
        System.out.println(i);

    }


    public TreeNode lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }


    public static int strToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        boolean isNagative = s.charAt(0) == '+';
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                return 0;
            }
            ret = ret * 10 + (c - '0');
        }
        return isNagative ? ret : -ret;
    }


    /**
     * 跳表索引层级随机算法
     *
     * @return
     */
    public static int randomeLevel() {
        int max = 5;
        Double SKIPLIST_P = 0.5;
        int level = 1;
        while (level < max && Math.random() < SKIPLIST_P) {
            level++;
        }
        return level;
    }


    /**
     * 61. 扑克牌顺子
     *
     * @param nums
     * @return
     */
    public boolean isContinuous(int[] nums) {
        if (nums.length < 5) {
            return false;
        }

        //计算癞子数量
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt++;
            }
        }
        //排序
        Arrays.sort(nums);

        //
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
            //两张牌之间需要的癞子数量
            int gap = nums[i + 1] - nums[i] - 1;
            cnt -= gap;
        }
        return cnt >= 0;

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[nums.length];
        }

        int[] ints = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

        for (int i = 0, j = 0; i < k - 1; i++, j++) {
            queue.offer(nums[i]);
        }

        for (int j = k - 1, m = 0; j < nums.length; j++, m++) {
            queue.offer(nums[j]);
            ints[m] = queue.peek();
            queue.remove(nums[m]);
        }
        return ints;
    }


    /**
     * 空间复杂度为O(1)
     * 思路:先分别翻转每个单词,再翻转整个字符串
     *
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        if (s.trim().length() == 0) {
            return "";
        }
        ;
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        while (j <= s.length()) {
            if (j == s.length() || s.charAt(j) == ' ') {
                //先分别翻转每个单词
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        //再翻转整个字符串
        reverse(chars, 0, chars.length - 1);
        //去除多余空格
        for (int k = 0; k < chars.length - 1; k++) {
            if (chars[k] == ' ' && chars[k + 1] == ' ') {
                System.arraycopy(chars, 0, chars, 1, k + 1);
                chars[0] = ' ';
            }
        }
        return new String(chars).trim();
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static String reverseWords(String s) {
        String[] sp = s.trim().split(" ");

        StringBuilder builder = new StringBuilder("");
        for (int k = sp.length - 1; k >= 0; k--) {
            if ("".equals(sp[k])) {
                continue;
            }
            builder.append(sp[k]);
            if (k != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }


    /**
     * 55.2 平衡二叉树(平衡二叉树左右子树高度差不超过1)
     */
    private static boolean isBalanced;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private static int height(TreeNode node) {
        if (node == null || !isBalanced) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }


    /**
     * 54. 二叉查找树的第 K 个结点
     * 思路:中序遍历
     */
    private static TreeNode ret;
    private static int cnt = 0;

    public static TreeNode KthNode(TreeNode node, int k) {
        inOrder(node, k);
        return ret;
    }

    private static void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            ret = node;
            return;
        }
        inOrder(node.right, k);
    }


    /**
     * 二叉树高度
     *
     * @param node
     * @return
     */
    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return Math.max(left, right) + 1;
    }

    /**
     * TOPK问题
     * 思路: partition思想
     *
     * @param nums
     * @param k
     */
    public static void topK(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        if (nums == null) {
            return;
        }
        int index = 0;
        while (index != k - 1) {
            index = partition(nums, low, high);
            if (index < k - 1) {
                low = index + 1;
            } else if (index > k - 1) {
                high = index - 1;
            }
        }
    }

    /**
     * partition函数
     * 单边循环法
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] nums, int start, int end) {
        int mark = start;
        int privo = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < privo) {
                mark++;
                swap(nums, mark, i);
            }
        }
        swap(nums, mark, 0);
        return mark;
    }


    /**
     * 39. 数组中出现次数超过一半的数字
     *
     * @param nums
     * @return
     */
    public static int MoreThanHalfNum_Solution(int[] nums) {
        //找出出现次数最多的元素
        int m = MostDupNum_Solution(nums);
        //计算总出现频次
        int count = 0;
        for (int i : nums) {
            if (i == m) {
                count++;
            }
        }
        //判断是否超过一半
        return count > nums.length / 2 ? count : 0;
    }

    /**
     * 摩尔投票算法
     * 可以找出出现次数最多的元素
     *
     * @param nums
     * @return
     */
    public static int MostDupNum_Solution(int[] nums) {
        //找出出现次数最多的元素
        int count = 0;
        int maj = 0;
        for (int i : nums) {
            if (count == 0) {
                maj = i;
                count++;
            } else if (maj == i) {
                count++;
            } else {
                count--;
            }
        }
        return maj;
    }

    /**
     * 序列化
     * 思路和树的前序遍历相同
     *
     * @param root
     * @return
     */
    public static String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }


    /**
     * 32.1 从上往下打印二叉树
     * 层序遍历
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode<Integer> root) {
        //结果集
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //队列
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //核心思想:每取出一个节点,都把它的子节点放入队列
            TreeNode<Integer> poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
        return list;

    }

    /**
     * 32.2 把二叉树打印成多行
     * 层序遍历
     *
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> PrintFromTopToBottomAsRows(TreeNode<Integer> root) {
        //结果集
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //队列
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //单层结果集
            ArrayList<Integer> temp = new ArrayList<>();
            //当前层元素数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //核心思想:每取出一个节点,都把它的子节点放入队列
                TreeNode<Integer> poll = queue.poll();
                temp.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            list.add(temp);
        }
        return list;
    }

    /**
     * 32.3 按之字形顺序打印二叉树
     * 层序遍历
     *
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> PrintFromTopToBottomAsZ(TreeNode<Integer> root) {
        //结果集
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //队列
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            //单层结果集
            ArrayList<Integer> temp = new ArrayList<>();
            //当前层元素数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //核心思想:每取出一个节点,都把它的子节点放入队列
                TreeNode<Integer> poll = queue.poll();
                if (flag) {
                    temp.add(poll.val);
                } else {
                    temp.add(0, poll.val);
                }

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            flag = !flag;//每次打印完单层切换标识
            list.add(temp);

        }
        return list;
    }


    /**
     * 31. 栈的压入、弹出序列
     *
     * @param pushSequence
     * @param popSequence
     * @return
     */
    public static boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushSequence.length; i++) {
            stack.push(pushSequence[i]);
            while (!stack.isEmpty() && stack.peek() == popSequence[j] && j < popSequence.length) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }


    /**
     * 发放随机红包算法
     *
     * @param amt   红包金额
     * @param count 红包数量
     */
    public static void sendRandomBonus(BigDecimal amt, int count) {
        //转为两位小数表示
        amt = amt.setScale(2);
        //红包发放数量i
        int i = 0;

        while (count > 1) {
            //获取随机范围上界,两位小数
            BigDecimal randomHigh = getRandomHigh(amt, count);
            //转int
            BigDecimal multiplyHigh = randomHigh.multiply(new BigDecimal(100));
            int intValue = multiplyHigh.intValue();
            Random rand = new Random();
            //进行随机[1,intValue]
            int rd = rand.nextInt(intValue) + 1;
            //当前红包金额
            BigDecimal curRed = new BigDecimal(rd).divide(new BigDecimal(100));
            //打印
            i++;
            System.out.println("第" + i + "个红包金额为:" + curRed);
            //更新剩余金额和红包数量
            amt = amt.subtract(curRed);
            count--;
        }
        //最后takeAll
        i++;
        System.out.println("第" + i + "个红包金额为:" + amt);
    }

    /**
     * 计算随机范围上界
     *
     * @param amt   当前总剩余金额
     * @param count 当前总剩余红包
     * @return
     */
    private static BigDecimal getRandomHigh(BigDecimal amt, int count) {
        //前置条件(保证每一次红包被领取之后,剩余的金额至少每人可分得0.01元)
        BigDecimal maxRetain = amt.subtract(new BigDecimal("0.01").multiply(new BigDecimal(count - 1)));
        //计算本次随机范围的上限,公式:(当前总剩余金额/当前总剩余红包)*2
        BigDecimal calHigh = amt.multiply(new BigDecimal(2)).divide(new BigDecimal(count), BigDecimal.ROUND_FLOOR);
        //取calHigh和maxRetain二者较小值并返回
        int cp = calHigh.compareTo(maxRetain);
        return cp > 0 ? maxRetain : calHigh;
    }


    /**
     * 把数组排成最小的数
     * 解法:字典排序的思路
     *
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = numbers[i] + "";
        }
        //排序规则:(o1,o2)->(o1+o2).compareTo(o2+o1)
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            builder.append(str[i]);
        }
        return builder.toString();
    }


    /**
     * 翻转链表
     * 递归法
     * 时间O(n) 栈空间O(n)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //缓存next
        ListNode next = head.next;
        //迭代next元素
        ListNode newHead = reverseList(next);
        head.next = null;
        next.next = head;
        return newHead;
    }

    /**
     * 翻转链表
     * 头插法
     * 时间O(n) 空间O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        //虚拟头结点
        ListNode<Integer> summyHead = new ListNode(-1);
        //
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            //头插
            ListNode first = summyHead.next;
            summyHead.next = cur;
            cur.next = first;
            //移动指针
            cur = next;
        }
        return summyHead.next;
    }


    /**
     * 删除链表节点O(1)时间复杂度
     *
     * @param head
     * @param deleteNode
     * @return
     */
    public static ListNode remove(ListNode head, ListNode deleteNode) {
        if (deleteNode == null || head == null) {
            return head;
        }
        if (deleteNode.next != null) {
            //deleteNode非尾节点
            ListNode next = deleteNode.next;
            deleteNode.val = next.val;
            deleteNode.next = next.next;

        } else {
            //尾部节点
            //只有一个节点的情况
            if (head == deleteNode) {
                head = null;
            } else {
                ListNode cur = head;
                while (cur.next != deleteNode) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }


    //======================开始========================================

    /**
     * 使奇数在偶数前边(不需要保持原有相对位置)
     * 双指针最优  时间O(n) 空间O(1)
     *
     * @param nums
     */
    public static void moveOddFront(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (isOdd(nums[left])) {
                left++;
            }
            while (!isOdd(nums[right])) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
    }

    /**
     * 使奇数在偶数前边(需要保持原有相对位置)
     * 解法一:
     * 时间O(n) 空间O(n)
     *
     * @param nums
     */
    public static void moveOddFrontWithOrder1(int[] nums) {
        //额外数组保存
        int[] arr = new int[nums.length];
        int start = 0;
        int end = arr.length - 1;

        int left = 0;
        int right = arr.length - 1;
        while (left < nums.length) {
            //左指针寻找奇数并放入新数组前边
            if (isOdd(nums[left])) {
                arr[start++] = nums[left];
            }
            //右指针寻找偶数并放入新数组后边
            if (!isOdd(nums[right])) {
                arr[end--] = nums[right];
            }
            left++;
            right--;
        }
        //复制
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

    }

    /**
     * 使奇数在偶数前边(需要保持原有相对位置)
     * 解法二 --- 冒泡排序的思想
     * 时间O(n^2) 空间O(1)
     *
     * @param nums
     */
    public static void moveOddFrontWithOrder(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (isOdd(num) && !isOdd(nums[i - 1])) {
                for (int j = i; j > 0; j--) {
                    if (isOdd(nums[j - 1])) {
                        break;
                    }
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    //======================结束========================================


    /**
     * n的二进制表示中1的个数
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }


    /**
     * 反向打印链表
     *
     * @param res
     * @param node
     */
    public static void printNode(List<Integer> res, ListNode<Integer> node) {
        if (node != null) {
            printNode(res, node.next);
            res.add(node.val);
//            System.out.println(node.val);
        }
        return;

    }

    /**
     * 替换空格
     *
     * @param source
     * @return
     */
    public static String replace(String source) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(source.charAt(i));
            }
        }
        return builder.toString();

    }

}
