import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Title:
 *
 * @author chaycao
 * @description:
 * @date 2018-04-08 09:30.
 */
public class Solution_284 {
    class PeekingIterator implements Iterator<Integer> {

        private List<Integer> list = new ArrayList<>();

        private int index = 0;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return list.get(index);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            if (index+1 <= list.size())
                return true;
            return false;
        }
    }
}
