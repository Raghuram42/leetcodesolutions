class Foo {
    
    private AtomicInteger f = new AtomicInteger(0);
    private AtomicInteger s = new AtomicInteger(0);
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
         f.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
      while(f.get() != 1){
      }
          
        
        // printSecond.run() outputs "second". Do not change or remove this line.

        printSecond.run();
        f.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
            while(f.get() != 2){
      }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}