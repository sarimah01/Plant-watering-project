import	org.firmata4j.Pin;
import	org.firmata4j.ssd1306.SSD1306;
import	java.io.IOException;
import	java.util.Timer;
import	java.util.TimerTask;
public class MinorTask extends TimerTask {
    private	final SSD1306 theOled;
    private	final Pin MoisturePin 	;
    private final Pin WaterPin ;
    private	final Timer myTimer;
    public MinorTask (SSD1306	theOled, Pin	MoisturePin, Pin WaterPin, 	Timer myTimer){
        this.theOled = theOled;
        this.MoisturePin = MoisturePin;
        this.WaterPin = WaterPin;
        this.myTimer = myTimer;
    }
    @Override
    public	void	run()	{
        var soilWet = 680;
        var soilDry = 700;
        boolean stop = false;
        try{
            while (!stop){
                var moistureValue = MoisturePin.getValue();
                theOled.clear();
                theOled.getCanvas().setTextsize(1);
                theOled.getCanvas().drawString(0,0, "The moisture level is " + moistureValue);
                theOled.display();
                if (moistureValue > soilDry){
                    theOled.clear();
                    theOled.getCanvas().setTextsize(1);
                    theOled.getCanvas().drawString(0,0, "The moisture level is " + moistureValue + " Pumping water");
                    theOled.display();
                    WaterPin.setValue(1);
                }
                else if (moistureValue > soilWet){//
                    theOled.clear();
                    theOled.getCanvas().setTextsize(1);
                    theOled.getCanvas().drawString(0,0, "The moisture level is " + moistureValue + " Pumping water");
                    theOled.display();
                    WaterPin.setValue(1);
                }
                else if (moistureValue <= soilWet){
                    theOled.clear();
                    theOled.getCanvas().setTextsize(1);
                    theOled.getCanvas().drawString(0,0, "The moisture level is " + moistureValue + " Soil wet");
                    theOled.display();
                    WaterPin.setValue(0);
                }
                else{
                    System.out.println(moistureValue);
                    stop = true;
                }
              

         }
        }
        catch (IOException ex){
            System.out.println("error!");
        }
    }
}
