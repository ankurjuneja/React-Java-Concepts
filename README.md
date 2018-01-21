# About
My interview preparation JAVA.
This repository contains programns implementing various searching, sorting, data structures and other algorithms in Java.

### Multithreading | Concurrency | Thread Safety
When a variable or piece of code is shared by multiple threads, there is a need for thread safe code for its correct execution i.e. the concept of correctness. Threads are lightweight process that allow multiple streams of program flow to co-exist with in a process.

Thread safe classes behave corectly when accessed from mulitple threads and encapsulate any needed synchronization.

Stateless objects(that have no fields and no reference to fields from other classes) are thread safe as they have their own stack(of local variables).

#### **1. Atomicity**
A single, indivisible operation.

```
@not atomic
long count;
++count; // this is not atomic, its an example of read-modify-write
```

##### **1.1 Race condition**
occurs when two or more threads access same code and their operations are time interleaved.

Ex:
Race conditions in lazy initialization-
goal- defer intializing an object until it is actually needed while at the same time ensuring that it is initialized only once.
```
//following is an example of check-then-act
public class MyClass {
  private SingleObject so = null;
  
  public SingleObject getInstance()
  {
    if (so==null)
      so = new SingleObject();
    return so;
  }
}
```
Above code causes race condition when two threads A and B try to getInstance at same time.

Race conditions can be avoided by making the operations atomic i.e. by using thread-safe classes (classes inside package java.util.concurrent.atomic). Solution for above read-modify-write example would be to use AtomicLong and incrementAndGet method.

P.S where ever possible, use thread safe objects to manage your class's state.

#### **2. Locking**
Related state variables need to be updated in single atomic operation to preserve consistency.
