package typical.HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class 并查集的实现 {
    // 给定一个无重复的整形数组，初始时认为arr的每个数各自都是一个单独的集合。设计一种并查集：
    //1.boolean isSameSet(int a,int b) 查询a和b两个数是否属于一个集合
    //2.void union(int a,int b) 吧a所在集合与b所在集合合并。

    class Element<V>{
        public V value;
        public Element(V value){
            this.value = value;
        }
    }
    class UnionFindSet<V>{
        public HashMap<V,Element<V>> elementMap;
        HashMap<Element<V>,Element<V>> fatherMap;
        HashMap<Element<V>,Integer> rankMap;  // 数量；head包括的数量

        UnionFindSet(List<V> list){
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for(V value:list){
                Element<V> element = new Element<>(value);
                elementMap.put(value,element);
                fatherMap.put(element,element); // 初始化时每个节点都是一个集合
                rankMap.put(element,1);
            }
        }
        Element<V> findHead(Element<V> element){
            Stack<Element<V>> path = new Stack<>();
            while(element!=fatherMap.get(element)){
                path.push(element);
                element = fatherMap.get(element);
            }
            while(!path.isEmpty()){
                fatherMap.put(path.pop(),element);   // 把深度展开成广度；
            }
            return element;
        }
        boolean isSameSet(V a,V b){
            if(elementMap.containsKey(a)&&elementMap.containsKey(b)){
                return findHead(elementMap.get(a))==findHead(elementMap.get(b));
            }
            return false;
        }
        void union(V a,V b){
            if(elementMap.containsKey(a)&&elementMap.containsKey(b)){
                Element<V> af = findHead(elementMap.get(a));
                Element<V> bf = findHead(elementMap.get(b));
                if(af!=bf){
                    Element<V> big = rankMap.get(af)>=rankMap.get(bf)?af:bf;
                    Element<V> small = big==af?bf:af;
                    fatherMap.put(small,big);
                    rankMap.put(big,rankMap.get(af)+rankMap.get(bf));
                    rankMap.remove(small);
                }
            }
        }

    }
}
