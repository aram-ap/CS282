
# CS282-Advanced Data Structures

This repo is a collection of code from programs made in this class.

---

## How to run these:

These all run using Gradle with Java 21. You can run it simply by typing in the terminal:<br>
```
git clone https://www.github.com/aram-ap/CS282
cd /path/to/repo
cd <project folder name>
```

and either:<br>
```
sh gradlew run
```
or if you have gradle installed already,<br>
```
gradle run
```

---

### Lists - Review program on Lists, ordered and unordered:<br>
- ``NumericList<T extends Number>``: list interface of generic Number. Contains ``size()``, ``isFull()``, ``isEmpty()``, ``insert(Number)``, ``delete(Number)``, ``search(Number)``, and ``display()`` functions.
- ``OrderedNumericList<T extends Number>``: All list functions, but inserts in sorted order, contains merge function, searches with binary search, and contains an array expansion function.
- ``UnorderedNumericList<T extends Number>``: All list functions with an expansion funciton added to it. Items are added in unsorted order, and searches using linear search.

### Deque - Doubly ended queue:<br>
A deque is somewhat an abstract generalization of a queue for which you can add elements to the 'head' (front) or 'tail' (back).<br>
Its operations are: <br>
- ``insertLeft()``: which inserts a value on the left, or tail end.
- ``insertRight()``: which inserts a value on the right, or head.
- ``deleteLeft()``/``deleteRight()``: as the name implies, deletes from the left/right end.
- ``isEmpty()``/``isFull()``: checks if the list is empty or full.

### Stack - Stack based on a Deque:<br>
As its name implies, this is a stack which utilizes the Deque class.
Its operations are: <br>
- ``push()``: puts an item in the stack.
- ``pop()``: removes the head item and returns its value.
- ``peek()``: returns the value of the head item.

### Circular Linked List - A linked list with no head or tail reference, just the current:<br>
This class is different from a regular linked list as there is no starting/ending point to the list. Each element has a reference to another node.
Its operations are: <br>
- ``insert(int val)``: which inserts a value at the current position.
- ``delete()``: which deletes the downstream node from current and returns its value.
- ``step()``: which moves current node reference to the next.
- ``display()``: which prints the contents of the list by stepping through each item in it full-circle (no pun intended).
