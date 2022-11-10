package Algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm
{

	public static void main(String[] args)
	{
		//创建广播电台,将电台放到hashmap中进行管理
		HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
		//将各个电台放入集合中
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("天津");
		hashSet4.add("上海");
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
		//加入到大连
		broadcasts.put("k1", hashSet1);
		broadcasts.put("k2", hashSet2);
		broadcasts.put("k3", hashSet3);
		broadcasts.put("k4", hashSet4);
		broadcasts.put("k5", hashSet5);
		HashSet<String> allArea = new HashSet<String>();
		allArea.add("北京");
		allArea.add("上海");
		allArea.add("天津");
		allArea.add("广州");
		allArea.add("深圳");
		allArea.add("成都");
		allArea.add("杭州");
		allArea.add("大连");
		//创建ArrayList,存放可能的电台集合
		ArrayList<String> selects = new ArrayList<String>();
		//定义一个临时的集合,保存遍历过程中电台覆盖的地区与当前还没覆盖地区的交集
		HashSet<String> tempSet = new HashSet<String>();
		//定义一个maxKey
		String maxKey = null;
		while(allArea.size() != 0) 
		{
			maxKey = null;
			for(String key: broadcasts.keySet()) 
			{
				tempSet.clear();
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				//求交集,交集结果会覆盖原tempSet内容
				tempSet.retainAll(allArea);
				//求出当前覆盖最多的电台
				if(tempSet.size() > 0 &&
						(maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) 
				{
					maxKey = key;
				}
			
			}
			if(maxKey != null) 
				{
					selects.add(maxKey);
					//以选出电台覆盖地区从allArea中去掉
					allArea.removeAll(broadcasts.get(maxKey));
				}
		}
			System.out.println(selects);
	}

}
