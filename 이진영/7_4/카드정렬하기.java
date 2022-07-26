
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(Integer.parseInt(st.nextToken())); 
		}
		

		while(pq.size() > 1) {
			int one =pq.poll();
			int two =pq.poll();
			int num = one + two;
			ans+= num;
			pq.add(num);
		}
		System.out.println(ans);
	}
}

class PriorityQueue<E> {

	private int size;	// 요소 개수
	private Object[] array;	// 요소를 담을 배열
	private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기 
//	private final Comparator<? super E> comparator;
	
	public PriorityQueue() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}
	

	public boolean add(E e) {
		// TODO Auto-generated method stub
		// 배열 용적이 꽉 차있을 경우 용적을 두 배로 늘려준다.
		
		if(size + 1 == array.length) {
			resize(array.length * 2);
		}
		
		siftUp(size + 1, e);	// 가장 마지막에 추가되는 위치와 넣을 값(타겟)을 넘겨줌 
		size++;	// 정상적으로 재배치가 끝나면 사이즈(요소 개수) 증가
	
		return true;
	}

	public E poll() {
		// TODO Auto-generated method stub
		if(array[1] == null) {
			return null;
		}
		
		E result = (E) array[1];	// 삭제된 요소를 반환하기 위한 임시 변수 
		E target = (E) array[size];	// 타겟이 될 요소
		
		array[size] = null;	// 타겟 노드(index)을 비운다.
		this.size--;	// 사이즈를 1 감소 	
		siftDown(1, target);
		return result;
	}
	
	private void siftUp(int idx, E target) {
		Comparable<? super E> comp = (Comparable<? super E>) target;
		
		while(idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent];
			
			if(comp.compareTo((E)parentVal) >= 0) {
				break;
			}
			array[idx] = parentVal;
			idx = parent;
		}
		array[idx] = comp;
	}
	
	private void siftDown(int idx, E target) {
		
		Comparable<? super E> comp = (Comparable<? super E>) target;
		
		array[idx] = null;
		
		int parent = idx;
		int child;
 
		while((child = (parent << 1)) <= size) {
			
			int right = child + 1;
			
			Object c = array[child];
			
			if(right <= size && ((Comparable<? super E>)c).compareTo((E)array[right]) > 0) {
				child = right;
				c = array[child];
			}
			
			if(comp.compareTo((E) c) <= 0){
				break;
			}
			array[parent] = c;
			parent = child;
			
		}
		array[parent] = comp;
		
		if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
	}
	
	private void resize(int newCapacity) {
		
		// 새로 만들 배열
		Object[] newArray = new Object[newCapacity];
		
		// 새 배열에 기존에 있던 배열의 요소들을 모두 복사해준다. 
		for(int i = 1; i <= size; i++) {
			newArray[i] = array[i];
		}
		
		/*
		 * 현재 배열은 GC 처리를 위해 null로 명확하게 처리한 뒤
		 * 새 배열을 array에 연결해준다.
		 */
		this.array = null;
		this.array = newArray;
		
	}
	
	private int getParent(int index) {
		return index / 2;
	}

	public int size() {

		return size;
	}

	
}
