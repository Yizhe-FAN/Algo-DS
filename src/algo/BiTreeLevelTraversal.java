import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class BiTreeLevelTraversal {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {

    // Queue BFS
    final Queue<Pair<Integer,TreeNode>> locQueue = new LinkedList<>();
    final Map<Integer, List<Integer>> locListMap = new LinkedHashMap();

    // Init root
    if (root != null) {
      locQueue.add(new Pair<>(0, root));
    }

    // Traversal
    while (!locQueue.isEmpty()) {
      Pair<Integer, TreeNode> locPair = locQueue.poll();
      Integer locHeigh = locPair.getKey();
      TreeNode locNode = locPair.getValue();
      if (null != locNode.left) {
        locQueue.add(new Pair(locHeigh + 1, locNode.left));
      }
      if (null != locNode.right) {
        locQueue.add(new Pair(locHeigh + 1, locNode.right));
      }

      List<Integer> locList = locListMap.get(locHeigh);
      if (null == locList) {
        locList = new ArrayList();
        locList.add(locNode.val);
        locListMap.put(locHeigh, locList);
      } else {
        locList.add(locNode.val);
      }
    }

    // Construct list return
    final List<List<Integer>> locTotalList = new ArrayList();
    for(Map.Entry<Integer, List<Integer>> locEntry : locListMap.entrySet()) {
      locTotalList.add(locEntry.getValue());
    }
    return locTotalList;
  }

  public static TreeNode stringToTreeNode(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(Integer.parseInt(item));
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while(!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int leftNumber = Integer.parseInt(item);
        node.left = new TreeNode(leftNumber);
        nodeQueue.add(node.left);
      }

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int rightNumber = Integer.parseInt(item);
        node.right = new TreeNode(rightNumber);
        nodeQueue.add(node.right);
      }
    }
    return root;
  }

  public static String integerArrayListToString(List<Integer> nums, int length) {
    if (length == 0) {
      return "[]";
    }

    String result = "";
    for(int index = 0; index < length; index++) {
      Integer number = nums.get(index);
      result += Integer.toString(number) + ", ";
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static String integerArrayListToString(List<Integer> nums) {
    return integerArrayListToString(nums, nums.size());
  }

  public static String int2dListToString(List<List<Integer>> nums) {
    StringBuilder sb = new StringBuilder("[");
    for (List<Integer> list: nums) {
      sb.append(integerArrayListToString(list));
      sb.append(",");
    }

    sb.setCharAt(sb.length() - 1, ']');
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //String line;
    //while ((line = in.readLine()) != null) {
    TreeNode root = stringToTreeNode("[3,9,20,null,null,15,7]");

    List<List<Integer>> ret = new BiTreeLevelTraversal().levelOrder(root);

    String out = int2dListToString(ret);

    System.out.print(out);
    //}
  }

}