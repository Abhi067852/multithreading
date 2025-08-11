
States of thread

World t1 = new Worlds // NEW state
t1.start  //RUNNABLE
// it will be in runnning state after this
// blocked when it is waiting for resource
// terminate when the task is completed 

implement runnable when you have to go for multiple inheritance


thread method
sleep
run
start()
join()
t1.setPriority()  // to set the priority of thread give the hint to jvm to set the priority 
naming the thread
create a new constructor of thread class
interrupted()  // interupt the state of thread whatever it is doing it just interrupts
yield()   // a hint to scheduler to give chance to other thread gives us more random result
setDaemon()   // DAEMON_THREAD that runs in background like garbage collector jvm will not wait for DAEMON_THREAD


Syncronization
syncronized block ensures mutual exclusion thus two thread can't access critical resource at same time
it puts the lock on critical section

Locks type

intinsic lock they are automatic lock build into every object in java syncronized keyword also uses this
explicit they are more advanced lock you can control yourseld the lock class from java.util.concurrent.locks.
we can explicitly decide when to apply lock and when to not apply it.


Lock is an interface
Lock lock = new ImplementationClass  //new ReentrantLock()

lock.lock();
lock.tryLock();  // we can also add time in this lock
lock.unlock();
lock.intreptuly() // when we interept the existing thread

Reeentrant lock helps in deadlock prevention

we can pass fairness to acquire lock in an order only  //new ReentrantLock(true) everyone will get chance to acquire the lock of resource and no starvation of thread

//syncronized disadvantage

fairness
blocking 
interruptability
read/write locking


ReadWriteLock
allow multile threads to read concurrently when no one writing and ensure exlusive locking for write
helps to prevent unnecesary locking


DEADLOCK
mutual exclusion
hold and wait
no premption
circular wait



