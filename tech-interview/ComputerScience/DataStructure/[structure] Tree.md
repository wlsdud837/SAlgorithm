# ๐ณ Tree

- ๋น์ ํ ์๋ฃ๊ตฌ์กฐ ์ค ํ๋
- ๊ณ์ธต์  ๊ตฌ์กฐ

1. ๋ฐ์ดํฐ๋ฅผ ์ ์ฅํ  ํด๋์ค ๊ณต๊ฐ(=๋ธ๋) ์์ฑ

	Node ํด๋์ค
	์ ์ฅํ  ๊ฐ ๋ณ์ / ์ผ์ชฝ ์ฐ๊ฒฐ ๋ธ๋ / ์ค๋ฅธ์ชฝ ์ฐ๊ฒฐ ๋ธ๋ ์ ๋ํ ์ ๋ณด๋ฅผ ์ ์ฅํ  ๋ณ์. <br> ์ด 3๊ฐ๋ฅผ ํ๋๋ก ์ ์

	```java
	public class Node {
		Object data;
		Node left;
		Node rigth;
	}
	```
<br>

2. ๊ฐ๊ฐ์ ๋ธ๋๋ค์ ๊ฐ ์ ์ฅ

<center> 

![Tree1](./Tree1.png)

3๊ฐ์ ๋ธ๋๋ฅผ ์์ฑํ๊ณ , ์ฐ์  leftNode์ rightNode์ ๋ํ ์ ๋ณด๋ฅผ null๋ก ์ด๊ธฐํ

</center>
 
<br>

3. ๋ธ๋ ๊ฐ ์ฐ๊ฒฐ ์ํ ์ ์

	Node1์ leftNode : Node2

	Node1์ rightNode : Node3

<center> 

![Tree2](./Tree2.png)

3๊ฐ์ ๋ธ๋๋ฅผ ์์ฑํ๊ณ , ์ฐ์  leftNode์ rightNode์ ๋ํ ์ ๋ณด๋ฅผ null๋ก ์ด๊ธฐํ

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


# ๐โ๐ป์ฉ์ด

<center> 

![Tree3](./Tree3.png)

</center>

	๋ฃจํธ(root) : ํธ๋ฆฌ ๊ตฌ์กฐ ์ค ์ต์์์ ์กด์ฌํ๋ ๋ธ๋ (1์ ๊ฐ๋ฆฌํด)

	๋ธ๋(node) : ํธ๋ฆฌ์์ ๊ฐ๊ฐ์ ๊ตฌ์ฑ ์์

	๋ ๋ฒจ(level) : ํธ๋ฆฌ์์ ๊ฐ๊ฐ์ ์ธต์ ๋ํ๋ด๋ ๋จ์ด(๋ฃจํธ ๋ธ๋ : 0)

	ํ์  ๋ธ๋(sibling) : ๊ฐ์ ๋ ๋ฒจ์ ๋ธ๋

	๊ฐ์ (edge) : ๋ธ๋์ ๋ธ๋๋ฅผ ์ฐ๊ฒฐํ๋ ์ 

	๋ถ๋ชจ ๋ธ๋(parent node) : ํ ๋ธ๋๋ฅผ ๊ธฐ์ค์ผ๋ก ๋ฐ๋ก ์์์ ์กด์ฌํ๋ ๋ธ๋

	์์ ๋ธ๋(child node) : ํ ๋ธ๋๋ฅผ ๊ธฐ์ค์ผ๋ก ๋ฐ๋ก ํ์์ ์กด์ฌํ๋ ๋ธ๋

	๋์ด(heigh) : ํธ๋ฆฌ ์ค ์ต๊ณ  ๋ ๋ฒจ

<br> 

# โ๐ป ์ด์งํธ๋ฆฌ

<center> 

![Tree4](./Tree4.png)

</center>

์์ ๋ธ๋๊ฐ ์ต๋ 2๊ฐ์ธ ํธ๋ฆฌ๋ฅผ ์ด์งํธ๋ฆฌ๋ผ๊ณ  ํ๋ค.

 <br>


# โป ์ํ ๋ฐฉ๋ฒ

<center> 

![Tree5](./Tree5.png)

</center>

์ ์ ์ํ(pre-order) : ๋ฃจํธ ๋ธ๋๋ฅผ ๋จผ์  ์ํํ ์ดํ, '์ผ์ชฝ ํ์ -> ์ค๋ฅธ์ชฝ ํ์' ์์ผ๋ก ์ํ

์ค์ ์ํ(in-order) : ์ผ์ชฝ ๊ฐ์ฅ ํ์ ๋ธ๋๋ฅผ ๋จผ์  ์ํํ ์ดํ, '๋ฐ๋ก ์์ ๋ธ๋ -> ์ค๋ฅธ์ชฝ ํ์' ์์ผ๋ก ์ํ

ํ์ ์ํ(pre-order) : ์ผ์ชฝ ๊ฐ์ฅ ํ์ ๋ธ๋๋ฅผ ๋จผ์  ์ํํ ์ดํ, '์ค๋ฅธ์ชฝ ํ์ ๋ธ๋ -> ๋ฐ๋ก ์์ ๋ธ๋' ์์ผ๋ก ์ํ


์ ์ ์ํ ์์ : 1 - 2 - 4 - 5 - 3 - 6 - 7

์ค์ ์ํ ์์ : 4 - 2 - 5 - 1 - 6 - 3 - 7

ํ์ ์ํ ์์ : 4 - 5 - 2 - 6 - 7 - 3 - 1

<br>

# ๐  ๊ธฐ๋ฅ

## Node

	- void addLeft(Node node)

		ํ์ฌ ๋ธ๋์ ์ข์ธก์ ๋ธ๋ ์ฐ๊ฒฐ ์ ๋ณด๋ฅผ ์ถ๊ฐ

	- void addRight(Node node)

		ํ์ฌ ๋ธ๋์ ์ฐ์ธก์ ๋ธ๋ ์ฐ๊ฒฐ ์ ๋ณด๋ฅผ ์ถ๊ฐ

	- void deleteLeft()

		ํ์ฌ ๋ธ๋์ ์ข์ธก ๋ธ๋ ์ฐ๊ฒฐ ์ ๋ณด๋ฅผ ์ญ์ 

	- void deleteRight()

		ํ์ฌ ๋ธ๋์ ์ข์ธก ๋ธ๋ ์ฐ๊ฒฐ ์ ๋ณด๋ฅผ ์ญ์ 

## Tree

	- Node addNode(Object data)

		๋ธ๋๋ฅผ ์๋กญ๊ฒ ์์ฑ (์ ์ฅ๋  ๋ฐ์ดํฐ๋ data ๋ณ์ ์์ ์กด์ฌํ๋ ๊ฐ)

	- void preOrder(Node node)

		์ ์ ์ํ ๋ฐฉ๋ฒ์ ์ด์ฉํด ์ถ๋ ฅ

	- void inOrder(Node node)

		์ค์ ์ํ ๋ฐฉ๋ฒ์ ์ด์ฉํด ์ถ๋ ฅ

	- void postOrder(Node node)

		ํ์ ์ํ ๋ฐฉ๋ฒ์ ์ด์ฉํด ์ถ๋ ฅ


# โก๊ตฌํ

## Tree ํด๋์ค(Node ํด๋์ค ํฌํจ)

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
	
		// ์์ฑ ์ ๋งค๊ฐ๋ณ์๋ฅผ ๋ฐ์ ์ด๊ธฐํํ๋ ๋ฐฉ๋ฒ์ผ๋ก๋ง ์ ์ธ ๊ฐ๋ฅ
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

## Run ํด๋์ค(์ฝ๋ ์คํ ํด๋์ค)

```java
public class Run {
	public static void main(String[] args) {
		// ํธ๋ฆฌ ์์ฑ
		Tree tree = new Tree();
		
		// ๋ธ๋ ์์ฑ
		Node node1 = tree.addNode(1);
		Node node2 = tree.addNode(2);
		Node node3 = tree.addNode(3);
		Node node4 = tree.addNode(4);
		Node node5 = tree.addNode(5);
		Node node6 = tree.addNode(6);
		Node node7 = tree.addNode(7);
		
		// ํธ๋ฆฌ ์ฐ๊ฒฐ๊ด๊ณ ์์ฑ
		/*  ํธ๋ฆฌ ๋ชจ์       
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
		
		// ์ํ
		tree.preOrder(node1);
		System.out.println();
		tree.inOrder(node1);
		System.out.println();
		tree.postOrder(node1);
		System.out.println();
		
		// ์ญ์ 
		node2.deleteLeft();
		node3.deleteRight();
		/* ์ญ์  ์ดํ ํธ๋ฆฌ ๋ชจ์
		 *        1
		 *     2     3
		 *      5  6   
		 */
		
		// ์ํ
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