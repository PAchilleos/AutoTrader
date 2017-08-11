import java.util.concurrent.TimeUnit;

public class PSE {

    public void t(int x){
        try {
            TimeUnit.SECONDS.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
