package org.apache.maven.doxia.module.markdown;

import java.io.IOException;

import org.apache.maven.doxia.parser.ParseException;

public class MarkdownParseException extends ParseException {
	public MarkdownParseException(String msg,IOException e) {
		super(msg,e);
	}

	private static final long serialVersionUID = 2396858877962343011L;

}
