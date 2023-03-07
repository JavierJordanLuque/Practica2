package org.mps.deque;

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
class DequeNodeTest {

}