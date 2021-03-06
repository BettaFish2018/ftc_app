package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot;

public class Lift {
	Robot r = new Robot();
	Gamepad gp1, gp2;

	public Lift(HardwareMap hm, Telemetry tm, Gamepad gp1, Gamepad gp2) {
		try {
			r.init(hm, tm); // used try/catch to please android studio :)
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		this.gp1 = gp1;
		this.gp2 = gp2;
	}

	// detects button press and adjusts lift motor
	public void detectBP() {
		//reset power
		r.winch.setPower(0);
		// lift ascends
		if(gp1.a)
			r.winch.setPower(1);
		// lift descends
		else if(gp1.b)
			r.winch.setPower(-1);
		// lift stops moving if you press nothing
		else
			r.winch.setPower(0);
	}
}
