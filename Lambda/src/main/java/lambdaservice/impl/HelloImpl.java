package lambdaservice.impl;

import lambdaservice.Hello;

public class HelloImpl implements Hello {
    @Override
    public void hello() {
        System.out.println("hello");
    }
}
