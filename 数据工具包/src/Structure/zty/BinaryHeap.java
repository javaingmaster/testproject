package Structure.zty;

import java.util.ArrayList;

public class BinaryHeap {
	private int capacity = 0;
	private int size = 0;
	private Tuple[] tuples = null;
	private ArrayList<Integer> lvls = null;
	
	public BinaryHeap(int capacity){
		this.capacity = capacity;
		this.tuples = new Tuple[this.capacity];
		this.lvls = new ArrayList<Integer>();
		int lv = 1;
		while(true){
			int s = 2 << (lv-1);
			if ( s > this.capacity )
				break;
			this.lvls.add(s); 
			lv++;
		}
	}
	
	public void printHeap(int pos, int lv){
		if( this.size == 0 ){
			System.out.println("No data in heap");
			return;
		}
		String indent = "";
		for( int i = 0 ; i < lv - 1; i++ )
			indent += "\t";
		Tuple item = this.tuples[pos];
		System.out.println(indent + 
				String.format("%.2f", item.weight())+":"+item.value());
		int left = 2 * pos;
		int right = 2 * pos + 1;
		if ( this.tuples[left] == null )
			return;
		printHeap(left, lv + 1);
		if ( this.tuples[right] == null )
			return;
		printHeap(right, lv + 1);
	}
	
	
	public void insert(Tuple tuple){
		this.size++;
		this.tuples[this.size] = tuple;
		adjust_up(this.size, tuple.weight());
	}

	public Tuple pop(){
		if( this.size == 0 )
			return null;
		if( this.size == 1 ){
			this.size--;
			Tuple ret = this.tuples[1];
			this.tuples[1] = null;
			return ret;
		}
		Tuple ret = this.tuples[1];
		this.tuples[1] = this.tuples[this.size];
		this.tuples[this.size] = null;
		adjust_down(1, this.tuples[1].weight());
		this.size--;
		return ret;
	}
	
	private void adjust_up(int pos, double weight){
		if( pos == 1 )
			return;
		int parent_pos = (int)Math.floor( (float)pos / 2.0);
		if( this.tuples[parent_pos].weight() >  weight ){
			Tuple tmp = this.tuples[parent_pos];
			this.tuples[parent_pos] = this.tuples[pos];
			this.tuples[pos] = tmp;
			adjust_up(parent_pos, weight);			
		}else
			return;
	} 
	
	private void adjust_down(int pos, double weight){
		int left_pos = 2 * pos;
		int right_pos = 2 * pos + 1;
		if ( this.tuples[left_pos] == null )
			return ;
		
		int child_pos = left_pos; 
		Tuple child = null;
		if ( this.tuples[right_pos] == null ){
			child = this.tuples[left_pos];
			child_pos = left_pos;
		}else{
			if( this.tuples[left_pos].weight() < this.tuples[right_pos].weight() ){
				child = this.tuples[left_pos];
				child_pos = left_pos;
			}else{
				child = this.tuples[right_pos];
				child_pos = right_pos;
			}
		}
		if ( child.weight() < weight ){ 
			this.tuples[child_pos] = this.tuples[pos];
			this.tuples[pos] = child;
			adjust_down(child_pos, weight);
		}else
			return;
	}
	
	public int size(){
		return this.size;
	}
	
	public int capacity(){
		return this.capacity;
	}
}


abstract class Tuple{
	abstract double weight();
	abstract String value();
}