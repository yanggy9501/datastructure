package com.app.tools.datastruct.test.tree;

import com.app.tools.datastruct.datamodule.AlvTree;
import com.app.tools.datastruct.datamodule.BinarySortTree;
import com.app.tools.datastruct.datamodule.binarytree.BinaryTreeNode;
import com.app.tools.datastruct.helper.BinaryTreeHelper;
import org.junit.Test;

/**
 * @author yanggy
 */
public class BalanceBinaryTreeTest {
    /*
                     6
                  /     \
                1        10
              /   \     /   \
            -5     3    9    11
                    \
                     4
     */

    private AlvTree<Integer> createBalancedBinarySortTree() {
        AlvTree<Integer> ALVBinaryTree = new AlvTree<>(Integer::compare);
        ALVBinaryTree.add(6);
        ALVBinaryTree.add(1);
        ALVBinaryTree.add(3);
        ALVBinaryTree.add(10);
        ALVBinaryTree.add(-5);
        ALVBinaryTree.add(4);
        ALVBinaryTree.add(9);
        ALVBinaryTree.add(11);

        return ALVBinaryTree;
    }

    /*
                     6
                  /     \
                1        10
              /   \     /   \
            -5     3    9    11
                    \
                     4
     */

    private BinarySortTree<Integer> createBinarySortTree() {
        BinarySortTree<Integer> binarySortTree = new BinarySortTree<>(Integer::compare);
        binarySortTree.add(6);
        binarySortTree.add(1);
        binarySortTree.add(3);
        binarySortTree.add(10);
        binarySortTree.add(-5);
        binarySortTree.add(4);
        binarySortTree.add(9);
        binarySortTree.add(11);

        binarySortTree.add(5);
        binarySortTree.add(12);

        return binarySortTree;
    }

    @Test
    public void testCreatBinarySortTree() {
        AlvTree<Integer> ALVBinaryTree = createBalancedBinarySortTree();
        BinaryTreeNode<Integer> node = ALVBinaryTree.search(1);
        int treeHeight = BinaryTreeHelper.getHeight(node);
        System.out.println(treeHeight);
    }

    @Test
    public void testBalanced() {
        BinarySortTree<Integer> binarySortTree = createBinarySortTree();
        BinaryTreeNode<Integer> node = binarySortTree.search(111);
        System.out.println(BinaryTreeHelper.isBalance(node));
    }
    
    /*
         6                      10
           \                  /    \
            10               6      11
             \                       \
                                      12
                                       \
     */

    private AlvTree<Integer> createLeftRotateBalancedBinaryTree() {
        AlvTree<Integer> ALVBinaryTree = new AlvTree<>(Integer::compare);
        ALVBinaryTree.add(6);
        ALVBinaryTree.add(10);
        ALVBinaryTree.add(11);
        ALVBinaryTree.add(12);
        ALVBinaryTree.add(13);
        return ALVBinaryTree;
    }
    
    @Test
    public void testLeftRotate() {
        AlvTree<Integer> ALVBinaryTree = createLeftRotateBalancedBinaryTree();
        System.out.println(ALVBinaryTree.getRoot());
    }

    /*
                        6               5                       5
                      /               /   \                   /    \
                     5              4       6               3       6
                    /                                      /  \
                                                          2    4

     */

    private AlvTree<Integer> createRightRotateBalancedBinaryTree() {
        AlvTree<Integer> ALVBinaryTree = new AlvTree<>(Integer::compare);
        ALVBinaryTree.add(6);
        ALVBinaryTree.add(5);
        ALVBinaryTree.add(4);

        ALVBinaryTree.add(3);
        ALVBinaryTree.add(2);
        return ALVBinaryTree;
    }

    @Test
    public void testRightRotate() {
        AlvTree<Integer> ALVBinaryTree = createRightRotateBalancedBinaryTree();
        System.out.println(ALVBinaryTree.getRoot());
        System.out.println(BinaryTreeHelper.isBalance(ALVBinaryTree));
    }

    /*
                       20               10                       10                         10                      8
                      /               /    \                   /    \                     /    \                  /    \
                     10              5      20               5       20      ====>        8     20       ===>    5      10
                    /                                       /   \                      /   \                   /      /    \
                                                          -5     8                    5     9               -5       9      20
                                                                   \                 /                                       \
                                                                    9              -5                                          30
     */

    private AlvTree<Integer> createBalancedBinaryTree() {
        AlvTree<Integer> ALVBinaryTree = new AlvTree<>(Integer::compare);
        ALVBinaryTree.add(20);
        ALVBinaryTree.add(10);
        ALVBinaryTree.add(5);

        ALVBinaryTree.add(8);
        ALVBinaryTree.add(-5);

        ALVBinaryTree.add(9);
        ALVBinaryTree.add(30);


        return ALVBinaryTree;
    }

    @Test
    public void testRotate() {
        AlvTree<Integer> ALVBinaryTree = createBalancedBinaryTree();
        System.out.println("------------");
        System.out.println(BinaryTreeHelper.isBalance(ALVBinaryTree));
        ALVBinaryTree.infixOrder(System.out::println);
    }

    @Test
    public void testDel() {
        AlvTree<Integer> ALVBinaryTree = createBalancedBinaryTree();
        ALVBinaryTree.delete(8);
        System.out.println(BinaryTreeHelper.isBalance(ALVBinaryTree));
        ALVBinaryTree.infixOrder(System.out::println);
    }

    @Test
    public void testRm() {
        AlvTree<Integer> ALVBinaryTree = createBalancedBinaryTree();

        ALVBinaryTree.remove(node -> node.getData().equals(10));
        System.out.println(BinaryTreeHelper.isBalance(ALVBinaryTree));
        ALVBinaryTree.infixOrder(System.out::println);
    }
}
