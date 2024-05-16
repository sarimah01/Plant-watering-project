# Plant-watering-project

INTRODUCTION

The purpose of this project is to create an automated system that can water a plant. I plan to do
this using my laptop (java) and an Arduino board, MOSFET and a water pump. The system will
be capable of running over multiple days and should only pump water to the plant when the soil
is dry.

CONTEXT

The system is supposed to be an automated plant watering system that can operate without any
need for human interference. As a person taking care of a plant, you may not always remember
to water the plant so this system should be able to help you water your plant when needed so it
doesn't die.

TECHNICAL REQUIREMENTS / SPECIFICATIONS

The system has been programmed to read moisture values from the moisture sensor that is
connected to the Arduino. Based on the moisture value when the sensor is wet or dry, the
system will pump water to the plant or will display on the OLED that the soil is wet and the pump
will remain turned off.

COMPONENTS LIST

● Arduino board: Connects to the laptop which runs the program.

● Plant: To be watered

● 9V battery: Powers the pump via the MOSFET board

● Water pump: Pumps water from the water supply to plant

● MOSFET board: Connects the water pump and battery to the Arduino board.

● Moisture sensor: Reads moisture value and sends information to the Arduino.

PROCEDURE

For the setup of the project, I used an Arduino board, MOSFET board, moisture sensor, plant
and a water pump. I connected the moisture sensor to port A0 on the Arduino board and
connected the MOSFET board to port D7 on the Arduino. To connect the moisture sensor to the
Arduino I switched the white and yellow wires on the connecting cord before plugging it in. Then
I connected a 9V battery and the water pump to the MOSFET board. I placed the moisture
sensor in the soil of the plant and connected my Arduino board to my laptop. On my laptop, I
established a connection with the Arduino board using java by importing firmata4j from the
maven library and used this connection to program the Arduino board. After writing the code for
the program I did several tests to ensure that the code worked and had no errors.

TEST

While the program runs the OLED displays the moisture level and soil condition and depending
on the moisture level it will either pump water or display that the soil is wet. To test what
happens when the soil is wet, I placed the moisture sensor in wet soil and the OLED displayed
the moisture level and that the soil is wet. I removed the moisture sensor from the wet soil and
dried it with a dry cloth, the OLED then displayed the moisture level and the message “water
pumping” while the water pumped to the plant. Then I put the moisture sensor back in the wet
soil and the water pump stopped, the OLED displayed the moisture level and that the soil is wet.

CONCLUSION

Using Java and Arduino I was able to program a system that waters a plant over multiple days
as is needed for plant growth. The system works but needs to be connected to the laptop at all
times to function so it might not be the most efficient system to monitor and water a plant.
