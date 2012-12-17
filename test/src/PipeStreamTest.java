import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PipeStreamTest {
	/**
	 * I/O����������is�ж�ȡ���ݣ�Ȼ������д�ӵ�os�С�
	 */
	interface IOFilter {
		void filter(InputStream is, OutputStream os) throws IOException;
	}
	
	private static void transfer(InputStream is, OutputStream os) throws IOException {
		while (true) {
			int b = is.read();
			if (b == -1) break;
			os.write(b);
			os.flush();
		}
	}
	
	/** �ӱ�׼�����ж�ȡȻ����д��os�� */
	static class StdinReadFilter implements IOFilter {
		public void filter(InputStream is, OutputStream os) throws IOException {
			transfer(System.in, os);
		}
	}
	/** ��is�ж�ȡȻ����д���׼����� */
	static class StdoutWriteFilter implements IOFilter {
		public void filter(InputStream is, OutputStream os) throws IOException {
			transfer(is, System.out);
		}
	}
	/** ��is�ж�ȡȻ����д��os�� */
	static class EchoFilter implements IOFilter {
		public void filter(InputStream is, OutputStream os) throws IOException {
			transfer(is, os);
		}
	}
	/** ��������ת���ɴ�д��Ȼ�󶨳���������� */
	static class UppcaseFilter implements IOFilter {
		public void filter(InputStream is, OutputStream os) throws IOException {
			while (true) {
				int b = is.read();
				if (b == -1) break;
				b = Character.toUpperCase(b);
				os.write(b);os.flush();
			}
		}
	}
	
	static class PipeThread extends Thread {
		private IOFilter filter;
		private PipedInputStream pis;
		private PipedOutputStream pos;
		
		public PipeThread(IOFilter filter, PipedInputStream pis, PipedOutputStream pos) {
			this.filter = filter;
			this.pis = pis;
			this.pos = pos;
		}
		
		public void run() {
			try {
				filter.filter(pis, pos);
				pis.close();
				pos.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	// ��IOFilterʹ�ùܵ�����������
	private static PipedInputStream concatFilterUsingPipeThread(PipedOutputStream pos, List<IOFilter> filters) throws IOException {
		PipedInputStream pis = new PipedInputStream(pos);
		for (IOFilter filter : filters) {
			pos = new PipedOutputStream();
			new PipeThread(filter, pis, pos).start();
			pis = new PipedInputStream(pos);
		}
		return pis;
	}
	
	public static void main(String[] args) throws IOException {
		List<IOFilter> filters = new ArrayList<IOFilter>();
		filters.add(new StdinReadFilter());
		filters.add(new EchoFilter());
		filters.add(new UppcaseFilter());
		filters.add(new StdoutWriteFilter());
		
		PipedInputStream pis = concatFilterUsingPipeThread(new PipedOutputStream(), filters);
	}
}
