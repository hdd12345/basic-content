package tree;

import java.util.Stack;

public class BinaryTree{
		private TreeNode<String> root;//���ڵ�
		
		public BinaryTree (){
			this.root =new TreeNode<String>(1,"A");
			this.createBinaryTree();
		}
		
		/**
		 * ����������
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
		
		//��ȡ�ڵ���
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
		
		//��ȡ�߶�
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
		
		//ǰ�����(��������)
		public void preOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			System.out.println(node.getIndex()+":"+node.data);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
		
		//����������󡢸����ң�
		public void midOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			midOrder(node.leftChild);
			System.out.println(node.getIndex()+":"+node.data);
			midOrder(node.rightChild);
		}
		
		//������������ҡ�����
		public void sufOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			sufOrder(node.leftChild);
			sufOrder(node.rightChild);
			System.out.println(node.getIndex()+":"+node.data);
		}
		
		//ǰ��������ǵݹ鷽ʽ��
		public void preReOrder(TreeNode<String> node){
			if(node==null){
				return;
			}
			Stack<TreeNode<String>> stack = new Stack<>();
			stack.push(node);//���ڵ��ջ
			while(!stack.isEmpty()){
				TreeNode<String> n = stack.pop();//���ڵ��ջ
				System.out.println(n.getIndex()+":"+n.data);
				if(n.rightChild!=null){
					stack.push(n.rightChild);
				}
				if(n.leftChild!=null){
					stack.push(n.leftChild);
				}     
			}
		}
		
		//����������ǵݹ鷽ʽ��
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
		
		//����������ǵݹ鷽ʽ��
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
			private int index;//�ڵ�����
			private E data;//�ڵ��ŵĶ���
			private TreeNode<E> leftChild;//����
			private TreeNode<E> rightChild;//�Һ���
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
