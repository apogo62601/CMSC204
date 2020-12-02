import java.util.ArrayDeque;

import java.util.Queue;

import java.util.Random;



public class CarQueue{



	Queue<Integer> queue = new ArrayDeque<Integer>();

	Random r = new Random();

	public CarQueue(){

		
		for(int i = 0; i<5;i++){

			queue.add(r.nextInt(4));

		}

	}

	public void addToQueue(){

		class myRunnable implements Runnable{

			

			@Override

			public void run() {

				try{

					queue.add(r.nextInt(4));

					queue.add(r.nextInt(4));

					queue.add(r.nextInt(4));

					queue.add(r.nextInt(4));

					queue.add(r.nextInt(4));

					Thread.sleep(1000);

				}catch (InterruptedException exception){

				}

			}

		}

		Runnable runing = new myRunnable();

		Thread t = new Thread(runing);

		t.start();

	}

	

	public int deleteQueue(){

		if(queue.isEmpty()){

			return 0;

		}

		else return queue.remove();

	}



}