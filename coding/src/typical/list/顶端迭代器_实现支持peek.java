package typical.list;

import java.util.Iterator;

/**
 * @Author: ly
 * @Date: 2020/7/20 11:50
 * @Version 1.0
 */
public class 顶端迭代器_实现支持peek {
    /**
     * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。
     * 设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next()
     * 方法返回的元素 peek() 出来。
     *
     * 创建一个新的迭代器，指向原迭代器的后一位
     */
    class PeekingIterator implements Iterator<Integer> {
        private Integer next;
        private Iterator<Integer> ite;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            ite = iterator;
            if(ite.hasNext()){
                next=ite.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer res = next;
            if(ite.hasNext()){
                next= ite.next();
            }else
                next = null;
            return res;
        }

        @Override
        public boolean hasNext() {
            return next!=null;
        }
    }
}

