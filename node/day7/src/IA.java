

abstract class B {
    public abstract void fun();
}

abstract class C extends B{
    public abstract void fun2();
}

abstract class D extends C{
    public abstract void fun3();
}

class E extends D {

    @Override
    public void fun() {

    }

    @Override
    public void fun2() {

    }

    @Override
    public void fun3() {

    }
}

public interface IA {
    public void main(String[] args);
    void test();
}
