package tree;

import java.util.Stack;

public class BinaryTree{
		private TreeNode<String> root;//根节点
		
		public BinaryTree (){
			this.root =new TreeNode<String>(1,"A");
			this.createBinaryTree();
		}
		
		/**
		 * 构建二叉树
		 *         A
		 *     B       C
		 * D      E        F
		 */
		public void createBinaryTree(){
			TreeNode<String> nodeB = new TreeNode<>(2, "B");
			TreeNode<String> nodeC = new TreeNode<>(3, "C");
			TreeNode<String> nodeD = new TreeNode<>(4, "D");
			TreeNode<String> nodeE = new TreeNode<>(5, "E");
			TreeNode<String> nodeF = new TreeNode<>(6, "F");
			root.leftChild = nodeB;
			root.rightChild = nodeC;
			nodeB.leftChild = nodeD;
			nodeB.rightChild = nodeE;
			nodeC.rightChild = nodeF;
		}
		
		//获取节点数
		public int getNodes(TreeNode<String> node){
			if(node==null){
				return 0;
			}
			int count = 1;
			if(node.leftChild==null&&node.rightChild==null){
				return count;
			}
			count+=getNodes(node.leftChild)+getNodes(node.getRightChild());
			return count;
		}
		
		//获取高度
		public int getHeight(TreeNode<String> node){
			if(node==null){
				return 0;
			}
			int height = 1;
			if(node.leftChild==null&&node.rightChild==null){
				return height;
			}
			int rightHeight=getHeight(node.rightChild);
			int leftHeight=getHeight(node.leftChild);
			height+=leftHeight>rightHeight?leftHeight:rightHeight;
			return height;
		}
		
		//前序遍历(根、左、右)
		public void preOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			System.out.println(node.getIndex()+":"+node.data);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
		
		//中序遍历（左、根、右）
		public void midOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			midOrder(node.leftChild);
			System.out.println(node.getIndex()+":"+node.data);
			midOrder(node.rightChild);
		}
		
		//后序遍历（左、右、根）
		public void sufOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			sufOrder(node.leftChild);
			sufOrder(node.rightChild);
			System.out.println(node.getIndex()+":"+node.data);
		}
		
		//前序遍历（非递归方式）
		public void preReOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			Stack<TreeNode<String>> stack = new Stack<>();
			stack.push(node);//根节点进栈
			while(!stack.isEmpty()){
				TreeNode<String> n = stack.pop();//根节点出栈
				System.out.println(n.getIndex()+":"+n.data);
				if(n.rightChild!=null){
					stack.push(n.rightChild);
				}
				if(n.leftChild!=null){
					stack.push(n.leftChild);
				}     
			}
		}
		
		//中序遍历（非递归方式）
		public void midReOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			Stack<TreeNode<String>> stack = new Stack<>();
			TreeNode<String> n = node;
			while(n!=null||!stack.isEmpty()){
				while(n!=null){
					stack.push(n);
					n=n.leftChild;
				}
				n=stack.pop();
				System.out.println(n.getIndex()+":"+n.data);
				if(!stack.isEmpty()){
					n=stack.pop();
					System.out.println(n.getIndex()+":"+n.data);
				}
				n=n.rightChild;
			}
		}
		
		//后序遍历（非递归方式）
		public void sufReOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			Stack<TreeNode<String>> stack = new Stack<>();
			TreeNode<String> n = node;
			TreeNode<String> lastNode = n;
			while(n!=null||!stack.isEmpty()){
				while(n!=null){
					stack.push(n);
					n=n.leftChild;
				}	
				n=stack.pop();
				System.out.println(n.getIndex()+":"+n.data);
				lastNode=n;
				while(!stack.isEmpty()&&lastNode==stack.peek().rightChild){
					n=stack.pop();
					System.out.println(n.getIndex()+":"+n.data);
					lastNode=n;
				}
				if(stack.isEmpty())break;
				n=stack.peek();
				n=n.rightChild;
				while(n.rightChild!=null&&n.leftChild==null){
					stack.push(n);
					n=n.rightChild;
				}
			}
		}
	
		public class TreeNode<E>{
			private int index;//节点索引
			private E data;//节点存放的对象
			private TreeNode<E> leftChild;//左孩子
			private TreeNode<E> rightChild;//右孩子
			public TreeNode(int index,E data){
				this.index=index;
				this.data=data;
			}
			public int getIndex() {
				return index;
			}
			public void setIndex(int index) {
				this.index = index;
			}
			public E getData() {
				return data;
			}
			public void setData(E data) {
				this.data = data;
			}
			public TreeNode<E> getLeftChild() {
				return leftChild;
			}
			public void setLeftChild(TreeNode<E> leftChild) {
				this.leftChild = leftChild;
			}
			public TreeNode<E> getRightChild() {
				return rightChild;
			}
			public void setRightChild(TreeNode<E> rightChild) {
				this.rightChild = rightChild;
			}
		}
		
		public static void main(String[] args){
			BinaryTree binaryTree = new BinaryTree();
			TreeNode<String> root = binaryTree.root;
			System.out.println(binaryTree.getNodes(root));
			System.out.println(binaryTree.getHeight(root));
//			binaryTree.preOrder(root);
//			System.out.println("----------------------");
//			binaryTree.midOrder(root);
//			System.out.println("----------------------");
//			binaryTree.sufOrder(root);
//			System.out.println("----------------------");
//			binaryTree.preReOrder(root);
//			System.out.println("----------------------");
//			binaryTree.midReOrder(root);
			System.out.println("----------------------");
			binaryTree.sufReOrder(root);
		}
}
