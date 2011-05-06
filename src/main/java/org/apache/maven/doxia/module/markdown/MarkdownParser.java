package org.apache.maven.doxia.module.markdown;

import java.io.IOException;
import java.io.Reader;

import org.apache.maven.doxia.parser.AbstractParser;
import org.apache.maven.doxia.parser.ParseException;
import org.apache.maven.doxia.sink.Sink;

import com.petebevin.markdown.MarkdownProcessor;

/**
 * @plexus.component role="org.apache.maven.doxia.parser.Parser"
 *                   role-hint="markdown"
 * @version $Id$
 * @author <a href="mailto:decamps@users.sf.net">Régis Décamps</a>
 * @see http://maven.apache.org/doxia/developers/index.html
 */
public class MarkdownParser extends AbstractParser {

	public void parse(Reader reader, Sink sink) throws ParseException {
		getLog().info("markdown.parse()");
		MarkdownProcessor processor = new MarkdownProcessor();

		String txt;
		try {
			txt = readText(reader);
			getLog().info("Markdown content is " + txt); // XXX
		} catch (IOException e) {
			throw new MarkdownParseException("Cannot read input file", e);
		}

		String html = processor.markdown(txt);

		sink.rawText(html);

		sink.flush();
		sink.close();

	}

	/**
	 * Reads a the content of the Reader.
	 *
	 * @param reader
	 * @return the String that this reader provides.
	 * @throws IOException
	 */
	private String readText(Reader reader) throws IOException {
		StringBuffer sb = new StringBuffer();
		char[] buffer = new char[256];
		int count = 0;
		while ((count = reader.read(buffer)) > 0) {
			String readData = String.valueOf(buffer, 0, count);
			sb.append(readData);
			buffer = new char[1024];
		}
		reader.close();
		return sb.toString();
	}
}
