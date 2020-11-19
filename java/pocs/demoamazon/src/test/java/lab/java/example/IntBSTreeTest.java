package lab.java.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntBSTreeTest {

	
	@Test
	public void shouldInsertKey() {
		//Given
		int [] keys = new int[] {0,1,2,3,4}; 
		IntBSTree  bsTree =  new IntBSTree();
		
		//When
		bsTree.insert(keys[2]);
		bsTree.insert(keys[3]);
		bsTree.insert(keys[4]);
		
		//Then
		assertEquals(bsTree.root.key, keys[2]);
		assertEquals(bsTree.root.right.key, keys[3]);
		assertEquals(bsTree.root.left, null);
		assertEquals(bsTree.root.right.right.key, keys[4]);
	}
	
	@Test
	public void shouldSearchKey() {
		//Given
		int [] keys = new int[] {0,1,2,3,4}; 
		IntBSTree  bsTree =  new IntBSTree();
		bsTree.insert(keys[2]);
		bsTree.insert(keys[3]);
		bsTree.insert(keys[4]);
		bsTree.insert(keys[0]);
		bsTree.insert(keys[1]);
		
		//When
		IntBSTree.Node nodeFounded = bsTree.search(keys[3]); 
		
		//Then	
		assertEquals(keys[3], nodeFounded.key);
		assertEquals(bsTree.root, nodeFounded.parent);
	}
	
	@Test
	public void shouldlevelOrder() {
		//Given
		int [] keys = new int[] {0,1,2,3,4}; 
		IntBSTree  bsTree =  new IntBSTree();
		bsTree.insert(keys[2]);
		bsTree.insert(keys[3]);
		bsTree.insert(keys[4]);
		bsTree.insert(keys[0]);
		bsTree.insert(keys[1]);
		
		//When
		int [] keysReturned = bsTree.lavelOrder();
		
		//Then
		assertArrayEquals(new int[] {2,0,3,1,4},keysReturned);
	}
	
}
