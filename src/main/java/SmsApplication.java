import common.DummyData;
import view.Loginframe;

public class SmsApplication {

    public static void main(String[] args){
        DummyData dummydata = new DummyData();
        dummydata.init();
        new Loginframe(dummydata).setVisible(true);
    }
}
