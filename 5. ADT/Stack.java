import java.util.EmptyStackException;

/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
interface Stack<E> {

    /**
     * 回傳堆疊是否已滿。
     *
     * @return true if the stack is full, false otherwise.
     */
    boolean isFull();

    /**
     * 回傳堆疊是否為空。
     *
     * @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * 若堆疊未滿，插入元素 item 至堆疊頂端，並回傳此堆疊物件。
     *
     * @param element to be inserted.
     * @return the stack which insert this element.
     */
    Stack push(E element);

    /**
     * 若堆疊未空，移除並回傳堆疊頂端的元素。
     *
     * @return element removed.
     * @throws EmptyStackException if the stack is empty.
     */
    E pop() throws EmptyStackException;


    /**
     * 回傳此堆疊中，元素的個數。
     *
     * @return number of elements in the stack.
     */
    int size();

    /**
     * 回傳堆疊頂端的元素，但是不移除
     *
     * @return top element in the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    E top() throws EmptyStackException;
}
