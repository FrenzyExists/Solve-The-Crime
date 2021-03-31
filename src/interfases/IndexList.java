package interfases;

public interface IndexList<T> {

    /**
     *
     * @return
     */
    public int size();

    /**
     *
     * @return
     */
    public boolean isEmpty();

    /**
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) throws IndexOutOfBoundsException;

    /**
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T remove(int index) throws IndexOutOfBoundsException;

    /**
     *
     * @param index
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    public T set(int index, T e) throws IndexOutOfBoundsException;

    /**
     *
     * @param index
     * @param e
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, T e) throws IndexOutOfBoundsException;

    /**
     *
     * @param e
     */
    public void add(T e);

    /**
     *
     * @param e
     * @return
     */
    public int removeAll(T e);

    /**
     *
     * @param targetElement
     * @param newElement
     */
    public void insertAfter(T targetElement, T newElement);
}
