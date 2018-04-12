public class Timer
{
	private long lastStart;
	private long elapsedTime;
	private String message;
	private boolean timerIsRunning;

	private static void sleep(long millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}



	/*public static void main(String[] args)
	{
		Timer x;

		x = new Timer("Hello");

			x.execute(Timer.TimerControl.Start);
			sleep(1000);
			x.execute(Timer.TimerControl.Stop);
			x.execute(Timer.TimerControl.Start);
			sleep(1000);
			x.execute(Timer.TimerControl.Stop);
			System.out.println(x);

		x.start();
		sleep(1000);
		x.stop();
		x.start();
		sleep(1000);
		x.stop();
		System.out.println(x);

	}*/

	public enum TimerControl
	{
		Start,
		Stop,
		Reset
	}

	public void execute(TimerControl timerControl)
	{
		switch(timerControl)
		{
			case Start: {this.start(); break;}
			case Stop: {this.stop(); break;}
			case Reset: {this.reset(); break;}
			default:
			{
				throw new IllegalArgumentException(timerControl+ " Doesn't fit any of the cases");
			}
		}
	}

	private long now()
	{
		return System.currentTimeMillis();
	}

	public Timer(String message)
	{
		this.message = message;
	}//Timer(String message)

	public void start()
	{
		if(!timerIsRunning)
		{
			this.lastStart = now();
			this.timerIsRunning = true;
		}
	}//start()

	public void stop()
	{
		if(timerIsRunning)
		{
			elapsedTime = getMillis() + (now() - this.lastStart);
			this.timerIsRunning = false;
		}
	}//stop()

	public void reset()
	{
		this.elapsedTime = 0;
	}//reset()

	public long getMillis()
	{
		return this.elapsedTime;
	}//getMillis()

	public String toString()
	{
		return this.message + getMillis();
	}//toString()

}//class Timer