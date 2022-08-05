package tech.dhjt.eureka.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Before;
import org.junit.Test;

//@Test
public class TestChannel {

	@Before
	public void init() {

	}

	@Test
	public void test3() throws IOException {
		System.out.println(System.nanoTime());
		System.out.println(String.valueOf(System.nanoTime()).length());
		System.out.println(System.currentTimeMillis());
		System.out.println(String.valueOf(System.currentTimeMillis()).length());

	}

	@Test
	public void test2() throws IOException {
//		FileChannel newByteChannel = Files.newByteChannel(Paths.get("1.jpg"), StandardOpenOption.READ);
		FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW );

	}

	@Test
	public void test1() throws IOException {
		FileInputStream fis = new FileInputStream("");
		FileOutputStream fos = new FileOutputStream("");

		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(1024);

		while(inChannel.read(buf) != 1) {
			buf.flip();

			outChannel.write(buf);
			buf.clear();
		}

		outChannel.close();
		inChannel.close();
		fos.close();
		fis.close();

	}

}
