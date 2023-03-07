package org.mps.deque;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
            DequeNode<Integer> createdNodeWithA1 = new DequeNode<>(1, null, null);
            int expectedGetItemValue = 1;
            int actualGetItemValue = createdNodeWithA1.getItem();
            assertEquals(expectedGetItemValue, actualGetItemValue);
        }

        @Test
        @DisplayName("If the item stored was null, then we should obtain null.")
        void getItemOfNullReturnsNull() {
            DequeNode<Integer> createdNodeWithNull = new DequeNode<>(null, null, null);
            Object actualGetItemValue = createdNodeWithNull.getItem();
            assertNull(actualGetItemValue);
        }
    }

    @Nested
    @DisplayName("When setting an item")
    class SetItemTest {
        @Test
        @DisplayName("If there was no item previously stored and a 1 is set, then a 1 should be stored")
        void setItemOf1Stores1() {
            DequeNode<Integer> createdNode = new DequeNode<>(null, null, null);
            createdNode.setItem(1);
            int expectedGetItemValue = 1;
            int actualGetItemValue = createdNode.getItem();
            assertEquals(expectedGetItemValue, actualGetItemValue);
        }

        @Test
        @DisplayName("If there was an item inside the Node, it overrides it")
        void setItemWithItemOverridesIt() {
            DequeNode<Integer> createdNodeWithItem = new DequeNode<>(2, null, null);
            createdNodeWithItem.setItem(1);
            int expectedGetItemValue = 1;
            int actualGetItemValue = createdNodeWithItem.getItem();
            assertEquals(expectedGetItemValue, actualGetItemValue);
        }
    }
}