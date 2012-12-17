class MyTest1 {


	class Producer extends Thread {
		Panel pan = null;
		Consumer c = null;

		public Producer(Panel pan, Consumer c) {
			this.pan = pan;
			this.c = c;
		}

		public void run() {
			synchronized (c) {
				int count = 0;
				// 生产者一共要生产100个桔子
				while (count++ < 100) {
					if (!pan.isBlank) {
						try {
							c.wait();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					int orgWeight = (int) (Math.random() * 100);
					Orange org = new Orange(orgWeight, "red");
					pan.putOrange(org);
					c.notify();
				}
			}
		}
	}

	class Consumer extends Thread {
		Panel pan;

		public Consumer(Panel pan) {
			this.pan = pan;
		}

		public void run() {
			synchronized (this) {
				while (true) {
					if (pan.isBlank) {
						try {
							wait();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					pan.getOrange();
					notify();
				}
			}
		}
	}

	class Orange {
		int weight;
		String color;

		public Orange(int weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public String toString() {
			return "Orange, weight = " + weight + ", color = " + color;
		}
	}

	class Panel {
		public boolean isBlank = true;
		private Orange org;

		public void putOrange(Orange org) {
			this.org = org;
			isBlank = false;
			System.out.println("I put: " + org.toString());
		}

		public Orange getOrange() {
			System.out.println("I get: " + org.toString());
			isBlank = true;
			return org;
		}
	}
	public static void main(String[] args) {
		MyTest1 s= new MyTest1();
		Panel pan = s.new Panel();
		Consumer c = s.new Consumer(pan);
		Producer p = s.new Producer(pan, c);
		c.setDaemon(true);/* 将消费者设为守护线程，也就是说，当生产者不再生产时，消费者立即主动不再消费 */
		p.start();
		c.start();
	}
}