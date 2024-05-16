import org.firmata4j.Pin;
import org.firmata4j.firmata.*;
import org.firmata4j.IODevice;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.I2CDevice;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Minor_ver2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        String myPort = "/dev/cu.usbserial-0001";
        IODevice myGroveBoard = new FirmataDevice(myPort);
        myGroveBoard.start();
        myGroveBoard.ensureInitializationIsDone();
        //OLED
        I2CDevice i2cObject = myGroveBoard.getI2CDevice((byte) 0x3C); // Use 0x3C for the Grove OLED
        SSD1306 theOledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64); // 128x64 OLED SSD1515
        theOledObject.init();
        //water pump
        var WaterPump = myGroveBoard.getPin(7);
        WaterPump.setMode(Pin.Mode.OUTPUT);
        //moisture sensor
        var moistureSensor = myGroveBoard.getPin(15);
        moistureSensor.setMode(Pin.Mode.ANALOG);
        var timer = new Timer();
        TimerTask myTimer = new MinorTask(theOledObject, moistureSensor,WaterPump, timer);
        new Timer().schedule(myTimer, 0, 258000000);

    }
}
