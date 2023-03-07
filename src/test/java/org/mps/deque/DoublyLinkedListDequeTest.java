package org.mps.deque;

<<<<<<< HEAD
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Test Cases
    1. Prepend {1} in an empty DoublyLinkedListDeque -> Element {1} is first and last
    2. Prepend {2} in a non-empty DoublyLinkedListDeque with one element {10} -> Element {2} is first and {10} is last
    3. Append {3} in of an empty DoublyLinkedListDeque -> Element {3} is first and last
    4. Append {4} in a non-empty DoublyLinkedListDeque with one element {11} -> Element {11} is first and {4} is last
    5. Delete first element of an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    6. Delete first element of a non-empty DoublyLinkedListDeque with one element {6} -> Empty DoublyLinkedListDeque
    7. Delete first element of a non-empty DoublyLinkedListDeque with two elements {7, 8} -> Element {8} is first and last
    8. Delete last element of an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    9. Delete last element of a non-empty DoublyLinkedListDeque with one element {9} -> Empty DoublyLinkedListDeque
    10. Delete last element of a non-empty DoublyLinkedListDeque with two elements {10, 11} -> Element {10} is first and last
    11. First element of an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    12. First element of a non-empty DoublyLinkedListDeque with two elements {12, 13} -> Returns element {12}
    13. Last element of an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    14. Last element of a non-empty DoublyLinkedListDeque with two elements {14, 15} -> Returns element {15}
    15. Size of an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    16. Size of a non-empty DoublyLinkedListDeque with two elements {12, 13} -> Returns 2
     */

=======
>>>>>>> b5c718ab8d4a10d308a82f587ecd3ac4abb68131
class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedListDeque<Integer>();
    }

    @AfterEach()
    void shutDown() {
        list = null;
    }

    @Test
    void prependInAnEmptyDoublyLinkedListDeque() {
        list.prepend(1);
        int firstValue = list.first();
        int lastValue = list.last();
        assertEquals(firstValue, 1);
        assertEquals(lastValue, 1);
    }

    @Test
    void prependInANonEmptyDoublyLinkedListDeque() {
        list.prepend(10);
        list.prepend(2);
        int firstValue = list.first();
        int lastValue = list.last();
        assertEquals(firstValue, 2);
        assertEquals(lastValue, 10);
    }
}