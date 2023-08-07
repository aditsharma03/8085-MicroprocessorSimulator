import java.util.LinkedList;
import java.util.Queue;

public class Memory
{
    private String[] _memory;
    private Queue<Integer> _size_queue;

    /*********** Constructor **************/
    public Memory()
    {
        _memory = new String[65536];
        _size_queue = new LinkedList<>();
    }

    public void editMemory( int x, String data )
    {
        _memory[x] = data;
    }

    public String getMemory( int x )
    {
        return _memory[x];
    }

    public void enqueue( int x ){
        _size_queue.add( x );
    }
    public int dequeue(){
        return _size_queue.remove();
    }
}