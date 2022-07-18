# 🌳 Tree

- 비선형 자료구조 중 하나
- 계층적 구조

1. 데이터를 저장할 클래스 공간(=노드) 생성

	Node 클래스
	저장할 값 변수 / 왼쪽 연결 노드 / 오른쪽 연결 노드 에 대한 정보를 저장할 변수. <br> 총 3개를 필드로 정의

	```java
	public class Node {
		Object data;
		Node left;
		Node rigth;
	}
	```
<br>

2. 각각의 노드들에 값 저장

<center> 

![Tree1](./Tree1.png)

3개의 노드를 생성하고, 우선 leftNode와 rightNode에 대한 정보를 null로 초기화

</center>
 
<br>

3. 노드 간 연결 상태 정의

	Node1의 leftNode : Node2

	Node1의 rightNode : Node3

<center> 

![Tree2](./Tree2.png)

3개의 노드를 생성하고, 우선 leftNode와 rightNode에 대한 정보를 null로 초기화

</center>

<br>

```java
Node node1 = tree.addNode(1);
Node node1 = tree.addNode(1);
Node node1 = tree.addNode(1);
node1.addLeft(node2);
node1.addRigth(node3);
```
<br>


# 📃✍🏻용어

<center> 

![Tree3](./Tree3.png)

</center>

	루트(root) : 트리 구조 중 최상위에 존재하는 노드 (1을 가리킴)

	노드(node) : 트리에서 각각의 구성 요소

	레벨(level) : 트리에서 각각의 층을 나타내는 단어(루트 노드 : 0)

	형제 노드(sibling) : 같은 레벨의 노드

	간선(edge) : 노드와 노드를 연결하는 선

	부모 노드(parent node) : 한 노드를 기준으로 바로 상위에 존재하는 노드

	자식 노드(child node) : 한 노드를 기준으로 바로 하위에 존재하는 노드

	높이(heigh) : 트리 중 최고 레벨

<br> 

# ✌🏻 이진트리

<center> 

![Tree4](./Tree4.png)

</center>

자식 노드가 최대 2개인 트리를 이진트리라고 한다.

 <br>


# ♻ 순회 방법

<center> 

![Tree5](./Tree5.png)

</center>

전위 순회(pre-order) : 루트 노드를 먼저 순회한 이후, '왼쪽 하위 -> 오른쪽 하위' 순으로 순회

중위 순회(in-order) : 왼쪽 가장 하위 노드를 먼저 순회한 이후, '바로 상위 노드 -> 오른쪽 하위' 순으로 순회

후위 순회(pre-order) : 왼쪽 가장 하위 노드를 먼저 순회한 이후, '오른쪽 하위 노드 -> 바로 상위 노드' 순으로 순회


전위 순회 순서 : 1 - 2 - 4 - 5 - 3 - 6 - 7

중위 순회 순서 : 4 - 2 - 5 - 1 - 6 - 3 - 7

후위 순회 순서 : 4 - 5 - 2 - 6 - 7 - 3 - 1

<br>

# 🛠 기능

## Node

	- void addLeft(Node node)

		현재 노드의 좌측에 노드 연결 정보를 추가

	- void addRight(Node node)

		현재 노드의 우측에 노드 연결 정보를 추가

	- void deleteLeft()

		현재 노드의 좌측 노드 연결 정보를 삭제

	- void deleteRight()

		현재 노드의 좌측 노드 연결 정보를 삭제

## Tree

	- Node addNode(Object data)

		노드를 새롭게 생성 (저장될 데이터는 data 변수 안에 존재하는 값)

	- void preOrder(Node node)

		전위 순회 방법을 이용해 출력

	- void inOrder(Node node)

		중위 순회 방법을 이용해 출력

	- void postOrder(Node node)

		후위 순회 방법을 이용해 출력


# ⚡구현

## Tree 클래스(Node 클래스 포함)

```java
public class Tree {
	int count;
	
	public Tree() {
		count = 0;
	}
	
	public class Node {
		Object data;
		Node left;
		Node right;
	
		// 생성 시 매개변수를 받아 초기화하는 방법으로만 선언 가능
		public Node(Object data) {
			this.data = data;
			left = null;
			right = null;
		}

		public void addLeft(Node node) {
			left = node;
			count++;
		}

		public void addRight(Node node) {
			right = node;
			count++;
		}

		public void deleteLeft() {
			left = null;
			count--;
		}

		public void deleteRight() {
			right = null;
			count--;
		}
	}
	
	public Node addNode(Object data) {
		Node n = new Node(data);
		return n;
	}
	
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder(Node node) {
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public void postOrder(Node node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
}
```

<br>

## Run 클래스(코드 실행 클래스)

```java
public class Run {
	public static void main(String[] args) {
		// 트리 생성
		Tree tree = new Tree();
		
		// 노드 생성
		Node node1 = tree.addNode(1);
		Node node2 = tree.addNode(2);
		Node node3 = tree.addNode(3);
		Node node4 = tree.addNode(4);
		Node node5 = tree.addNode(5);
		Node node6 = tree.addNode(6);
		Node node7 = tree.addNode(7);
		
		// 트리 연결관계 생성
		/*  트리 모양       
		 *        1
		 *     2     3
		 *   4  5  6   7
		 */
		node1.addLeft(node2);
		node1.addRight(node3);
		node2.addLeft(node4);
		node2.addRight(node5);
		node3.addLeft(node6);
		node3.addRight(node7);
		
		// 순회
		tree.preOrder(node1);
		System.out.println();
		tree.inOrder(node1);
		System.out.println();
		tree.postOrder(node1);
		System.out.println();
		
		// 삭제
		node2.deleteLeft();
		node3.deleteRight();
		/* 삭제 이후 트리 모양
		 *        1
		 *     2     3
		 *      5  6   
		 */
		
		// 순회
		System.out.println();
		tree.preOrder(node1);
		System.out.println();
		tree.inOrder(node1);
		System.out.println();
		tree.postOrder(node1);
		System.out.println();
	}
}
```