package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * User: y.fan
 * Date: 24/02/2020
 */
public final class TopKFrequentElt {
  // O(n * log n)
  // 1 <= k <= nums.size

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, List<Integer>> locMap = new HashMap<>();
    Arrays.stream(nums).forEach(e -> {
      final List<Integer> locValueList = locMap.get(e);
      if (null == locValueList) {
        final ArrayList<Integer> locList = new ArrayList<>();
        locList.add(e);
        locMap.put(e, locList);
      } else {
        locValueList.add(e);
      }
    });

    PriorityQueue<Integer> locQueue = new PriorityQueue<>(locMap.size());

    for(Map.Entry<Integer, List<Integer>> locEntry : locMap.entrySet()) {
      final List<Integer> locValue = locEntry.getValue();
      locQueue.offer(locValue.size());
    }

    List<Integer> locRes = new ArrayList<>(k);
    for (int locIdx = 0; locIdx < k; locIdx++) {

    }
    return locRes;
  }
}
