package david;

class MiHebra extends Thread{
	public boolean _tabulador;
	public Thread _thread;
	public MiHebra(boolean tabulador){
		_tabulador = tabulador;
	}
	
	public void setOtherThread(Thread thread){
		_thread = thread;
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		if(_tabulador) suspend();
		long num = 0;
		
		while(true){
			if(num % 100 == 0){
				if(_tabulador){
					System.out.print("\t");
				}
				System.out.println(num);
				_thread.resume();
				suspend();
			}
			num++;
		}
	}
}

public class SuspendResume {

	public static void main(String[] args) {
		MiHebra mh1, mh2;
		
		mh1 = new MiHebra(true);
		mh2 = new MiHebra(false);
		
		mh1.setOtherThread(mh2);
		mh2.setOtherThread(mh1);
		
		mh1.start();
		mh2.start();

	}

}
