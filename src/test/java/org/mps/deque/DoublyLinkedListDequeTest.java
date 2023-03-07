package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/* Test Cases
    1. Prepend {1} in an empty DoublyLinkedListDeque -> First = 1, Last = 1, Size = 1
    2. Prepend {2} in a non-empty DoublyLinkedListDeque with one element {10} -> First = 2, Last = 10, Size = 2
    3. Append {3} in of an empty DoublyLinkedListDeque -> First = 3, Last = 3, Size = 1
    4. Append {4} in a non-empty DoublyLinkedListDeque with one element {11} -> First = 11, Last = 4, Size = 2
    5. Delete first element from an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    6. Delete first element from a non-empty DoublyLinkedListDeque {6, 7} -> First = 7, Last = 7, Size = 1
    7. Delete last element from an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    8. Delete last element from a non-empty DoublyLinkedListDeque with two elements {8, 9} -> First = 8, Last = 8, Size = 1
    9. First element from an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    10. First element from a non-empty DoublyLinkedListDeque with two elements {10, 11} -> First = 10, Size = 2
    11. Last element from an empty DoublyLinkedListDeque -> DoubleEndedQueueException
    12. Last element from a non-empty DoublyLinkedListDeque with two elements {12, 13} -> Last = 13, Size = 2
    13. Size of an empty DoublyLinkedListDeque -> Size = 0
    14. Size of a non-empty DoublyLinkedListDeque with two elements {14, 15, 16, 17} -> Size = 4
     */

@DisplayName("DoublyLinkedListDeque tests")
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

    @Nested
    @DisplayName("when trying to prepend")
    class PrependTest {
        @Test
        @DisplayName("in an empty DoublyLinkedListDeque")
        void prependInAnEmptyDoublyLinkedListDeque() {
            list.prepend(1);

            int obtainedFirst = list.first();
            int expectedFirst = 1;
            assertEquals(expectedFirst, obtainedFirst);

            int obtainedLast = list.last();
            int expectedLast = 1;
            assertEquals(expectedLast, obtainedLast);

            int obtainedSize = list.size();
            int expectedSize = 1;
            assertEquals(expectedSize, obtainedSize);
        }

        @Test
        @DisplayName("in a non-empty DoublyLinkedListDeque")
        void prependInANonEmptyDoublyLinkedListDeque() {
            list.append(10);
            list.prepend(2);

            int obtainedFirst = list.first();
            int expectedFirst = 2;
            assertEquals(expectedFirst, obtainedFirst);

            int obtainedLast = list.last();
            int expectedLast = 10;
            assertEquals(expectedLast, obtainedLast);

            int obtainedSize = list.size();
            int expectedSize = 2;
            assertEquals(expectedSize, obtainedSize);
        }
    }

    @Nested
    @DisplayName("when trying to append")
    class AppendTest {

        @Test
        @DisplayName("in an empty DoublyLinkedListDeque")
        void appendInAnEmptyDoublyLinkedListDeque() {
            list.append(3);

            int obtainedFirst = list.first();
            int expectedFirst = 3;
            assertEquals(expectedFirst, obtainedFirst);

            int obtainedLast = list.last();
            int expectedLast = 3;
            assertEquals(expectedLast, obtainedLast);

            int obtainedSize = list.size();
            int expectedSize = 1;
            assertEquals(expectedSize, obtainedSize);
        }

        @Test
        @DisplayName("in a non-empty DoublyLinkedListDeque")
        void appendInANonEmptyDoublyLinkedListDeque() {
            list.append(11);
            list.append(4);

            int obtainedFirst = list.first();
            int expectedFirst = 11;
            assertEquals(expectedFirst, obtainedFirst);

            int obtainedLast = list.last();
            int expectedLast = 4;
            assertEquals(expectedLast, obtainedLast);

            int obtainedSize = list.size();
            int expectedSize = 2;
            assertEquals(expectedSize, obtainedSize);
        }
    }

    @Nested
    @DisplayName("when trying to delete first element")
    class DeleteFirstTest {
        @Test
        @DisplayName("from an empty DoublyLinkedListDeque")
        void deleteFirstFromAnEmptyDoublyLinkedListDeque() {
            assertThrows(DoubleEndedQueueException.class, () -> list.deleteFirst());
        }

        @Test
        @DisplayName("from a non-empty DoublyLinkedListDeque")
        void deleteFirstFromANonEmptyDoublyLinkedListDeque() {
            list.append(6);
            list.append(7);
            list.deleteFirst();

            int obtainedFirst = list.first();
            int expectedFirst = 7;
            assertEquals(expectedFirst, obtainedFirst);

            int obtainedLast = list.last();
            int expectedLast = 7;
            assertEquals(expectedLast, obtainedLast);

            int obtainedSize = list.size();
            int expectedSize = 1;
            assertEquals(expectedSize, obtainedSize);
        }
    }

    @Nested
    @DisplayName("when trying to delete last element")
    class DeleteLastTest {
        @Test
        @DisplayName("from an empty DoublyLinkedListDeque")
        void deleteLastFromAnEmptyDoublyLinkedListDeque() {
            assertThrows(DoubleEndedQueueException.class, () -> list.deleteLast());
        }

        @Test
        @DisplayName("from a non-empty DoublyLinkedListDeque")
        void deleteLastFromANonEmptyDoublyLinkedListDeque() {
            list.prepend(8);
            list.append(9);
            list.deleteLast();

            int obtainedFirst = list.first();
            int expectedFirst = 8;
            assertEquals(expectedFirst, obtainedFirst);

            int obtainedLast = list.last();
            int expectedLast = 8;
            assertEquals(expectedLast, obtainedLast);

            int obtainedSize = list.size();
            int expectedSize = 1;
            assertEquals(expectedSize, obtainedSize);
        }
    }

    @Nested
    @DisplayName("when trying to obtain the first element")
    class FirstTest {
        @Test
        @DisplayName("from an empty DoublyLinkedListDeque")
        void firstFromAnEmptyDoublyLinkedListDeque() {
            assertThrows(DoubleEndedQueueException.class, () -> list.first());
        }

        @Test
        @DisplayName("from a non-empty DoublyLinkedListDeque")
        void firstFromANonEmptyDoublyLinkedListDeque() {
            list.append(10);
            list.append(11);

            int obtainedFirst = list.first();
            int expectedFirst = 10;
            assertEquals(expectedFirst, obtainedFirst);

            int obtainedSize = list.size();
            int expectedSize = 2;
            assertEquals(expectedSize, obtainedSize);
        }
    }

    @Nested
    @DisplayName("when trying to obtain the last element")
    class LastTest {
        @Test
        @DisplayName("from an empty DoublyLinkedListDeque")
        void lastFromAnEmptyDoublyLinkedListDeque() {
            assertThrows(DoubleEndedQueueException.class, () -> list.last());
        }

        @Test
        @DisplayName("from a non-empty DoublyLinkedListDeque")
        void lastFromANonEmptyDoublyLinkedListDeque() {
            list.append(12);
            list.append(13);

            int obtainedLast = list.last();
            int expectedLast = 13;
            assertEquals(expectedLast, obtainedLast);

            int obtainedSize = list.size();
            int expectedSize = 2;
            assertEquals(expectedSize, obtainedSize);
        }
    }

    @Nested
    @DisplayName("when trying to obtain the size")
    class SizeTest {
        @Test
        @DisplayName("of an empty DoublyLinkedListDeque")
        void sizeOfAnEmptyDoublyLinkedListDeque() {
            int obtainedValue = list.size();
            int expectedValue = 0;
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("of a non-empty DoublyLinkedListDeque")
        void sizeOfANonEmptyDoublyLinkedListDeque() {
            list.append(14);
            list.append(15);
            list.append(16);
            list.append(17);

            int obtainedValue = list.size();
            int expectedValue = 4;
            assertEquals(expectedValue, obtainedValue);
        }
    }
}