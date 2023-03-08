package org.mps.deque;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases:
 * 1. getItem of a DequeNode with a "1" returns "1"
 * 2. getItem of a DequeNode with null returns null
 * 3. setItem with a "1" stores a "1"
 * 4. setItem with a "1" overrides the previous value stored inside the DequeNode
 * 5. getPrevious of a DequeNode with no previous element returns null
 * 6. getPrevious of a DequeNode with a previous DequeNode (not null) returns the DequeNode
 * 7. setPrevious with a DequeNode stores a DequeNode
 * 8. setPrevious with null stores a null
 * 9. setPrevious with a DequeNode overrides the value stored previously
 * 10. getNext of a DequeNode with no following element returns null
 * 11. getNext of a DequeNode with a following DequeNode (not null) returns the DequeNode
 * 12. setNext with a DequeNode stores a DequeNode
 * 13. setNext with null stores a null
 * 14. setNext with a DequeNode overrides the value stored previously
 * 15. isFirstNode of a node with no previous element returns true
 * 16. isFirstNode of a node with a previous element returns false
 * 17. isLastNode of a node with no next element returns true
 * 18. isLastNode of a node with a next element returns false
 * 19. isNotATerminalNode of a node with no previous element returns false
 * 20. isNotATerminalNode of a node with no last element returns false
 * 21. isNotATerminalNode of a node with no last nor previous element returns false
 * 22. isNotATerminalNode of a node with both previous and next elements returns true
 *
 * @author Lucia Gutierrez Molina
 */
@DisplayName("First, we create a DequeNode")
class DequeNodeTest {

    @Nested
    @DisplayName("When getting an item")
    class GetItemTest {
        @Test
        @DisplayName("If the item stored was 1, then we should obtain a 1.")
        void getItemOf1Returns1() {
            //Given
            DequeNode<Integer> createdNodeWithA1 = new DequeNode<>(1, null, null);
            //When
            int expectedGetItemValue = 1;
            int actualGetItemValue = createdNodeWithA1.getItem();
            //Then
            assertEquals(expectedGetItemValue, actualGetItemValue);
        }

        @Test
        @DisplayName("If the item stored was null, then we should obtain null.")
        void getItemOfNullReturnsNull() {
            //Given
            DequeNode<Integer> createdNodeWithNull = new DequeNode<>(null, null, null);
            //When
            Object actualGetItemValue = createdNodeWithNull.getItem();
            //Then
            assertNull(actualGetItemValue);
        }
    }

    @Nested
    @DisplayName("When setting an item")
    class SetItemTest {
        @Test
        @DisplayName("If there was no item previously stored, then the item should be stored")
        void setItemOf1Stores1() {
            //Given
            DequeNode<Integer> createdNode = new DequeNode<>(null, null, null);
            //When
            createdNode.setItem(1);
            //Then
            int expectedGetItemValue = 1;
            int actualGetItemValue = createdNode.getItem();
            assertEquals(expectedGetItemValue, actualGetItemValue);
        }

        @Test
        @DisplayName("If there was an item inside the Node, it overrides it")
        void setItemWithItemOverridesIt() {
            //Given
            DequeNode<Integer> createdNodeWithItem = new DequeNode<>(2, null, null);
            //When
            createdNodeWithItem.setItem(1);
            //Then
            int expectedGetItemValue = 1;
            int actualGetItemValue = createdNodeWithItem.getItem();
            assertEquals(expectedGetItemValue, actualGetItemValue);
        }
    }

    @Nested
    @DisplayName("When getting the previous item")
    class GetPreviousTest {
        @Test
        @DisplayName("If the previous node is set, then we should obtain it.")
        void getPreviousOf1Returns1() {
            //Given
            DequeNode<Integer> previousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNodeWithPreviousItem = new DequeNode<>(4, previousNode, null);
            //When
            DequeNode<Integer> expectedNode = previousNode;
            DequeNode<Integer> actualNode = createdNodeWithPreviousItem.getPrevious();
            //Then
            assertEquals(expectedNode, actualNode);
        }

        @Test
        @DisplayName("If the previous item is not set, then we should obtain null.")
        void getItemOfNullReturnsNull() {
            //Given
            DequeNode<Integer> createdNodeWithNull = new DequeNode<>(null, null, null);
            //When
            Object actualGetItemValue = createdNodeWithNull.getPrevious();
            //Then
            assertNull(actualGetItemValue);
        }
    }

    @Nested
    @DisplayName("When setting the previous item")
    class SetPreviousTest {
        @Test
        @DisplayName("If the previous item was not set, then the item must be set correctly.")
        void setPreviousShouldSetPreviousNode() {
            //Given
            DequeNode<Integer> previousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNodeWithPreviousItem = new DequeNode<>(4, null, null);
            //When
            createdNodeWithPreviousItem.setPrevious(previousNode);
            //Then
            DequeNode<Integer> expectedNode = previousNode;
            DequeNode<Integer> actualNode = createdNodeWithPreviousItem.getPrevious();
            assertEquals(expectedNode, actualNode);
        }

        @Test
        @DisplayName("If the previous item was set, then it should override it.")
        void setPreviousShouldOverrideLastPreviousNode() {
            //Given
            DequeNode<Integer> previousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> newPreviousNode = new DequeNode<>(2, null, null);
            DequeNode<Integer> createdNodeWithPreviousItem = new DequeNode<>(4, previousNode, null);
            //When
            createdNodeWithPreviousItem.setPrevious(newPreviousNode);
            //Then
            DequeNode<Integer> expectedNode = newPreviousNode;
            DequeNode<Integer> actualNode = createdNodeWithPreviousItem.getPrevious();
            assertEquals(expectedNode, actualNode);
        }
    }

    @Nested
    @DisplayName("When getting the next item")
    class GetNextTest {
        @Test
        @DisplayName("If the next item is 1, then we should obtain a 1.")
        void getNextShouldReturnNextNode() {
            //Given
            DequeNode<Integer> nextNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNodeWithNextItem = new DequeNode<>(4, null, nextNode);
            //When
            DequeNode<Integer> expectedNode = nextNode;
            DequeNode<Integer> actualNode = createdNodeWithNextItem.getNext();
            //Then
            assertEquals(expectedNode, actualNode);
        }

        @Test
        @DisplayName("If the next item is not set, then we should obtain null.")
        void getNextOfNullReturnsNull() {
            //Given
            DequeNode<Integer> createdNodeWithNull = new DequeNode<>(null, null, null);
            //When
            DequeNode<Integer> actualGetItemValue = createdNodeWithNull.getNext();
            //Then
            assertNull(actualGetItemValue);
        }
    }

    @Nested
    @DisplayName("When setting the next item")
    class SetNextTest {
        @Test
        @DisplayName("If the next node was not set, then the item must be set correctly.")
        void setNextShouldSetNextNode() {
            //Given
            DequeNode<Integer> nextNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNodeWithPreviousItem = new DequeNode<>(4, null, null);
            //When
            createdNodeWithPreviousItem.setNext(nextNode);
            //Then
            DequeNode<Integer> expectedNode = nextNode;
            DequeNode<Integer> actualNode = createdNodeWithPreviousItem.getNext();
            assertEquals(expectedNode, actualNode);
        }

        @Test
        @DisplayName("If the next node was set, then it should override it.")
        void setNextShouldOverridePreviousNextNode() {
            //Given
            DequeNode<Integer> nextNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> newNextNode = new DequeNode<>(2, null, null);
            DequeNode<Integer> createdNodeWithPreviousItem = new DequeNode<>(4, null, nextNode);
            //When
            createdNodeWithPreviousItem.setNext(newNextNode);
            //Then
            DequeNode<Integer> expectedGetItemValue = newNextNode;
            DequeNode<Integer> actualGetItemValue = createdNodeWithPreviousItem.getNext();
            assertEquals(expectedGetItemValue, actualGetItemValue);
        }
    }

    @Nested
    @DisplayName("When is first node is called")
    class IsFirstNode {
        @Test
        @DisplayName("if it has no next nor previous elements should return true")
        void isFirstOfEmptyNodeReturnsTrue() {
            //Given
            DequeNode<Integer> createdNode = new DequeNode<>(4, null, null);
            //Then
            assertTrue(createdNode.isFirstNode());
        }

        @Test
        @DisplayName("if it has a next element but no previous element should return true")
        void isFirstOfNodeWithNextElementReturnsFalse() {
            //Given
            DequeNode<Integer> createdNextNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, null, createdNextNode);
            //Then
            assertTrue(createdNode.isFirstNode());
        }

        @Test
        @DisplayName("if it has a previous element but no next element should return false")
        void isFirstOfNodeWithPreviousElementReturnsTrue() {
            //Given
            DequeNode<Integer> createdPreviousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, createdPreviousNode, null);
            //Then
            assertFalse(createdNode.isFirstNode());
        }

        @Test
        @DisplayName("if it has both previous and next element should return false")
        void isFirstOfNodeWithPreviousAndNextElementReturnsFalse() {
            //Given
            DequeNode<Integer> createdPreviousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNextNode = new DequeNode<>(2, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, createdPreviousNode, createdNextNode);
            //Then
            assertFalse(createdNode.isFirstNode());
        }
    }

    @Nested
    @DisplayName("When is last node is called")
    class IsLastNode {
        @Test
        @DisplayName("if it has no next nor previous elements should return true")
        void isLastOfEmptyNodeReturnsTrue() {
            //Given
            DequeNode<Integer> createdNode = new DequeNode<>(4, null, null);
            //Then
            assertTrue(createdNode.isLastNode());
        }

        @Test
        @DisplayName("if it has a next element but no previous element should return false")
        void isLastOfNodeWithNextElementReturnsFalse() {
            //Given
            DequeNode<Integer> createdNextNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, null, createdNextNode);
            //Then
            assertFalse(createdNode.isLastNode());
        }

        @Test
        @DisplayName("if it has a previous element but no next element should return true")
        void isLastOfNodeWithPreviousElementReturnsTrue() {
            //Given
            DequeNode<Integer> createdPreviousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, createdPreviousNode, null);
            //Then
            assertTrue(createdNode.isLastNode());
        }

        @Test
        @DisplayName("if it has both previous and next element should return false")
        void isLastOfNodeWithPreviousAndNextElementReturnsFalse() {
            //Given
            DequeNode<Integer> createdPreviousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNextNode = new DequeNode<>(2, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, createdPreviousNode, createdNextNode);
            //Then
            assertFalse(createdNode.isLastNode());
        }
    }

    @Nested
    @DisplayName("When is not terminal node is called")
    class IsNotTerminalNode {
        @Test
        @DisplayName("if it has no next nor previous elements should return false")
        void isNotATerminalNodeOfEmptyNodeReturnsFalse() {
            //Given
            DequeNode<Integer> createdNode = new DequeNode<>(4, null, null);
            //Then
            assertFalse(createdNode.isNotATerminalNode());
        }

        @Test
        @DisplayName("if it has a next element but no previous element should return false")
        void isNotATerminalNodeWithNextElementReturnsFalse() {
            //Given
            DequeNode<Integer> createdNextNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, null, createdNextNode);
            //Then
            assertFalse(createdNode.isNotATerminalNode());
        }

        @Test
        @DisplayName("if it has a previous element but no next element should return false")
        void isNotATerminalNodeWithPreviousElementReturnsTrue() {
            //Given
            DequeNode<Integer> createdPreviousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, createdPreviousNode, null);
            //Then
            assertFalse(createdNode.isNotATerminalNode());
        }

        @Test
        @DisplayName("if it has both previous and next element should return true")
        void isNotATerminalNodeWithPreviousAndNextElementReturnsFalse() {
            //Given
            DequeNode<Integer> createdPreviousNode = new DequeNode<>(1, null, null);
            DequeNode<Integer> createdNextNode = new DequeNode<>(2, null, null);
            DequeNode<Integer> createdNode = new DequeNode<>(4, createdPreviousNode, createdNextNode);
            //Then
            assertTrue(createdNode.isNotATerminalNode());
        }
    }

}