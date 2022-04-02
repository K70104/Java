import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) {
        //通过callable来描述一个这样的任务~~
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++){
                    sum += i;
                }
                return sum;
            }
        };
        //为了让线程执行 callable中的任务，光使用构造方法还不够，还需要一个辅助的类.
        FutureTask<Integer> task = new FutureTask<>(callable);
        //创建线程,来完成这里的大算工作
        Thread t = new Thread(task);
        t.start();

        // 凭小票去获取自己地麻辣烫
        // 如果线程的任务没有完成，get 就会阻塞，一直到任务完成了，结果算出来了
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
