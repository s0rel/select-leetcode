```java
/**
 * 先遍历，后重构为链表
 */
public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        // 前序遍历
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        // 重构二叉树，左节点恒等于null
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            TreeNode previous = list.get(i);
            TreeNode current = list.get(i + 1);
            previous.left = null;
            previous.right = current;
        }
    }
}
```