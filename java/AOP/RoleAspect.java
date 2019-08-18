package test.AOP;

public class RoleAspect {
    public void before(){
        System.out.println("before ......");
    }
    public void after(){
        System.out.println("after......");
    }
    public void afterReturn(){
        System.out.println("afterReturn");
    }
    public void afterThrowing(){
        System.out.println("afterThrowing");
    }
}
