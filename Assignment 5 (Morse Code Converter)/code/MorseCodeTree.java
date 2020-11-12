import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root;
	public MorseCodeTree() {
		buildTree();
	}
	
	public TreeNode<String> getRoot(){
		return root;		
	}
	
	public void setRoot (TreeNode<String> newNode) {	
		root = newNode;
	}
	
	public MorseCodeTree insert(String code, String letter) {	
		addNode(root,code,letter);
		return this;
	}
	
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.charAt(0) == '.') {
				root.left = new TreeNode<String>(letter);
			}else if(code.charAt(0) == '-'){
				root.right = new TreeNode<String>(letter);
			}

		} else {
			if(code.charAt(0) == '.')
				addNode(root.left, code.substring(1),letter);
			else if(code.charAt(0) == '-')
				addNode(root.right, code.substring(1), letter);
		}
	}
	
	public String fetch(String code) {

		return fetchNode(root, code);
	}
	
	public String fetchNode(TreeNode<String> root, String code) {
		
		String letter;
		if(code.length()<=1) {
			if(code.equals("."))
				return root.left.data;
			else
				return root.right.data;

		}
		else {
			if(code.charAt(0) == '.')
				letter = fetchNode(root.left, code.substring(1));
			else 
				letter = fetchNode(root.right, code.substring(1));
		}		
		return letter;
	}
	
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public MorseCodeTree update() throws UnsupportedOperationException {		
		throw new UnsupportedOperationException();
	}
	
	public void buildTree() {
		root = new TreeNode<String>("");
		
		insert(".", "e");
		insert("-", "t");

		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	
	public ArrayList<String> toArrayayayList() {
		
		ArrayList<String> toArray = new ArrayList<String>();
		LNRoutputTraversal(root, toArray);	
		
		return toArray;
		
	}
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if(root.left != null)
			LNRoutputTraversal(root.left,list);
		list.add(root.data);
		if(root.right != null)
			LNRoutputTraversal(root.right,list);
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> toArray = new ArrayList<String>();
		LNRoutputTraversal(root, toArray);	
		
		return toArray;

	}

}
