package hu.course.spring.core.loggers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

import hu.course.spring.core.beans.Event;

public class FileEventLogger implements EventLogger {

	private String fileName;
	private File file;

	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}

	public void init() throws IOException {
		this.file = new File(fileName);
		if (!file.canWrite()) {
			throw new IOException("The file with the given name " + fileName + " can not be written");
		}
	}

	@Override
	public void logEvent(String msg) throws IOException {
		if (!msg.endsWith("\n")) {
			msg += "\n";
		}
		FileUtils.writeStringToFile(new File(fileName), msg, Charset.defaultCharset(), true);

	}

	@Override
	public void logEvent(Event event) throws IOException {
		logEvent(event);
	}

}
