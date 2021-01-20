package tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import trees.Node;

import static junit.framework.TestCase.assertEquals;

public class NodeTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();


  @Test
  public void nodeInstantiatedEmpty() {
    Node testNode = new Node();
    assertEquals(null,testNode.getValue());
    assertEquals(null, testNode.getLeftNode());
    assertEquals(null, testNode.getRightNode());
  }

  @Test
  public void nodeInstantiatedWithInitialValue() {
    String initialValue = "0TS";
    Node testNode = new Node(initialValue);
    assertEquals( initialValue, testNode.getValue());
    assertEquals(null, testNode.getLeftNode());
    assertEquals(null, testNode.getRightNode());
  }

  @Test public void assignValue() {
    String initialValue = "1TS";
    Node testNode = new Node(initialValue);
    String assignedValue = "2TS";

    testNode.assignValue(assignedValue);
    assertEquals( assignedValue, testNode.getValue());
  }

  @Test public void assignRightNode() throws Exception {
    Node testNode = new Node();
    Node rightNode = new Node();

    testNode.assignRight(rightNode);
    assertEquals(rightNode, testNode.getRightNode());
  }

  @Test public void circularAssignmentRight() throws Exception {
    thrown.expect(Exception.class);
    Node testNode = new Node();
    Node leftNode = new Node();

    testNode.assignLeft(leftNode);
    testNode.assignRight(leftNode);
  }

  @Test public void circularAssignmentLeft() throws Exception {
    thrown.expect(Exception.class);
    Node testNode = new Node();
    Node rightNode = new Node();

    testNode.assignRight(rightNode);
    testNode.assignLeft(rightNode);
  }

  @Test public void assignLeftNode() throws Exception {
    Node testNode = new Node();
    Node leftNode = new Node();

    testNode.assignLeft(leftNode);
    assertEquals(leftNode, testNode.getLeftNode());
  }




}
