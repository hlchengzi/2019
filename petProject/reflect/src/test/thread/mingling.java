package test.thread;

/**
 * 抽象命令接口
 */
interface ICommand{
    public void sweep();

}

/**
 * 命令接收者
 */
class student{
    public void sweep(){
        System.out.println("student sweeping");
    }

}

/**
 * 命令发送者
 */

class Teacher implements ICommand{
    private student receiver = null;
    public Teacher(student receiver){
        this.receiver = receiver;
    }
    public void sweep() {
        this.receiver.sweep();
    }

}

/**
 * 命令模式当中最重要的 Invoke 命令请求者类
 */
class Invoke{
    ICommand command;
    public Invoke(ICommand command){
        this.command =command;
    }

    public void executeM(){
        command.sweep();//启动方法
    }
}
public class mingling {
    /**
     * 将一个请求封装成一个对象，从而使用户可用不同的请求对客户进行参数化；对请求排对或记录请求日志，以及支持可插销的操作
     * 字如其名，命令模式就是命令发送者 通过发送不同都明令，使命令接受者完成任务。简单的老师发送给学生命令，让学生完成
     */

}
