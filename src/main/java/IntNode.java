class IntNode
{
    int data;
    IntNode next;

    public IntNode(int data)
    {
        this.data = data;
        this.next = null;
    }

    public IntNode(int data, IntNode next)
    {
        this.data = data;
        this.next = next;
    }
}
